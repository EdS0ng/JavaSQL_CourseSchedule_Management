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
        System.out.printf("+----+-----------------+-------+-----+----------+----------+-----------------+%n");
        System.out.printf("|No. |Course Name      |Credits|Days |Start Time|End Time  |Location         |%n");
        System.out.printf("+----+-----------------+-------+-----+----------+----------+-----------------+%n");
        while (result.next()){
            int coursenum = result.getInt("CourseID");
            String coursename = result.getString("CourseName");
            int credits = result.getInt("Credits");
            String days = result.getString("Days");
            Time start = result.getTime("Start");
            Time end = result.getTime("End");
            String location = result.getString("Location");
            System.out.format("|%1$-4d|%2$-17s|%3$-7d|%4$-5s|%5$-10s|%6$-10s|%7$-17s|%n", coursenum, coursename,
                    credits, days, start, end, location);
        }
        System.out.printf("+----+-----------------+-------+-----+----------+----------+-----------------+%n");
    }
    
    public static void printInstructorList(ResultSet result) throws SQLException{
        System.out.printf("%n%n%n");
        System.out.println("Instructor List");
        System.out.printf("+----+------------------+------------------------+-------------+------+%n");
        System.out.printf("|No. |Instructor Name   |Department              |Position     |Gender|%n");
        System.out.printf("+----+------------------+------------------------+-------------+------+%n");
        while (result.next()){
            int instructornum = result.getInt("InstructorNo");
            String instructorname = result.getString("InstructorName");
            String department = result.getString("Department");
            String gender = result.getString("Gender");
            String position = result.getString("Position");
            System.out.format("|%1$-4d|%2$-18s|%3$-24s|%4$-13s|%5$-6s|%n", instructornum, instructorname,
                    department, position, gender);
        }
        System.out.printf("+----+------------------+------------------------+-------------+------+%n");
    }
}
