import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SessionTableUtil {

    public static boolean checkSessionTable(String username, String pass){
        boolean flag = false;
        try{
            Connection conn = DatabaseConn.getConnection();
            Statement st = conn.createStatement();
            String userInfo = "select * from sessiontable where username='"+ username + "' AND password='" + pass +"';";
            ResultSet rs = st.executeQuery(userInfo);
            if(rs.next()){
                flag = true;
            }
            conn.close();
        }catch (Exception e){
        }
        return flag;
    }

    public static void add2SessionTable(String userid, String username,String sessionid ,String lastname, String password, String firstname){
        Connection con = null;
        try {
            con = DatabaseConn.getConnection();
            Statement statement = con.createStatement();
            String query = "insert into sessiontable (userid, username, sessionid, lastname, password, firstname) " +
                    "Values ('" + userid + "','" + username +"','" + sessionid+ "', '" +
                    lastname + "',  '" +password+ "', '" + firstname + "');";
            statement.executeUpdate(query);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteUserInSessionTable(int userID){
        Connection con = null;
        try {
            con = DatabaseConn.getConnection();
            Statement statement = con.createStatement();
            String query = "DELETE FROM sessiontable where userid = '" + userID +"';";
            statement.executeUpdate(query);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
