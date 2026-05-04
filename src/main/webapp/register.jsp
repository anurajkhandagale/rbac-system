<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<div class="container">
    <h2>Register</h2>
    <form action="register" method="post">
        <input type="text" name="name" placeholder="Name" required>
        <input type="text" name="mobile" placeholder="Mobile" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
        <a href="login.jsp" class="secondary-btn">Go to Login</a>
    </form>
</div>