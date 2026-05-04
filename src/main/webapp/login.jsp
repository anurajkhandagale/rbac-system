<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<div class="container">
    <h2>Login</h2>
    <form action="login" method="post">
        <input type="text" name="mobile" placeholder="Mobile" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>