/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseschedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author edward
 */
public class interactsql {
    public String select = "select * from ";
    public String tableName;
    private Statement query;
    private ResultSet result;
    private Boolean queryResponse;
    
    public interactsql(String name){
        this.tableName = name;
    }
    
    public ResultSet makeQuery(){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1")){
            query = db.createStatement();
            queryResponse = query.execute(select+tableName);
            if (queryResponse){
                result = query.getResultSet();
            }else{
                close();
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
     }
    
    public void close(){
        try {
            if (result != null){
                result.close();
            }
            if (query != null){
                query.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
//    public Boolean checkTable(String tablename) throws SQLException {
//        DatabaseMetaData meta =  db.getMetaData();
//        ResultSet table = meta.getTables(null, null, tablename, null);
//        if (table.next()){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    
   
}
