/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseschedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author edward
 */
public class consolePrinter {
    
    public static void printEnrolledCourses(ResultSet result) throws SQLException{
        System.out.printf("%n%n%n");
        System.out.println("Enrolled Courses");
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
        System.out.printf("|No. |Course Name      |Credits|Start Time|End Time  |Location         |%n");
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
        while (result.next()){
            int coursenum = result.getInt("CourseID");
            String coursename = result.getString("CourseName");
            int credits = result.getInt("Credits");
            Time start = result.getTime("StartTime");
            Time end = result.getTime("EndTime");
            String location = result.getString("Location");
            System.out.format("|%1$-4d|%2$-17s|%3$-7d|%4$-10s|%5$-10s|%6$-17s|%n", coursenum, coursename,
                    credits, start, end, location);
        }
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
    }
    
    public static void printStudentList(ResultSet result) throws SQLException{
        System.out.printf("%n%n%n");
        System.out.println("Student List");
        System.out.printf("+----+----------+----------+------+----------------+%n");
        System.out.printf("|No. |Last Name |First Name|Gender|Major           |%n");
        System.out.printf("+----+----------+----------+------+----------------+%n");
        while (result.next()){
            int studentnum = result.getInt("StudentID");
            String firstname = result.getString("FirstName");
            String lastname = result.getString("LastName");
            String gender = result.getString("Gender");
            String major = result.getString("Major");
            System.out.format("|%1$-4d|%2$-10s|%3$-10s|%4$-6s|%5$-16s|%n", studentnum, lastname,
                    firstname, gender, major);
        }
        System.out.printf("+---+----------+----------+------+----------------+%n");
    }
    
    public static void printCourseList(ResultSet result) throws SQLException {
        System.out.printf("%n%n%n");
        System.out.println("Course List");
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
        System.out.printf("|No. |Course Name      |Credits|Start Time|End Time  |Location         |%n");
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
        while (result.next()){
            int coursenum = result.getInt("CourseID");
            String coursename = result.getString("CourseName");
            int credits = result.getInt("Credits");
            Time start = result.getTime("StartTime");
            Time end = result.getTime("EndTime");
            String location = result.getString("Location");
            System.out.format("|%1$-4d|%2$-17s|%3$-7d|%4$-10s|%5$-10s|%6$-17s|%n", coursenum, coursename,
                    credits, start, end, location);
        }
        System.out.printf("+----+-----------------+-------+----------+----------+-----------------+%n");
    }
}
