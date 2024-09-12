package DataFetch;
import java.sql.*;
public class ChangePwdDataFetch
{
    public static boolean changePwdData(String accNo,String newPwd) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "update users set AccPass = ? where AccNo = ?";

        Connection con = DriverManager.getConnection(url,user,pwd);
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,newPwd);
        st.setString(2,accNo);
        int result = st.executeUpdate();
        return result>0 ? true:false;
    }
}
