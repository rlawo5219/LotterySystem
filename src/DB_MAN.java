import java.sql.*;
import java.io.*;

public class DB_MAN{
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String strURL = "jdbc:sqlserver://localhost:1433;DatabaseName=UserInfo;";
//    String strURL = "jdbc:sqlserver://10.70.41.80:1433;DatabaseName=Automobile;";
    String strUser = "sa";
    String strPWD = "inha1958";
    
    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;
    
    public void dbOpen() throws IOException {
        try{
            Class.forName(strDriver);
            strURL += "encrypt=true;trustServerCertificate=true;";
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD);
            DB_stmt = DB_con.createStatement();
        }catch(Exception e){
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public void dbClose() throws IOException {
        try{
            DB_stmt.close();
            DB_con.close();
        }catch(SQLException e){
            System.out.println("SQLException : " + e.getMessage());
        }
    }
}
