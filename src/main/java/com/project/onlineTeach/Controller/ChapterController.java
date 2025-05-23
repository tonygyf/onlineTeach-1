package com.project.onlineTeach.Controller;

import com.project.onlineTeach.Util.AliOssUtil;
import com.project.onlineTeach.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取课程的所有章节
     * @param courseId 课程ID
     * @return 章节列表
     */
    @GetMapping("/list/{courseId}")
    public Result<List<Map<String, Object>>> getChaptersByCourse(@PathVariable String courseId) {
        String sql = "SELECT c.*, "
                + "(SELECT COUNT(*) FROM chapter_file cf WHERE cf.chapterId = c.chapterId) AS fileCount, "
                + "(SELECT COUNT(*) FROM chapter_progress cp WHERE cp.chapterId = c.chapterId AND cp.stuId = ? AND cp.completed = 1) AS completed "
                + "FROM chapter c WHERE c.courseId = ? ORDER BY c.orderNum";
        
        // 从请求中获取学生ID，这里假设使用了某种认证机制
        String stuId = "221310411"; // 实际应用中应该从认证信息中获取
        
        try {
            List<Map<String, Object>> chapters = jdbcTemplate.queryForList(sql, stuId, courseId);
            return Result.success(chapters);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取章节信息失败");
        }
    }

    /**
     * 获取章节的所有文件
     * @param chapterId 章节ID
     * @return 文件列表
     */
    @GetMapping("/files/{chapterId}")
    public Result<List<Map<String, Object>>> getChapterFiles(@PathVariable Integer chapterId) {
        String sql = "SELECT * FROM chapter_file WHERE chapterId = ? ORDER BY uploadTime DESC";
        
        try {
            List<Map<String, Object>> files = jdbcTemplate.queryForList(sql, chapterId);
            return Result.success(files);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取章节文件失败");
        }
    }

    /**
     * 上传章节文件
     * @param chapterId 章节ID
     * @param fileName 文件名
     * @param fileType 文件类型
     * @param description 文件描述
     * @param file 文件内容
     * @return 上传结果
     */
    @PostMapping("/upload")
    public Result<Map<String, Object>> uploadChapterFile(
            @RequestParam("chapterId") Integer chapterId,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileType") String fileType,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) {
        try {
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
            
            // 上传文件到阿里云OSS
            String fileUrl = AliOssUtil.uploadFile(uniqueFileName, file.getInputStream());
            
            // 保存文件信息到数据库
            String sql = "INSERT INTO chapter_file (chapterId, fileName, fileUrl, fileType, description) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, chapterId, fileName, fileUrl, fileType, description);
            
            Map<String, Object> result = new HashMap<>();
            result.put("fileUrl", fileUrl);
            result.put("fileName", fileName);
            
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("文件上传失败: " + e.getMessage());
        }
    }

    /**
     * 更新学生章节完成状态
     * @param chapterId 章节ID
     * @param completed 是否完成
     * @return 更新结果
     */
    @PostMapping("/progress")
    public Result<String> updateChapterProgress(
            @RequestParam("chapterId") Integer chapterId,
            @RequestParam("completed") Boolean completed) {
        // 从请求中获取学生ID，这里假设使用了某种认证机制
        String stuId = "221310411"; // 实际应用中应该从认证信息中获取
        
        try {
            // 检查记录是否存在
            String checkSql = "SELECT COUNT(*) FROM chapter_progress WHERE stuId = ? AND chapterId = ?";
            int count = jdbcTemplate.queryForObject(checkSql, Integer.class, stuId, chapterId);
            
            if (count > 0) {
                // 更新现有记录
                String updateSql = "UPDATE chapter_progress SET completed = ?, completedTime = ? WHERE stuId = ? AND chapterId = ?";
                jdbcTemplate.update(updateSql, completed ? 1 : 0, completed ? new Date() : null, stuId, chapterId);
            } else {
                // 插入新记录
                String insertSql = "INSERT INTO chapter_progress (stuId, chapterId, completed, completedTime) VALUES (?, ?, ?, ?)";
                jdbcTemplate.update(insertSql, stuId, chapterId, completed ? 1 : 0, completed ? new Date() : null);
            }
            
            return Result.success("进度更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("进度更新失败: " + e.getMessage());
        }
    }
}