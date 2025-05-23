-- 创建章节表
DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter` (
  `chapterId` int NOT NULL AUTO_INCREMENT COMMENT '章节ID',
  `courseId` varchar(20) NOT NULL COMMENT '所属课程ID',
  `title` varchar(100) NOT NULL COMMENT '章节标题',
  `orderNum` int DEFAULT NULL COMMENT '章节顺序',
  `description` varchar(200) DEFAULT NULL COMMENT '章节描述',
  PRIMARY KEY (`chapterId`),
  KEY `chapter_course_fk` (`courseId`),
  CONSTRAINT `chapter_course_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COMMENT='课程章节表';
/*!40101 SET character_set_client = @saved_cs_client */;

-- 插入示例数据
LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
INSERT INTO `chapter` VALUES 
(1, '10001', '第一章 课程介绍', 1, '介绍课程的基本内容和学习目标'),
(2, '10001', '第二章 基础知识', 2, '讲解课程的基础理论知识'),
(3, '10001', '第三章 进阶内容', 3, '深入探讨课程的核心概念'),
(4, '10001', '第四章 实践应用', 4, '通过实例讲解课程的应用场景'),
(5, '10001', '第五章 前沿技术', 5, '介绍该领域的最新研究成果和技术趋势'),
(6, '10001', '第六章 总结与展望', 6, '总结课程内容并展望未来发展方向');
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

-- 创建章节文件表
DROP TABLE IF EXISTS `chapter_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter_file` (
  `fileId` int NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `chapterId` int NOT NULL COMMENT '所属章节ID',
  `fileName` varchar(100) NOT NULL COMMENT '文件名称',
  `fileUrl` varchar(255) NOT NULL COMMENT '文件URL',
  `fileType` varchar(20) DEFAULT NULL COMMENT '文件类型(video-视频, ppt-幻灯片, pdf-文档)',
  `uploadTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `description` varchar(200) DEFAULT NULL COMMENT '文件描述',
  PRIMARY KEY (`fileId`),
  KEY `chapter_file_chapter_fk` (`chapterId`),
  CONSTRAINT `chapter_file_chapter_fk` FOREIGN KEY (`chapterId`) REFERENCES `chapter` (`chapterId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COMMENT='章节文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

-- 插入示例数据
LOCK TABLES `chapter_file` WRITE;
/*!40000 ALTER TABLE `chapter_file` DISABLE KEYS */;
INSERT INTO `chapter_file` VALUES 
(1, 1, '课程介绍.pdf', 'https://big-event0713.oss-cn-shanghai.aliyuncs.com/0%20%E8%AF%BE%E7%A8%8B%E5%AE%89%E6%8E%92.ppt', 'pdf', NOW(), '课程介绍文档'),
(2, 1, '课程介绍视频', 'https://big-event0713.oss-cn-shanghai.aliyuncs.com/TRAVLE%20WITH%20ME%20-%20Google%20Chrome%202024-05-22%2016-54-33.mp4', 'video', NOW(), '课程介绍视频'),
(3, 2, '基础知识PPT', 'https://big-event0713.oss-cn-shanghai.aliyuncs.com/0%20%E8%AF%BE%E7%A8%8B%E5%AE%89%E6%8E%92.ppt', 'ppt', NOW(), '基础知识讲解幻灯片'),
(4, 3, '进阶内容讲解', 'https://big-event0713.oss-cn-shanghai.aliyuncs.com/0%20%E8%AF%BE%E7%A8%8B%E5%AE%89%E6%8E%92.ppt', 'ppt', NOW(), '进阶内容讲解幻灯片'),
(5, 4, '实践案例视频', 'https://big-event0713.oss-cn-shanghai.aliyuncs.com/TRAVLE%20WITH%20ME%20-%20Google%20Chrome%202024-05-22%2016-54-33.mp4', 'video', NOW(), '实践案例视频讲解');
/*!40000 ALTER TABLE `chapter_file` ENABLE KEYS */;
UNLOCK TABLES;

-- 创建学生章节完成记录表
DROP TABLE IF EXISTS `chapter_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter_progress` (
  `progressId` int NOT NULL AUTO_INCREMENT COMMENT '进度ID',
  `stuId` varchar(20) NOT NULL COMMENT '学生ID',
  `chapterId` int NOT NULL COMMENT '章节ID',
  `completed` tinyint(1) DEFAULT 0 COMMENT '是否完成 0-未完成 1-已完成',
  `completedTime` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`progressId`),
  UNIQUE KEY `stu_chapter_unique` (`stuId`, `chapterId`),
  KEY `chapter_progress_chapter_fk` (`chapterId`),
  CONSTRAINT `chapter_progress_student_fk` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`),
  CONSTRAINT `chapter_progress_chapter_fk` FOREIGN KEY (`chapterId`) REFERENCES `chapter` (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COMMENT='学生章节进度表';
/*!40101 SET character_set_client = @saved_cs_client */;

-- 插入示例数据
LOCK TABLES `chapter_progress` WRITE;
/*!40000 ALTER TABLE `chapter_progress` DISABLE KEYS */;
INSERT INTO `chapter_progress` VALUES 
(1, '221310411', 1, 1, NOW());
/*!40000 ALTER TABLE `chapter_progress` ENABLE KEYS */;
UNLOCK TABLES;