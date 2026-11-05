<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">
            <h3>Edit Student Details</h3>
        </div>

        <div class="card-body">

            <form action="${pageContext.request.contextPath}/student"
                  method="post">

                <input type="hidden" name="action" value="update">

                <div class="mb-3">
                    <label class="form-label">Student ID</label>
                    <input type="number" name="student_id"
                           class="form-control"
                           value="${student.student_id}"
                           readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name"
                           class="form-control"
                           value="<c:out value='${student.name}'/>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email"
                           class="form-control"
                           value="<c:out value='${student.email}'/>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="tel" name="phone"
                           class="form-control"
                           value="${student.phone}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Gender</label>
                    <select name="gender" class="form-select" required>
                        <option value="Male"
                            ${student.gender == 'Male' ? 'selected' : ''}>
                            Male
                        </option>

                        <option value="Female"
                            ${student.gender == 'Female' ? 'selected' : ''}>
                            Female
                        </option>

                        <option value="Other"
                            ${student.gender == 'Other' ? 'selected' : ''}>
                            Other
                        </option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Course</label>
                    <input type="text" name="course"
                           class="form-control"
                           value="<c:out value='${student.course}'/>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Branch</label>
                    <input type="text" name="branch"
                           class="form-control"
                           value="<c:out value='${student.branch}'/>"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <textarea name="address"
                              class="form-control"
                              rows="3"
                              required><c:out value="${student.address}"/></textarea>
                </div>

                <button type="submit" class="btn btn-success">
                    Update Student
                </button>

                <a href="${pageContext.request.contextPath}/student?action=view"
                   class="btn btn-secondary">
                    Cancel
                </a>

            </form>

        </div>
    </div>
</div>

</body>
</html>
