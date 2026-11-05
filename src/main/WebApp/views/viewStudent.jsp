<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>View Students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Student Management System</h2>

        <a href="${pageContext.request.contextPath}/views/addStudent.jsp"
           class="btn btn-primary">
            Add New Student
        </a>
    </div>

    <div class="card shadow border-0">

        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">All Students</h4>
        </div>

        <div class="card-body">

            <c:choose>

                <c:when test="${not empty students}">

                    <div class="table-responsive">

                        <table class="table table-bordered table-striped table-hover">

                            <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th>Course</th>
                                <th>Branch</th>
                                <th>Address</th>
                                <th>Action</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach var="student" items="${students}">

                                <tr>


                                    <td>${student.student_id}</td>
                                    <td><c:out value="${student.name}"/></td>
                                    <td><c:out value="${student.email}"/></td>
                                    <td>${student.phone}</td>
                                    <td><c:out value="${student.gender}"/></td>
                                    <td><c:out value="${student.course}"/></td>
                                    <td><c:out value="${student.branch}"/></td>
                                    <td><c:out value="${student.address}"/></td>

                                   <td>
                                       <a href="${pageContext.request.contextPath}/student?action=edit&id=${student.student_id}"
                                          class="btn btn-warning btn-sm">
                                           Edit
                                       </a>

                                       <form action="${pageContext.request.contextPath}/student"
                                             method="post" class="d-inline">

                                           <input type="hidden" name="action" value="delete">

                                           <input type="hidden" name="student_id"
                                                  value="${student.student_id}">

                                           <button type="submit" class="btn btn-danger btn-sm"
                                                   onclick="return confirm('Are you sure you want to delete this student?')">
                                               Delete
                                           </button>
                                       </form>
                                   </td>

                                </tr>

                            </c:forEach>

                            </tbody>

                        </table>

                    </div>

                </c:when>

                <c:otherwise>

                    <div class="alert alert-warning text-center">
                        No student records found!
                    </div>

                </c:otherwise>

            </c:choose>

        </div>
    </div>

</div>

</body>
</html>
