import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDAO {

        public boolean registerUser(Users user) {
            boolean status = false;
            try {
                Connection con = DBConnection.getconnection();

                String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, user.getMobile());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, "USER");

                status = ps.executeUpdate() > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }

        public Users login(String mobile, String password) {
            Users user = null;
            try {
                Connection con = DBConnection.getconnection();

                String sql = "SELECT * FROM users WHERE mobile=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, mobile);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    user = new Users();
                    user.setMobile(rs.getString("mobile"));
                    user.setRole(rs.getString("role"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }
