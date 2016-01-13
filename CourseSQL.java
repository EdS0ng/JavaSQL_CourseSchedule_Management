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
        super("Courses");
    }
    
    public void getCourses(){
        try (Connection db = DriverManager.getConnection("jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1")){
            Statement statement = db.createStatement();
            ResultSet result = statement.executeQuery(select+tableName);
            consolePrinter.printCourseList(result);
        }catch (SQLException err){
            err.printStackTrace();
        }
    }
    
    public void addCourse(ArrayList args){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("insert into Courses"
                        + "(CourseName, Credits, StartTime, EndTime, Location)"
                                + "values(?, ?, ?, ?, ?)")){
            for (int i=1;i<=args.size();i++){
                if (args.get(i-1) instanceof Time){
                    Time x= (Time)args.get(i-1);
                    prepared.setTime(i,x);
                }
                if (args.get(i-1) instanceof String){
                    String x = (String)args.get(i-1);
                    prepared.setString(i, x);
                }
                if (args.get(i-1) instanceof Integer){
                    Integer x = (Integer)args.get(i-1);
                    prepared.setInt(i,x);
                }
            }
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editCourse(ArrayList args){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("update Courses"
                        + " set CourseName=?, Credits=?, StartTime=?, EndTime=?, Location=? where CourseID=?")){
            for (int i=1;i<=args.size();i++){
                if (args.get(i-1) instanceof Time){
                    Time x= (Time)args.get(i-1);
                    prepared.setTime(i,x);
                }
                if (args.get(i-1) instanceof String){
                    String x = (String)args.get(i-1);
                    prepared.setString(i, x);
                }
                if (args.get(i-1) instanceof Integer){
                    Integer x = (Integer)args.get(i-1);
                    prepared.setInt(i,x);
                }
            }
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteCourse(int id){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement("delete from "
                        + "Courses where CourseID=?")){
            prepared.setInt(1,id);
            prepared.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
