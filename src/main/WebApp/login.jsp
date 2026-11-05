<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>Admin Login</h3>
                </div>

                <div class="card-body">

                    <%
                        String errorMessage =
                                (String) request.getAttribute("errorMessage");

                        if (errorMessage != null) {
                    %>
                        <div class="alert alert-danger">
                            <%= errorMessage %>
                        </div>
                    <%
                        }
                    %>

                    <form action="${pageContext.request.contextPath}/admin"
                          method="post">

                        <input type="hidden" name="action" value="login">

                        <div class="mb-3">
                            <label class="form-label">Email</label>

                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   placeholder="Enter your email"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>

                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   placeholder="Enter your password"
                                   required>
                        </div>

                        <button type="submit"
                                class="btn btn-primary w-100">
                            Login
                        </button>

                    </form>

                </div>

            </div>

        </div>

    </div>
</div>

</body>
</html>