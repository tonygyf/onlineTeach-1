-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlineteach
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `accId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名(学号、工号、管理员号)',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像URL',
  `type` int NOT NULL COMMENT '账号类型0-管理员 1-老师  2-学生',
  PRIMARY KEY (`accId`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3 COMMENT='账号表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'221310411','e10adc3949ba59abbe56e057f20f883e','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg',2),(2,'221310332','e10adc3949ba59abbe56e057f20f883e','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg',2),(5,'221310410','e10adc3949ba59abbe56e057f20f883e','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg',1),(6,'10320101','e10adc3949ba59abbe56e057f20f883e','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg',3),(52,'100001','e10adc3949ba59abbe56e057f20f883e',NULL,0),(55,'123298890','e10adc3949ba59abbe56e057f20f883e',NULL,0),(56,'10000013','password',NULL,0),(57,'10000013','password',NULL,0),(58,'10000013','password',NULL,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `job` varchar(20) DEFAULT NULL COMMENT '职务',
  `accId` int NOT NULL COMMENT '关联用户表',
  PRIMARY KEY (`adminId`),
  KEY `accId` (`accId`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`accId`) REFERENCES `account` (`accId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'男','教务处',6),(7,'男','学工部',52),(8,'男','xs',55);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ansrecord`
--

DROP TABLE IF EXISTS `ansrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ansrecord` (
  `stuId` varchar(20) NOT NULL COMMENT '学生ID',
  `paperExeId` smallint NOT NULL COMMENT '考卷题目ID',
  `stuAns` text COMMENT '学生答案',
  `stuScore` smallint DEFAULT NULL COMMENT '学生得分',
  PRIMARY KEY (`stuId`,`paperExeId`),
  KEY `paperExeId` (`paperExeId`),
  CONSTRAINT `ansrecord_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`),
  CONSTRAINT `ansrecord_ibfk_2` FOREIGN KEY (`paperExeId`) REFERENCES `paperexe` (`paperExeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='答题记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ansrecord`
--

LOCK TABLES `ansrecord` WRITE;
/*!40000 ALTER TABLE `ansrecord` DISABLE KEYS */;
INSERT INTO `ansrecord` VALUES ('221310411',47,'111',0),('221310411',48,'A',3),('221310411',49,'1',3);
/*!40000 ALTER TABLE `ansrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blank`
--

DROP TABLE IF EXISTS `blank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blank` (
  `blankId` smallint NOT NULL AUTO_INCREMENT COMMENT '填空题ID',
  `exeId` smallint NOT NULL COMMENT '题库ID号',
  `question` text COMMENT '题目',
  `ans` varchar(20) DEFAULT NULL COMMENT '答案',
  `ansText` text COMMENT '解析',
  PRIMARY KEY (`blankId`),
  KEY `exeId` (`exeId`),
  CONSTRAINT `blank_ibfk_1` FOREIGN KEY (`exeId`) REFERENCES `exercise` (`exeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='填空题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blank`
--

LOCK TABLES `blank` WRITE;
/*!40000 ALTER TABLE `blank` DISABLE KEYS */;
INSERT INTO `blank` VALUES (6,123,'1','1','1');
/*!40000 ALTER TABLE `blank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choose`
--

DROP TABLE IF EXISTS `choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `choose` (
  `chooseId` smallint NOT NULL AUTO_INCREMENT COMMENT '选择题ID',
  `exeId` smallint NOT NULL COMMENT '题库ID号',
  `question` text COMMENT '题面',
  `ans` varchar(4) DEFAULT NULL COMMENT '正确选项',
  `optionA` varchar(100) DEFAULT NULL COMMENT '选项A',
  `optionB` varchar(100) DEFAULT NULL COMMENT '选项B',
  `optionC` varchar(100) DEFAULT NULL COMMENT '选项C',
  `optionD` varchar(100) DEFAULT NULL COMMENT '选项D',
  `ansText` text COMMENT '解析',
  PRIMARY KEY (`chooseId`),
  KEY `exeId` (`exeId`),
  CONSTRAINT `choose_ibfk_1` FOREIGN KEY (`exeId`) REFERENCES `exercise` (`exeId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='选择题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choose`
--

LOCK TABLES `choose` WRITE;
/*!40000 ALTER TABLE `choose` DISABLE KEYS */;
INSERT INTO `choose` VALUES (12,15,'AAA1','A','AAAA1','AAA','AA','A','A');
/*!40000 ALTER TABLE `choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `classId` int NOT NULL AUTO_INCREMENT COMMENT '班组号',
  `stuNum` smallint DEFAULT NULL COMMENT '学生人数',
  `courseId` varchar(20) DEFAULT NULL COMMENT '课程号',
  `teaId` varchar(20) DEFAULT NULL COMMENT '教师编号',
  `logo` varchar(150) DEFAULT NULL COMMENT 'logoURL',
  PRIMARY KEY (`classId`),
  KEY `teaId` (`teaId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`teaId`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COMMENT='教学班级';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (3,0,'10001','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png'),(6,0,'10002','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png'),(7,0,'10003','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png'),(9,NULL,'10004','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png'),(12,0,'10006','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png'),(13,0,'1021021','221310410','https://big-event0713.oss-cn-shanghai.aliyuncs.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-04-18%20165205.png');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `commentId` smallint NOT NULL AUTO_INCREMENT COMMENT '留言ID',
  `commentUser` int NOT NULL COMMENT '留言者的ID',
  `type` smallint DEFAULT NULL COMMENT '类型 0-留言 1-回复',
  `replyToId` int DEFAULT NULL COMMENT '要回复的留言的ID',
  `content` text COMMENT '留言内容',
  `classId` int DEFAULT NULL,
  `commentName` varchar(20) DEFAULT NULL,
  `commentLogo` varchar(90) DEFAULT NULL,
  `commentTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `comment_class_classId_fk` (`classId`),
  CONSTRAINT `comment_class_classId_fk` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (47,1,0,NULL,'这是',3,'代佳诚','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg','2024-07-29 16:50:28'),(48,1,0,NULL,'发送\n',3,'代佳诚','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg','2024-07-29 16:50:41'),(51,1,0,NULL,'f',3,'代佳诚','https://big-event0713.oss-cn-shanghai.aliyuncs.com/71e360b3f7d360efe6e50741762e3e0.jpg','2024-07-31 14:12:24');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseId` varchar(20) NOT NULL COMMENT '课程编码',
  `courseName` varchar(20) DEFAULT NULL COMMENT '课程名',
  `credit` int DEFAULT NULL COMMENT '学分',
  `courseTime` varchar(20) DEFAULT NULL COMMENT '上课时间',
  `place` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `term` varchar(20) DEFAULT NULL COMMENT '开设学期',
  `syllabus` varchar(100) DEFAULT NULL COMMENT '教学大纲',
  `syllabusUrl` varchar(400) DEFAULT NULL COMMENT '教学大纲URL',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='课程信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('10001','机器学习12',2,'周一5-9','松1221','2022s-2023a','解机器学习的概念、技术','http://big-event0713.oss-cn-shanghai.aliyuncs.com/eafd4bfc-0ba1-4c2d-9cb0-231a88a6f180.pdf'),('10002','操作系统原理',2,'周一5-9','松1225','2022s-2023a','OS大纲',''),('10003','计算机组成原理',2,'周一5-9','松1225','2022s-2023a','计组大纲','http://www.baidu.com'),('10004','数据库系统原理',2,'1-16周 周四7-9节','松1443','2025s','',''),('10005','离散数学',3,'1-16周 周四7-9节','松1442','2024s','',''),('10006','人工智能',2,'1-8周 周四10-11','1246','2024a','',''),('1021021','C++',3,'1-16周 周三8-9','松1229','2024a','C++','');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examrecord`
--

DROP TABLE IF EXISTS `examrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examrecord` (
  `stuId` varchar(20) NOT NULL COMMENT '学生ID',
  `paperId` smallint NOT NULL COMMENT '考卷ID',
  `time` smallint DEFAULT NULL COMMENT '考试耗时(min)',
  `score` smallint DEFAULT NULL COMMENT '考试分数',
  `state` int DEFAULT NULL COMMENT '是否及格',
  PRIMARY KEY (`stuId`,`paperId`),
  KEY `paperId` (`paperId`),
  CONSTRAINT `examrecord_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`),
  CONSTRAINT `examrecord_ibfk_2` FOREIGN KEY (`paperId`) REFERENCES `paper` (`paperId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='考试记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examrecord`
--

LOCK TABLES `examrecord` WRITE;
/*!40000 ALTER TABLE `examrecord` DISABLE KEYS */;
INSERT INTO `examrecord` VALUES ('221310411',7,0,6,0);
/*!40000 ALTER TABLE `examrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `exeId` smallint NOT NULL AUTO_INCREMENT COMMENT '练习题编号',
  `type` varchar(20) DEFAULT NULL COMMENT '题目类型',
  `updateTime` datetime DEFAULT NULL COMMENT '修改日期',
  `classId` int DEFAULT NULL,
  PRIMARY KEY (`exeId`),
  KEY `exercise_class_classId_fk` (`classId`),
  CONSTRAINT `exercise_class_classId_fk` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb3 COMMENT='练习题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'选择题','2024-07-28 09:37:47',3),(2,'选择题','2024-07-20 19:20:29',3),(4,'填空题','2024-07-20 20:26:12',3),(6,'判断题','2024-07-20 21:10:57',3),(9,'简答题','2024-07-20 21:14:39',3),(10,'选择题','2024-07-26 12:10:27',3),(15,'选择题','2024-07-28 14:07:05',3),(121,'简答题','2024-07-30 20:25:59',3),(122,'判断题','2024-07-29 21:52:24',3),(123,'填空题','2024-07-31 14:06:40',3),(144,'填空题','2024-07-29 21:52:02',3),(145,'选择题','2024-07-29 21:51:44',3);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `judge`
--

DROP TABLE IF EXISTS `judge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `judge` (
  `judgeId` smallint NOT NULL AUTO_INCREMENT COMMENT '判断题ID',
  `exeId` smallint NOT NULL COMMENT '题库ID号',
  `question` text COMMENT '题面',
  `ans` int DEFAULT NULL COMMENT '正确答案 0 错 1 对',
  `ansText` text COMMENT '解析',
  PRIMARY KEY (`judgeId`),
  KEY `exeId` (`exeId`),
  CONSTRAINT `judge_ibfk_1` FOREIGN KEY (`exeId`) REFERENCES `exercise` (`exeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='判断题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `judge`
--

LOCK TABLES `judge` WRITE;
/*!40000 ALTER TABLE `judge` DISABLE KEYS */;
/*!40000 ALTER TABLE `judge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paper` (
  `paperId` smallint NOT NULL AUTO_INCREMENT COMMENT '试卷ID',
  `type` int DEFAULT NULL COMMENT '试卷类型 1-考试  0-练习',
  `tolScore` smallint DEFAULT NULL COMMENT '总分',
  `standardScore` smallint DEFAULT NULL COMMENT '及格分数',
  `startTime` varchar(30) DEFAULT NULL COMMENT '开始时间',
  `endTime` varchar(30) DEFAULT NULL COMMENT '结束时间',
  `updateTime` varchar(20) DEFAULT NULL COMMENT '修改日期',
  `state` int DEFAULT NULL COMMENT ' 状态  0-未发布  1-已发布',
  `duration` int DEFAULT NULL COMMENT '考试时间(单位分钟)',
  `classId` int DEFAULT NULL,
  `paperTitle` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`paperId`),
  KEY `paper_class_classId_fk` (`classId`),
  CONSTRAINT `paper_class_classId_fk` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='试卷';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES (7,0,100,60,'2024-07-21 14:57:20','2024-07-21 16:57:20','2024-07-21 15:57:15',0,120,3,'小测验1'),(8,0,100,60,'2024-07-21 14:57:20','2024-07-21 16:57:20','2024-07-22 15:20:49',1,120,3,'小测验2'),(9,1,100,60,'2024-07-21 14:57:20','2024-07-21 16:57:20','2024-07-22 15:23:24',1,120,3,'小测验3'),(10,0,100,90,'2024-04-03 08:40:00','2024-04-03 09:40:00','2024-07-28 13:01:25',NULL,60,3,NULL),(11,1,100,12,'2024-05-06 08:40:00','2024-05-06 09:40:00','2024-07-28 13:02:56',NULL,60,3,'测验');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paperexe`
--

DROP TABLE IF EXISTS `paperexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paperexe` (
  `paperExeId` smallint NOT NULL AUTO_INCREMENT COMMENT '试卷试题ID',
  `paperId` smallint DEFAULT NULL COMMENT '试卷ID',
  `exeId` smallint NOT NULL COMMENT '题目ID',
  `score` smallint DEFAULT NULL COMMENT '题目分值',
  PRIMARY KEY (`paperExeId`),
  KEY `paperId` (`paperId`),
  KEY `paperexe_ibfk_2` (`exeId`),
  CONSTRAINT `paperexe_ibfk_1` FOREIGN KEY (`paperId`) REFERENCES `paper` (`paperId`),
  CONSTRAINT `paperexe_ibfk_2` FOREIGN KEY (`exeId`) REFERENCES `exercise` (`exeId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3 COMMENT='试卷题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paperexe`
--

LOCK TABLES `paperexe` WRITE;
/*!40000 ALTER TABLE `paperexe` DISABLE KEYS */;
INSERT INTO `paperexe` VALUES (35,8,15,3),(45,8,121,3),(46,8,121,4),(47,7,121,1),(48,7,15,3),(49,7,123,3);
/*!40000 ALTER TABLE `paperexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shortans`
--

DROP TABLE IF EXISTS `shortans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shortans` (
  `shortAnsId` smallint NOT NULL AUTO_INCREMENT COMMENT '简答题ID',
  `exeId` smallint NOT NULL COMMENT '题库ID号',
  `question` text COMMENT '题面',
  `ans` text COMMENT '答案',
  `ansText` text COMMENT '解析',
  PRIMARY KEY (`shortAnsId`),
  KEY `exeId` (`exeId`),
  CONSTRAINT `shortans_ibfk_1` FOREIGN KEY (`exeId`) REFERENCES `exercise` (`exeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='简答题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shortans`
--

LOCK TABLES `shortans` WRITE;
/*!40000 ALTER TABLE `shortans` DISABLE KEYS */;
INSERT INTO `shortans` VALUES (5,121,'发的','发发发1','发发发');
/*!40000 ALTER TABLE `shortans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slides`
--

DROP TABLE IF EXISTS `slides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slides` (
  `slidesId` int NOT NULL AUTO_INCREMENT COMMENT '课件id',
  `courseId` varchar(20) DEFAULT NULL COMMENT '班组号ID',
  `title` varchar(30) DEFAULT NULL COMMENT '章节标题',
  `url` varchar(100) DEFAULT NULL COMMENT '课件URL',
  `sectionId` int DEFAULT NULL,
  PRIMARY KEY (`slidesId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `slides_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='课件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slides`
--

LOCK TABLES `slides` WRITE;
/*!40000 ALTER TABLE `slides` DISABLE KEYS */;
INSERT INTO `slides` VALUES (1,'10001','企业JAVA技术1','http://localhost:8080',1),(2,'10001','02 KNN','http://staff.ustc.edu.cn/~xlanchen/2011FallOS/slides/0_start.pdf',2),(3,'10002','同步与互斥','http://big-event0713.oss-cn-shanghai.aliyuncs.com/c7e5b17e-5e08-4aa1-9878-e6b0c6764bbc.pptx',3),(5,'10001','List','http://big-event0713.oss-cn-shanghai.aliyuncs.com/a892358d-868d-46f7-bc9e-1726a001a6c5.pdf',4);
/*!40000 ALTER TABLE `slides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `stuId` varchar(20) NOT NULL COMMENT '学号',
  `stuName` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `type` varchar(5) DEFAULT NULL COMMENT '类型：本硕博',
  `dept` varchar(20) DEFAULT NULL COMMENT '院系',
  `major` varchar(20) DEFAULT NULL COMMENT '专业',
  `grade` varchar(5) DEFAULT NULL COMMENT '入学年份',
  `adminClass` varchar(10) DEFAULT NULL COMMENT '行政班级',
  `accId` int NOT NULL COMMENT '关联账号表',
  PRIMARY KEY (`stuId`),
  KEY `student_account_accId_fk` (`accId`),
  CONSTRAINT `student_account_accId_fk` FOREIGN KEY (`accId`) REFERENCES `account` (`accId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='学生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('221310411','代佳诚','男','本科生','计算机科学与技术学院','软件工程','2022级','卓越软件2202',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teaId` varchar(20) NOT NULL COMMENT '教工号',
  `teaName` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `job` varchar(20) DEFAULT NULL COMMENT '职称',
  `courses` text COMMENT '讲授课程',
  `selfInfo` text COMMENT '个人简介',
  `accId` int DEFAULT NULL COMMENT '关联账号表',
  PRIMARY KEY (`teaId`),
  KEY `teacher_account_accId_fk` (`accId`),
  CONSTRAINT `teacher_account_accId_fk` FOREIGN KEY (`accId`) REFERENCES `account` (`accId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教师信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('221310410','教师1','男','13023111691','lili@dhu.edu.cn','副教授','离散数学、人工智能、软件测试','毕业于XX大学软件工程专业1',5);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuanxiu`
--

DROP TABLE IF EXISTS `xuanxiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xuanxiu` (
  `stuId` varchar(20) NOT NULL,
  `classId` int NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`stuId`,`classId`),
  KEY `classId` (`classId`),
  CONSTRAINT `xuanxiu_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`),
  CONSTRAINT `xuanxiu_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuanxiu`
--

LOCK TABLES `xuanxiu` WRITE;
/*!40000 ALTER TABLE `xuanxiu` DISABLE KEYS */;
INSERT INTO `xuanxiu` VALUES ('221310411',3,100),('221310411',7,0);
/*!40000 ALTER TABLE `xuanxiu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-18 16:59:27
