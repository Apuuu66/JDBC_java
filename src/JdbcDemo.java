import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Snoopy on 2017/5/7.
 */
public class JdbcDemo {
    public static void test() throws Exception {
        //1,注册驱动
//      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//      System.getProperty("jdbc.driver", "con.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");//这三种注册方式，推荐使用这种

        //2，建立连接
        //url格式
        //JDBC:子协议:子名称//主机名:端口/数据库名称
        String url = "jdbc:mysql://localhost:3306/jdbc";//如果是本机，也可以将localhost:3306省掉
        String user = "root";
        String password = "1111";
        Connection conn = DriverManager.getConnection(url, user, password);

        //3，创建slq执行语句
        Statement st = (Statement) conn.createStatement();

        //4,执行语句
        ResultSet rs = st.executeQuery("select * from USER ");

        //5，处理执行结果
        while (rs.next()) {
            System.out.println(rs.getObject(1)+" " +
                    rs.getObject(2)+" "+
                    rs.getObject(3)+" " +
                    rs.getObject(4)
            );
        }

        //6，关闭连接，释放资源
        rs.close();
        st.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
