
package com.nitish.sms.model.controller;

import com.nitish.sms.model.dao.StudentDAO;
import com.nitish.sms.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    @Override
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            int studentId = Integer.parseInt(request.getParameter("student_id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            long phone = Long.parseLong(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String course = request.getParameter("course");
            String branch = request.getParameter("branch");
            String address = request.getParameter("address");

            Student student = new Student();

            student.setStudent_id(studentId);
            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            student.setGender(gender);
            student.setCourse(course);
            student.setBranch(branch);
            student.setAddress(address);

            studentDAO.addStudent(student);

            response.sendRedirect(
                    request.getContextPath() + "/views/viewStudent.jsp");
        }else if ("update".equals(action)) {

            int studentId = Integer.parseInt(
                    request.getParameter("student_id"));

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            long phone = Long.parseLong(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String course = request.getParameter("course");
            String branch = request.getParameter("branch");
            String address = request.getParameter("address");

            Student student = new Student();

            student.setStudent_id(studentId);
            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            student.setGender(gender);
            student.setCourse(course);
            student.setBranch(branch);
            student.setAddress(address);

            boolean updated = studentDAO.updateStudent(student);

            if (updated) {
                response.sendRedirect(
                        request.getContextPath() + "/student?action=view");
            } else {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND,
                        "Student not found or no update was made");
            }
        }else if ("delete".equals(action)) {

            int studentId = Integer.parseInt(
                    request.getParameter("student_id")
            );

            boolean deleted = studentDAO.deleteStudent(studentId);

            if (deleted) {
                response.sendRedirect(
                        request.getContextPath() + "/student?action=view"
                );
            } else {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND,
                        "Student not found"
                );
            }
        }
    }


    @Override
    public void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("view".equals(action)) {

            List<Student> students = studentDAO.viewAllStudents();
            request.setAttribute("students", students);

            request.getRequestDispatcher("/views/viewStudent.jsp")
                    .forward(request, response);

        } else if ("edit".equals(action)) {

            int studentId = Integer.parseInt(
                    request.getParameter("id"));

            Student student = studentDAO.searchStudent(studentId);

            if (student != null) {
                request.setAttribute("student", student);

                request.getRequestDispatcher("/views/editStudent.jsp")
                        .forward(request, response);
            } else {
                response.sendRedirect(
                        request.getContextPath() + "/student?action=view");
            }

        } else if ("dashboard".equals(action)) {

            response.sendRedirect(
                    request.getContextPath() + "/admin?action=dashboard");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
