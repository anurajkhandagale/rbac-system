import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");

        UsersDAO dao = new UsersDAO();
        Users user = dao.login(mobile, password);

        if (user != null) {

            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                res.sendRedirect("admin_home.jsp");
            } else {
                res.sendRedirect("user_home.jsp");
            }

        } else {
            res.getWriter().println("Invalid Credentials");
        }
    }
}