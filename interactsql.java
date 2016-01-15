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
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author edward
 */
public class interactsql {
    public final String call = "call ";
    public final String get = "get";
    public final String delete = "delete";
    public final String edit = "edit";
    public final String add = "add";
    public String singular;
    
    public interactsql(String name){
        this.singular = name;
    }
    
    public void addOne(ArrayList args){
        int n = args.size()-1;
        String invoke = new String (new char[n]).replace("\0",",?");
        invoke = "(?"+invoke+")";
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+add+singular+invoke)){
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
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void getAll(){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                Statement statement = db.createStatement(); 
                ResultSet result = statement.executeQuery(call+get+singular+"s()")){
            if (singular=="Course"){
                consolePrinter.printCourseList(result);
            }else if (singular=="Student"){
                consolePrinter.printStudentList(result);
            }else{
                consolePrinter.printInstructorList(result);
            }
            result.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteOne(int ID){
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+delete+singular+"(?)")){ 
            prepared.setInt(1,ID);
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
   
    public void editOne(ArrayList args){
        int n = args.size()-1;
        String invoke = new String (new char[n]).replace("\0",",?");
        invoke = "(?"+invoke+")";
        try (Connection db = DriverManager.getConnection(
                        "jdbc:mysql://localhost/courseschedule",
                        "edward",
                        "edward1"); 
                PreparedStatement prepared = db.prepareStatement(call+edit+singular+invoke)){
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
            prepared.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
