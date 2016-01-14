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
public class courseRegistration extends interactsql{
    
    public courseRegistration(){
        super("courseRegistration");
    }
    
    public void enroll(int student, int course){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("insert into "
                        + "courseRegistration values(?,?)")){
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
                PreparedStatement prepared = db.prepareStatement("select Courses.* "
                        + "from courseRegistration "
                        + "join Courses on courseRegistration.CourseID=Courses.CourseID "
                        //+ "join Students on courseRegistration.StudentID=courseRegistration.StudentID "
                        + "where StudentID=?")){
            prepared.setInt(1,student);
            ResultSet result = prepared.executeQuery();
            consolePrinter.printEnrolledCourses(result);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
