import java.sql.*;
/**
 * Created by Snoopy on 2017/4/17.
 */

public class TestJDBC {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            String url = "jdbc:mysql:///tsgl";
            con = (Connection)DriverManager.getConnection(url,"root","1111");
            //创建语句对象
            st = con.createStatement();
            //执行查询语句
            String sql = "select sno,sname,tie,stelephone,borrowcount from user";
            rs = st.executeQuery(sql);
            //遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("sno"));
                System.out.println(rs.getString("sname"));
                System.out.println(rs.getString("tie"));
                System.out.println(rs.getString("stelephone"));
                System.out.println(rs.getString("borrowcount"));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //释放资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(st != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }

}
