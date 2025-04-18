package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Controller.ClassController;
import com.project.onlineTeach.Mapper.ClassMapper;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Class;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Xuanxiu;
import com.project.onlineTeach.service.ClassService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
   private ClassMapper classMapper;
    public  Integer getNumber(Integer classId){
        return classMapper.getNumber(classId);
    }
    @Override
    public Class getClassInfo(Integer classId) {
       return   classMapper.getClassInfo(classId);
    }

    @Override
    public void addClass(Class newClass) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String teaId = (String) map.get("username");
        newClass.setTeaId(teaId);
        classMapper.addClass(newClass);
    }

    @Override
    public void delClass(Integer classId) {
        classMapper.delClass(classId);
    }

    @Override
    public void addStuToClass(String stuId, Integer classId) {
        classMapper.addStuToClass(stuId,classId);
        getNumber( classId);

    }

    @Override
    public void giveFinalScore(Integer score,String stuId, Integer classId) {
        classMapper.giveFinalScore(score,stuId,classId);
    }

    @Override
    public void batchImport(MultipartFile file) throws Exception {
        List<Xuanxiu> studentClasses = parseExcelFile(file);
        classMapper.batchAddStudentsToClass(studentClasses);


    }

    @Override
    public List<ClassController.ClassAndCourse> getAllClass() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String stuId = (String) map.get("username");
       return   classMapper.getAllClass(stuId);
    }

    @Override
    public Integer getSummaryScore(String stuId, Integer classId) {
        return classMapper.getSummaryScore(stuId,classId);
    }

    @Override
    public List<ClassController.ClassAndCourse> teaGetClass() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String teaId = (String) map.get("username");
     return    classMapper.teaGetClass(teaId);
    }

    @Override
    public void delFormClass(String stuId, Integer classId) {
        classMapper.delFormClass(stuId,classId);
    }

    private List<Xuanxiu> parseExcelFile(MultipartFile file) throws Exception {
        List<Xuanxiu> studentClasses = new ArrayList<>();
        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Skip header row
                    continue;
                }
                Xuanxiu studentClass = new Xuanxiu();

                Cell stuIdCell = row.getCell(0);
                if (stuIdCell.getCellType() == CellType.STRING) {
                    studentClass.setStuId(stuIdCell.getStringCellValue());
                } else if (stuIdCell.getCellType() == CellType.NUMERIC) {
                    studentClass.setStuId(String.valueOf((int) stuIdCell.getNumericCellValue()));
                }

                Cell classIdCell = row.getCell(1);
                if (classIdCell.getCellType() == CellType.NUMERIC) {
                    studentClass.setClassId((int) classIdCell.getNumericCellValue());
                } else if (classIdCell.getCellType() == CellType.STRING) {
                    studentClass.setClassId(Integer.parseInt(classIdCell.getStringCellValue()));
                }

                studentClasses.add(studentClass);
            }
        }
        return studentClasses;
    }

}
