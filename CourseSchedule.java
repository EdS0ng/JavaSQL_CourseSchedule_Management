/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseschedule;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author edward
 */

public class CourseSchedule {
    
    private static Scanner scan1 = new Scanner(System.in);
    private static Scanner scan2 = new Scanner(System.in);
    private consolePrinter printer = new consolePrinter();
    private static String[] studentInfo = new String[4];
    private static StudentSQL Students = new StudentSQL();
    private static CourseSQL Courses = new CourseSQL();
    private static ArrayList courseInfo = new ArrayList();
    
    private static void Students(){
        int option=0;
        int studentNumChoice;    
        while (option!=99){
            Students.getStudents();
            System.out.printf("%n%n%n%n");
            System.out.println("Available Options: (1.) Add Student (2.) Remove Student "
                    + "(3.) Edit Student Information (99.)Previous Menu");
            System.out.println("Please choose an option by entering the option number");
            option = scan1.nextInt();
        
            switch (option){
                case 1: getStudentInfo();
                        Students.addStudent(studentInfo);
                        break;
                case 2: System.out.println("Enter a Student No. to delete: ");
                        studentNumChoice = scan1.nextInt();
                        Students.deleteStudent(studentNumChoice);
                        break;
                case 3: System.out.println("Enter a Student No. to Edit on the list:");
                        studentNumChoice = scan1.nextInt();
                        getStudentInfo();
                        Students.editStudent(studentInfo, studentNumChoice);
                        break;
                case 99: break;
                default: System.out.println("Invalid option, please choose again.");
            }
        }
        
    }
    
   private static void getStudentInfo(){
       System.out.printf("%n%n%n%n");
       System.out.println("Enter Student Last Name: ");
       studentInfo[0]= scan2.nextLine();
       System.out.println("Enter Student First Name: ");
       studentInfo[1] = scan2.nextLine();
       System.out.println("Enter Student Gender: ");
       studentInfo[2]= scan2.nextLine();
       System.out.println("Enter Student Major :");
       studentInfo[3]= scan2.nextLine();
   }
    
    private static void Courses(){
        int option=0;
        int courseNumChoice;
        while (option!=99){
            Courses.getCourses();
            System.out.printf("%n%n%n%n");
            System.out.println("Available Options: (1.) Add Course (2.) Remove Course (3.) Edit Course Information (99.)Previous Menu");
            System.out.println("Please choose an option by entering the option number");
            option = scan1.nextInt();
            switch (option){
                case 1: getCourseInfo();
                        Courses.addCourse(courseInfo);
                        courseInfo.clear();
                        break;
                case 2: System.out.println("Enter a Course No. to delete: ");
                        courseNumChoice = scan1.nextInt();
                        Courses.deleteCourse(courseNumChoice);
                        break;
                case 3: System.out.println("Enter a Course No. to Edit on the list:");
                        courseNumChoice = scan1.nextInt();
                        getCourseInfo();
                        courseInfo.add(courseNumChoice);
                        Courses.editCourse(courseInfo);
                        courseInfo.clear();
                        break;
                case 99: break;
                default: System.out.println("Invalid option, please choose again.");
            }
        }
        
    }
    
    private static void getCourseInfo(){
       System.out.printf("%n%n%n%n");
       System.out.println("Enter Course Name: ");
       courseInfo.add(scan2.nextLine());
       System.out.println("Enter Course Credits: ");
       courseInfo.add(scan1.nextInt());
       System.out.println("Enter Course Start Time (hh:mm:ss): ");
       Time start = Time.valueOf(scan2.nextLine());
       courseInfo.add(start);
       System.out.println("Enter Course End Time (hh:mm:ss):");
       Time end = Time.valueOf(scan2.nextLine());
       courseInfo.add(end);
       System.out.println("Enter Course Location: ");
       courseInfo.add(scan2.nextLine());
    }
    
    private static void enroll(){
        System.out.printf("%n%n%n%n");
        Students.getStudents();
        System.out.println("Enter a Student No. : ");
        int studentnum = scan1.nextInt();
        
    }
    
    public static void main(String...args) {
        // TODO code application logic here
        int option=0;
        
        System.out.println("Welcome!"); 
        while (option != 99){
            System.out.println("Available Options: (1.) See Student List (2.) See Course List"
                    + " (4.) Enroll in a Course (99.) Exit the Program");
            System.out.println("Please choose an option by entering the option number");
            
            option = scan1.nextInt();
            switch (option){
                case 1: Students();
                        break;
                        
                case 2: Courses();
                        break;
                
                case 3: System.out.printf("%n%n%n%n");
                        System.out.println("Instructors");
                        break;
                    
                case 4: enroll();
                        break;
                
                case 99: break;
                
                default: System.out.println("Invalid option, please choose again.");
            }
        }
    }
    
}
