package DataFetch;

import java.sql.*;

public class BalanceDataFetch
{
    int balance = 0;
    public boolean balanceDataFetch(String accNo,String accPwd) throws Exception
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
            balance = result.getInt(4);
        }
        return check ? true : false;
    }
    public int getBalance()
    {
        return balance;
    }
}
