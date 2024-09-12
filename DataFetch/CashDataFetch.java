package DataFetch;

import java.sql.*;

public class CashDataFetch
{
    static int debitCash = 0;
    public static boolean cashData(String accNo,String accPwd,String amt) throws Exception
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
        int accBal = result.getInt(4);
        int userAmt = Integer.parseInt(amt);
        int cash = accBal-userAmt;

        debitCash = cash; // update debited cash

        return cash > 0 ? true:false;
    }

    public static void updateCash(String accNo) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        if(debitCash<0)
            debitCash = 0;
        String query = "update users set AccAmount = ? where AccNo = ?";
        Connection con = DriverManager.getConnection(url,user,pwd);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,debitCash);
        st.setString(2,accNo);
        int result = st.executeUpdate();
        if(result>0)
            System.out.println("Successfully Updated !!!!");
    }
}
