import java.sql.*;

/**
 * Created by Snoopy on 2017/5/7.
 */
public class JDBCOperation {

    private Connection getConn()
    {
        String drive = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/user";//jdbc:mysql://localhost:3306/database name
        String username = "root";//用户名
        String password = "1111";//密码
        Connection conn = null;
        try{
            Class.forName(drive);//之所以要使用这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            conn = (Connection) DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    //进行插入操作
    public int insert()
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "INSERT USER (id,NAME ,sex,phonenumber)";
        PreparedStatement pstmt;
        try{
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setInt(1, 3);
            pstmt.setString(2, "3");
            pstmt.setString(3, "3");
            pstmt.setInt(4, 3);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    //进行删除操作
    public int delete()
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from user where id = 1";
        //String sql = "delete from grade where name = '"+ Alex(可以作为参数) +"'";
        PreparedStatement pstmt;
        try{
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    //进行修改操作
    public int update()
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "update user set sex = '男' where id = 2";
        PreparedStatement pstmt;
        try{
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    //进行查找操作
    public int select()
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "select * from USER ";
        PreparedStatement pstmt;
        try{
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                for(int j=1; j<=col; j++){
                    System.out.print(rs.getString(j)+"\t");
                    if(j == col)
                        System.out.println();
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return i;
    }
}
