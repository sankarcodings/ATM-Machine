package SQl;
import java.sql.*;
public class CheckSql
{
    public static void insertVals() throws Exception
    {
        String host = "jdbc:mysql://127.0.0.1:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "insert into users values(?,?,?,?)";
        Connection con = DriverManager.getConnection(host,user,pwd);
        PreparedStatement st = con.prepareStatement(query);
        int accNum = Integer.parseInt("345678");
        st.setString(1,"sanjay");
        st.setInt(2,accNum);
        st.setString(3,"dsfdus6578");
        st.setString(4,"2020-12-12");
        int result = st.executeUpdate();
        System.out.println("Values Inserted --");
        con.close();

    }
    public static void main(String[] args) throws Exception
    {
        insertVals();
    }
}
