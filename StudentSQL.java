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
        super("Student");
    }
    
    public void unenroll(int student, int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"unenroll(?,?)")){
            prepared.setInt(1,student);
            prepared.setInt(2,course);
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void enroll(int student, int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"enroll(?,?)")){
            prepared.setInt(1,student);
            prepared.setInt(2,course);
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void coursesRegistered(int student){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"coursesRegistered(?)")){
            prepared.setInt(1,student);
            ResultSet result = prepared.executeQuery();
            consolePrinter.printCourseList(result);
            result.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
