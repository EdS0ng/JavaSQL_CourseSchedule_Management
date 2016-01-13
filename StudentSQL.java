/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseschedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author edward
 */
public class StudentSQL extends interactsql{
    
    public StudentSQL(){
        super("Students");
    }
    
    public void getStudents(){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                Statement statement = db.createStatement(); 
                ResultSet result = statement.executeQuery(select+tableName)){
            consolePrinter.printStudentList(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editStudent(String [] param, int id){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("update Students "
                        + "set LastName=?, FirstName=?, Gender=?, Major=? where StudentID=?")){
            prepared.setInt(5,id);
            for (int i=1;i<=param.length;i++){
                prepared.setString(i, param[i-1]);
            }
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addStudent(String...args) {
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("insert into Students"
                        + "(LastName, FirstName, Gender, Major)"
                                + "values(?, ?, ?, ?)")){
            for (int i=1;i<=args.length;i++){
                prepared.setString(i, args[i-1]);
            }
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int id) {
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("delete from "
                        + "Students where StudentID=?")){
            prepared.setInt(1,id);
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
