<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-7">

            <div class="card shadow border-0">
                <div class="card-header bg-primary text-white text-center py-3">
                    <h3 class="mb-0">Add New Student</h3>
                    <small>Student Management System</small>
                </div>

                <div class="card-body p-4">

                    <form action="${pageContext.request.contextPath}/student"
                          method="post">

                        <input type="hidden" name="action" value="add">

                        <div class="mb-3">
                            <label class="form-label">Student ID</label>
                            <input type="number" name="student_id"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input type="text" name="name"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Phone</label>
                            <input type="tel" name="phone"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Gender</label>
                            <select name="gender" class="form-select" required>
                                <option value="">Select Gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Course</label>
                            <input type="text" name="course"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Branch</label>
                            <input type="text" name="branch"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <textarea name="address" class="form-control"
                                      rows="3" required></textarea>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">
                                Add Student
                            </button>

                           <a href="${pageContext.request.contextPath}/student?action=view"
                              class="btn btn-outline-secondary">
                               View Students
                           </a>
                            </a>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
