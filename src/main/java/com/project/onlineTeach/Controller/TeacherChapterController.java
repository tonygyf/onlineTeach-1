package com.project.onlineTeach.Controller;

import com.project.onlineTeach.Util.AliOssUtil;
import com.project.onlineTeach.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/teacher/chapter")
public class TeacherChapterController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加课程章节
     * @param params 请求参数
     * @return 添加结果
     */
    @PostMapping("/add")
    public Result<Map<String, Object>> addChapter(@RequestBody Map<String, Object> params) {
        String courseId = (String) params.get("courseId");
        String title = (String) params.get("title");
        Integer orderNum = (Integer) params.get("orderNum");
        String description = (String) params.get("description");
        
        try {
            String sql = "INSERT INTO chapter (courseId, title, orderNum, description) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, courseId, title, orderNum, description);
            
            // 获取新插入的章节ID
            String querySql = "SELECT MAX(chapterId) as chapterId FROM chapter WHERE courseId = ? AND title = ?";
            Map<String, Object> result = jdbcTemplate.queryForMap(querySql, courseId, title);
            
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加章节失败: " + e.getMessage());
        }
    }

    /**
     * 删除课程章节
     * @param chapterId 章节ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{chapterId}")
    public Result<String> deleteChapter(@PathVariable Integer chapterId) {
        try {
            // 先删除章节下的所有文件
            String deleteFilesSql = "DELETE FROM chapter_file WHERE chapterId = ?";
            jdbcTemplate.update(deleteFilesSql, chapterId);
            
            // 删除章节进度记录
            String deleteProgressSql = "DELETE FROM chapter_progress WHERE chapterId = ?";
            jdbcTemplate.update(deleteProgressSql, chapterId);
            
            // 删除章节
            String deleteChapterSql = "DELETE FROM chapter WHERE chapterId = ?";
            jdbcTemplate.update(deleteChapterSql, chapterId);
            
            return Result.success("删除章节成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除章节失败: " + e.getMessage());
        }
    }

    /**
     * 删除章节文件
     * @param fileId 文件ID
     * @return 删除结果
     */
    @DeleteMapping("/file/delete/{fileId}")
    public Result<String> deleteChapterFile(@PathVariable Integer fileId) {
        try {
            // 获取文件信息，以便后续可以从OSS中删除文件（如果需要）
            String getFileSql = "SELECT fileUrl FROM chapter_file WHERE fileId = ?";
            Map<String, Object> fileInfo = jdbcTemplate.queryForMap(getFileSql, fileId);
            
            // 删除文件记录
            String deleteFileSql = "DELETE FROM chapter_file WHERE fileId = ?";
            jdbcTemplate.update(deleteFileSql, fileId);
            
            // 注意：这里没有实现从OSS中删除文件的功能，如果需要，可以调用AliOssUtil中的删除方法
            
            return Result.success("删除文件成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除文件失败: " + e.getMessage());
        }
    }

    /**
     * 获取课程章节列表
     * @param courseId 课程ID
     * @return 章节列表
     */
    @GetMapping("/list/{courseId}")
    public Result<List<Map<String, Object>>> getChaptersByCourse(@PathVariable String courseId) {
        try {
            String sql = """
                SELECT c.*, 
                       (SELECT COUNT(*) FROM chapter_file cf WHERE cf.chapterId = c.chapterId) as fileCount
                FROM chapter c 
                WHERE c.courseId = ? 
                ORDER BY c.orderNum
                """;
            List<Map<String, Object>> chapters = jdbcTemplate.queryForList(sql, courseId);
            return Result.success(chapters);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取章节列表失败: " + e.getMessage());
        }
    }

    /**
     * 获取章节文件列表
     * @param chapterId 章节ID
     * @return 文件列表
     */
    @GetMapping("/files/{chapterId}")
    public Result<List<Map<String, Object>>> getChapterFiles(@PathVariable Integer chapterId) {
        try {
            String sql = "SELECT * FROM chapter_file WHERE chapterId = ? ORDER BY uploadTime DESC";
            List<Map<String, Object>> files = jdbcTemplate.queryForList(sql, chapterId);
            return Result.success(files);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取章节文件列表失败: " + e.getMessage());
        }
    }

    /**
     * 上传章节文件
     * @param file 文件
     * @param chapterId 章节ID
     * @param fileName 文件名
     * @param fileType 文件类型
     * @param description 文件描述
     * @return 上传结果
     */
    @PostMapping("/file/upload")
    public Result<Map<String, Object>> uploadChapterFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("chapterId") Integer chapterId,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileType") String fileType,
            @RequestParam("description") String description) {
        try {
            // 上传文件到OSS
            String fileUrl = AliOssUtil.uploadFile(file.getOriginalFilename(), file.getInputStream());
            
            // 保存文件信息到数据库
            String sql = "INSERT INTO chapter_file (chapterId, fileName, fileUrl, fileType, description, uploadTime) VALUES (?, ?, ?, ?, ?, ?)";
            String uploadTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            jdbcTemplate.update(sql, chapterId, fileName, fileUrl, fileType, description, uploadTime);
            
            // 获取新插入的文件ID
            String querySql = "SELECT MAX(fileId) as fileId FROM chapter_file WHERE chapterId = ? AND fileName = ?";
            Map<String, Object> result = jdbcTemplate.queryForMap(querySql, chapterId, fileName);
            
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("上传文件失败: " + e.getMessage());
        }
    }
}