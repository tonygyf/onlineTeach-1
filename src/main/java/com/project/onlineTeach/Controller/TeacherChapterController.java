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
}