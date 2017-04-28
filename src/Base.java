import java.sql.*;

/**
 * Created by wYiGui on 2017/4/17.
 */
public class Base {
    public static void main(String[] args) throws Exception {
        template();
    }

    static void template() throws Exception {
        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = JdbcUtils.getConnection();
            st = con.createStatement();
            res = st.executeQuery("SELECT * FROM USER ");
            while (res.next()) {
                System.out.println(res.getObject(1) + "\t" + res.getObject(2) +
                        "\t" + res.getObject(3) + "\t" + res.getObject(4));
            }
        } finally {
            JdbcUtils.free(st,con,res);
                }
            }

    static void test() throws SQLException, ClassNotFoundException {
        //注册驱动
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "111111";
        Connection coon = DriverManager.getConnection(url, user, password);
        //创建语句
        Statement st = coon.createStatement();
        //执行语句
        ResultSet res = st.executeQuery("SELECT *FROM USER ");
        //处理结果
        while (res.next()) {
            System.out.println(res.getObject(1) + "\t" + res.getObject(2) +
                    "\t" + res.getObject(3) + "\t" + res.getObject(4));
        }
        //释放资源
        res.close();
        st.close();
        coon.close();

    }
}
