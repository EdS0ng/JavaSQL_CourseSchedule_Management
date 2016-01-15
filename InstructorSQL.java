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

/**
 *
 * @author edward
 */
public class InstructorSQL extends interactsql{
    
    public InstructorSQL(){
        super("Instructor");
    }
    
    public void signUp(int instructor, int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"teachCourse(?,?)")){
            prepared.setInt(1,instructor);
            prepared.setInt(2,course);
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void dropCourse(int instructor, int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"dropCourse(?,?)")){
            prepared.setInt(1,instructor);
            prepared.setInt(2,course);
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void courses(int instructor){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"coursesTaught(?)")){
            prepared.setInt(1,instructor);
            ResultSet result = prepared.executeQuery();
            consolePrinter.printCourseList(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
