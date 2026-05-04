import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
    public class RegisterServlet extends HttpServlet {

        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

            Users user = new Users();
            user.setName(req.getParameter("name"));
            user.setMobile(req.getParameter("mobile"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            UsersDAO dao = new UsersDAO();

            if (dao.registerUser(user)) {
                res.sendRedirect("login.jsp");
            } else {
                res.getWriter().println("Registration Failed");
            }
        }
    }
