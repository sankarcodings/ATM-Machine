package SQl;
import java.sql.*;
import DataFetch.LoginDataFetch;
public class SqlConnection extends LoginDataFetch
{
    public void insertvalues(String accName,String accNo,String accPwd,String accDate) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "insert into users values(?,?,?,?,?)";
        Connection con = DriverManager.getConnection(url,user,pwd);
        PreparedStatement st = con.prepareStatement(query);
        int accNum = Integer.parseInt(accNo);
        st.setString(1,accName);
        st.setInt(2,accNum);
        st.setString(3,accPwd);
        st.setDouble(4,0);
        st.setString(5,accDate);
        int result = st.executeUpdate();
        System.out.println("Inserted -> "+result);
        con.close();
    }
    public  void readValues() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/ATM";
        String user = "root";
        String pwd = "pubglover143**";
        String query = "select * from users";
        Connection con = DriverManager.getConnection(url,user,pwd);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(query);
        while(result.next())
        {
            System.out.print(result.getString(1)+" ");
            System.out.print(result.getInt(2)+" ");
            System.out.print(result.getString(3)+" ");
            System.out.print(result.getInt(4)+" ");
            System.out.println(result.getString(5)+" ");

        }
        con.close();
    }

    public boolean eightDigit(String digit)
    {
        int n = Integer.parseInt(digit);
        int len=0;
        while(n!=0)
        {
            len++;
            n/=10;
        }
        return len==8 ? true:false;
    }
    public boolean checkPassword(String pass)
    {
        int num = 0;
        int alpha = 0;
        for(int i=0;i<pass.length();i++)
        {
            char c = pass.charAt(i);
            if(c>='a' && c<='z')
            {
                alpha++;
            }
            else if(c-'0' >= 0 && c-'0' <=9)
            {
                num++;
            }
            else
            {
                return false;
            }
        }
        return alpha>0 && num>0 ? true:false;
    }
    public boolean strCheck(String s1,String s2)
    {
        return s1.equals(s2) ? true:false;
    }

}
