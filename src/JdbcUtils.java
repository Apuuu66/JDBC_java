import java.sql.*;

/**
 * Created by Snoopy on 2017/4/23.
 */
public final class JdbcUtils {
    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "1111";

    private JdbcUtils() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void free(Statement st, Connection con, ResultSet res) {
        try {
            if (res != null)
                res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null)
                        con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }
    }
}