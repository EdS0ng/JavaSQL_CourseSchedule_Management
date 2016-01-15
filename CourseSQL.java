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
import java.util.ArrayList;
import java.lang.Integer;
import java.sql.Time;

/**
 *
 * @author edward
 */
public class CourseSQL extends interactsql{
    
    public CourseSQL(){
        super("Course");
    }
    
    public void registeredStudents(int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"registeredStudents(?)")){
            prepared.setInt(1,course);
            ResultSet result = prepared.executeQuery();
            consolePrinter.printStudentList(result);
            result.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void courseInstructor(int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+"courseInstructor(?)")){
            prepared.setInt(1,course);
            ResultSet result = prepared.executeQuery();
            consolePrinter.printInstructorList(result);
            result.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
