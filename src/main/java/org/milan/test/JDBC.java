package org.milan.test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Aspire
 */
public class JDBC {
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection conn;

public void estConnection(){
    try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,"mirathod","mirathod");
        if(conn==null){
           JOptionPane.showMessageDialog(null, "Connection cannot be established ");
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error in Connection "+e.toString());
    }
}
 public ResultSet generalSelectQuery(String sql){
        ResultSet rs=null;
        estConnection();
        try{
            Statement s=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=s.executeQuery(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "general Select Query :- "+e.toString());
        }
        return rs;
    }
public int generalInsertUpdateDeleteQuery(String sql){
    estConnection();
    int ru=0;
    try{
        Statement s=conn.createStatement();
        ru=s.executeUpdate(sql);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "general Insert Update Delete Query :- "+e.toString());
    }
    return ru;
}
 
}
