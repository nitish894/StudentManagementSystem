package com.nitish.sms.model.util;

import com.nitish.sms.model.Student;
import com.nitish.sms.model.dao.StudentDAO;

public class TestStudentDAO {
    public static void main(String[] args) {


        Student student = new Student();

        student.setStudent_id(101);
        student.setName("Nitish");
        student.setEmail("nitish@gmail.com");
        student.setPhone(9876543210L);
        student.setGender("Male");
        student.setCourse("BTech");
        student.setBranch("CSE");
        student.setAddress("Jharkhand");
//
        StudentDAO dao = new StudentDAO();
//        dao.addStudent(student);
//        dao.viewAllStudent();
//        dao.updateStudent(101,"MBA");
//        dao.deleteStudent(101);
//        dao.searchStudent(101);
    }
}
