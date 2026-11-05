package com.nitish.sms.model.dao;

import com.nitish.sms.model.Student;
import com.nitish.sms.model.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {

    public void addStudent(Student student){
            String query= "INSERT INTO student " +
                    "(student_id, name, email, phone, gender, course, branch, address) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try( Connection connection = DBConnection.getConnection();
                 PreparedStatement pstm =connection.prepareStatement(query);){
                pstm.setInt(1,student.getStudent_id());
                pstm.setString(2,student.getName());
                pstm.setString(3,student.getEmail());
                pstm.setLong(4,student.getPhone());
                pstm.setString(5,student.getGender());
                pstm.setString(6,student.getCourse());
                pstm.setString(7,student.getBranch());
                pstm.setString(8,student.getAddress());

                int result=pstm.executeUpdate();

                if(result !=0){
                    System.out.println("data inserted successful");
                }else {
                    System.out.println("please reEnter the data");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public List<Student> viewAllStudents(){
            List<Student> students=new ArrayList<>();
        String query="SELECT * FROM student";

        try( Connection connection=DBConnection.getConnection();
             PreparedStatement pstm=connection.prepareStatement(query)){
            ResultSet result=pstm.executeQuery();
            while(result.next()){
                Student student=new Student();
               student.setStudent_id(result.getInt("student_id"));
                student.setName(result.getString("name"));
                student.setEmail(result.getString("email"));
                student.setPhone(result.getLong("phone"));
                student.setGender(result.getString("gender"));
                student.setCourse(result.getString("course"));
                student.setBranch(result.getString("branch"));
                student.setAddress(result.getString("address"));

              students.add(student);

                System.out.println("-------------------------------------------------------------");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    public boolean updateStudent(Student student) {

        String sql = "UPDATE student SET name=?, email=?, phone=?, " +
                "gender=?, course=?, branch=?, address=? " +
                "WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setLong(3, student.getPhone());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getCourse());
            ps.setString(6, student.getBranch());
            ps.setString(7, student.getAddress());
            ps.setInt(8, student.getStudent_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteStudent(int studentId) {

        String sql = "DELETE FROM student WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Student  searchStudent(int studentId){
        Student student=null;
        String query="SELECT * FROM student WHERE student_id= ?";
        try(Connection connection=DBConnection.getConnection();
        PreparedStatement pstm=connection.prepareStatement(query);){

            pstm.setInt(1,studentId);

           try( ResultSet result=pstm.executeQuery();){
               if(result.next()){
                   student=new Student();

                   student.setStudent_id(result.getInt("student_id"));
                   student.setName(result.getString("name"));
                   student.setEmail(result.getString("email"));
                   student.setPhone(result.getLong("phone"));
                   student.setGender(result.getString("gender"));
                   student.setCourse(result.getString("course"));
                   student.setBranch(result.getString("branch"));
                   student.setAddress(result.getString("address"));
               }
           }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

}
