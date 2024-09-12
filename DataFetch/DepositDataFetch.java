package DataFetch;

import java.sql.*;
public class DepositDataFetch
{
    public static boolean depositData(String accNo,String accPwd,String amt) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "select * from users where AccNo = "+accNo;

        Connection con = DriverManager.getConnection(url,user,pwd);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(query);
        boolean check = false;
        String pwdcheck = "";
        if (result.next())
        {
            pwdcheck = result.getString(3);

            if(pwdcheck.equals(accPwd))
            {
                check = true;
            }
        }
        double  prevAmount = result.getDouble(4);
        double amt1 = Double.parseDouble(amt);
        double totalAmt = amt1+prevAmount;
        if(check)
            return updateDepositAmt(accNo,totalAmt) ? true:false;
        return false;
    }

    public static boolean updateDepositAmt(String accNo,double totalAmt) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "update users set AccAmount = "+totalAmt+" where AccNo = "+accNo;

        Connection con = DriverManager.getConnection(url,user,pwd);
        Statement st = con.createStatement();
        int result = st.executeUpdate(query);
        return result >0 ? true:false;
    }
}
