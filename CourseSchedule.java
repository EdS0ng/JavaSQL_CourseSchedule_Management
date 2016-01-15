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
    
    private static final Scanner scan1 = new Scanner(System.in);
    private static final Scanner scan2 = new Scanner(System.in);
    private static ArrayList studentInfo = new ArrayList();
    private static final StudentSQL Students = new StudentSQL();
    private static final CourseSQL Courses = new CourseSQL();
    private static ArrayList courseInfo = new ArrayList();
    private static final InstructorSQL Instructors = new InstructorSQL();
    private static ArrayList instructorInfo = new ArrayList();
    
    private static void Students(){
        int option=0;
        int studentNumChoice;    
        while (option!=99){
            Students.getAll();
            System.out.printf("%n%n%n%n");
            System.out.printf("Available Options: (1.) Add Student (2.) Remove Student%n"
                    + "(3.) Edit Student Information (4.) See Student's Registered Courses%n"
                    + " (5.) Enroll for a Course (6.) Unenroll from a Course %n"
                    + "(99.)Previous Menu%n");
            System.out.println("Please choose an option by entering the option number");
            option = scan1.nextInt();
        
            switch (option){
                case 1: getStudentInfo();
                        Students.addOne(studentInfo);
                        studentInfo.clear();
                        break;
                case 2: System.out.println("Enter a Student No. to delete: ");
                        studentNumChoice = scan1.nextInt();
                        Students.deleteOne(studentNumChoice);
                        break;
                case 3: System.out.println("Enter a Student No. to Edit on the list:");
                        studentNumChoice = scan1.nextInt();
                        getStudentInfo();
                        studentInfo.add(studentNumChoice);
                        Students.editOne(studentInfo);
                        break;
                        
                case 4: System.out.println("Enter a Student No. to See Courses Registered for: ");
                        studentNumChoice = scan1.nextInt();
                        Students.coursesRegistered(studentNumChoice);
                        break;
                case 5: enroll();
                        break;
                case 6: unenroll();
                        break;
                case 99: break;
                default: System.out.println("Invalid option, please choose again.");
            }
        }
        
    }
    
   private static void getStudentInfo(){
       System.out.printf("%n%n%n%n");
       System.out.println("Enter Student Last Name: ");
       studentInfo.add(scan2.nextLine());
       System.out.println("Enter Student First Name: ");
       studentInfo.add(scan2.nextLine());
       System.out.println("Enter Student Gender: ");
       studentInfo.add(scan2.nextLine());
       System.out.println("Enter Student Major :");
       studentInfo.add(scan2.nextLine());
   }
    
    private static void Courses(){
        int option=0;
        int courseNumChoice;
        while (option!=99){
            Courses.getAll();
            System.out.printf("%n%n%n%n");
            System.out.printf("Available Options: (1.) Add Course (2.) Remove Course%n"
                    + "(3.) Edit Course Information (4.) See Students Enrolled for a Course%n"
                    + "(5.) See Instructor for a Course (99.)Previous Menu %n");
            System.out.println("Please choose an option by entering the option number");
            option = scan1.nextInt();
            switch (option){
                case 1: getCourseInfo();
                        Courses.addOne(courseInfo);
                        courseInfo.clear();
                        break;
                case 2: System.out.println("Enter a Course No. to delete: ");
                        courseNumChoice = scan1.nextInt();
                        Courses.deleteOne(courseNumChoice);
                        break;
                case 3: System.out.println("Enter a Course No. to Edit on the list:");
                        courseNumChoice = scan1.nextInt();
                        getCourseInfo();
                        courseInfo.add(courseNumChoice);
                        Courses.editOne(courseInfo);
                        courseInfo.clear();
                        break;
                case 4: System.out.println("Enter a Course No. to see enrolled students: ");
                        courseNumChoice = scan1.nextInt();
                        Courses.registeredStudents(courseNumChoice);
                        break;
                case 5: System.out.println("Enter a Course No. to see the instructor; ");
                        courseNumChoice = scan1.nextInt();
                        Courses.courseInstructor(courseNumChoice);
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
       System.out.println("Enter Days with Class (M,Tu,W,Th,F): ");
       courseInfo.add(scan2.nextLine());
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
        Students.getAll();
        System.out.println("Enter a Student No. : ");
        int studentnum = scan1.nextInt();
        Courses.getAll();
        System.out.println("Enter a Course No. to enroll in: ");
        int coursenum = scan1.nextInt();
        Students.enroll(studentnum, coursenum);
        System.out.println("Enrolled!");
    }
    
    private static void unenroll(){
        System.out.printf("%n%n%n%n");
        Students.getAll();
        System.out.println("Enter a Student No. : ");
        int studentnum = scan1.nextInt();
        Students.coursesRegistered(studentnum);
        System.out.println("Enter a Course No. to unenroll from: ");
        int coursenum = scan1.nextInt();
        Students.unenroll(studentnum, coursenum);
        System.out.println("Unenrolled!");
    }
    
    private static void signup(){
        System.out.printf("%n%n%n%n");
        System.out.println("Enter an Instructor No. : ");
        int instructornum = scan1.nextInt();
        Courses.getAll();
        System.out.println("Enter a Course No. to signup: ");
        int coursenum = scan1.nextInt();
        Instructors.signUp(instructornum, coursenum);
        System.out.println("Signed Up!");
    }
    
    private static void drop(){
        System.out.printf("%n%n%n%n");
        System.out.println("Enter an Instructor No. : ");
        int instructornum = scan1.nextInt();
        Instructors.courses(instructornum);
        System.out.println("Enter a Course No. to drop: ");
        int coursenum = scan1.nextInt();
        Instructors.dropCourse(instructornum, coursenum);
        System.out.println("Dropped!");
    }
    
    private static void Instructors(){
        int option=0;
        int InstructorNumChoice;
        while (option!=99){
            Instructors.getAll();
            System.out.printf("%n%n%n%n");
            System.out.printf("Available Options: (1.) Add an Instructor (2.) Remove an Instructor%n"
                    + "(3.) Edit Instructor Information (4.) See Courses taught by an Instructor%n"
                    + "(5.) Signup to Teach a Course (6.)Drop Teaching a Course%n"
                    + "(99.)Previous Menu %n");
            System.out.println("Please choose an option by entering the option number");
            option = scan1.nextInt();
            switch (option){
                case 1: getInstructorInfo();
                        Instructors.addOne(instructorInfo);
                        instructorInfo.clear();
                        break;
                case 2: System.out.println("Enter an Instructor No. to delete: ");
                        InstructorNumChoice = scan1.nextInt();
                        Instructors.deleteOne(InstructorNumChoice);
                        break;
                case 3: System.out.println("Enter a Instructor No. to Edit on the list:");
                        InstructorNumChoice = scan1.nextInt();
                        getInstructorInfo();
                        instructorInfo.add(InstructorNumChoice);
                        Instructors.editOne(instructorInfo);
                        instructorInfo.clear();
                        break;
                case 4: System.out.println("Enter a Instructor No. to see courses taught: ");
                        InstructorNumChoice = scan1.nextInt();
                        Instructors.courses(InstructorNumChoice);
                        break;
                case 5: signup();
                        break;
                case 6: drop();
                        break;
                case 99: break;
                default: System.out.println("Invalid option, please choose again.");
            }
        }
        
    }
    
    private static void getInstructorInfo(){
       System.out.printf("%n%n%n%n");
       System.out.println("Enter Instructor Full Name: ");
       instructorInfo.add(scan2.nextLine());
       System.out.println("Enter Instructor Department: ");
       instructorInfo.add(scan2.nextLine());
       System.out.println("Enter Instructor Position: ");
       instructorInfo.add(scan2.nextLine());
       System.out.println("Enter Instructor Gender: ");
       instructorInfo.add(scan2.nextLine());
    }
    
    public static void main(String...args) {
        // TODO code application logic here
        int option=0;
        
        System.out.println("Welcome!"); 
        while (option != 99){
            System.out.printf("Available Options: (1.) See Student List (2.) See Course List"
                    + " %n(3.) See Instructor List (99.) Exit the Program %n");
            System.out.println("Please choose an option by entering the option number");
            
            option = scan1.nextInt();
            switch (option){
                case 1: Students();
                        break;
                        
                case 2: Courses();
                        break;
                
                case 3: Instructors();
                        break;

                case 99: break;
                
                default: System.out.println("Invalid option, please choose again.");
            }
        }
    }
    
}
