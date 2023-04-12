package Students;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import connection.DBconnection;



public class StudentCRUD {
	
	private int studentId;
    private String name, address;
    private long contact;
    private ArrayList<String> StudentLists;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public ArrayList<String> getStudentLists() {
		return StudentLists;
	}
	public void setStudentLists(ArrayList<String> studentLists) {
		StudentLists = studentLists;
	}
	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", name=" + name + ", address=" + address + ", contact="
				+ contact + ", StudentLists=" + StudentLists + "]";
	}
    

	
	/**
     * add course
     */
    public void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            Scanner sc = new Scanner(System.in);
            int studentId = Integer.parseInt(sc.nextLine());

           
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                System.out.println("Enter contact number");
                long contact=Long.parseLong(sc.nextLine());
                System.out.print("Enter Student address: ");
                String address = sc.nextLine();
                
                insertStudentIntoDB(studentId,name,contact,address);
                 
        }catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    /**
     * add
     */
    private void insertStudentIntoDB(int studentId, String name, long contact, String address) {
        String sql = "INSERT into student (studentId, name, contact, address) values (?,?,?,?)";
        try {
            PreparedStatement pst = DBconnection.getConnection().prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, name);
            pst.setLong(3, contact);
            pst.setString(4, address);
            pst.executeUpdate();
            pst.close();
            System.out.println();
            System.out.println(" added successfully!!!");
            System.out.println();
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ex.getMessage());
        }
    }

    public boolean isInDatabase(int studentId) {
        String sql = "select studentId, name, contact, address  from student where studentId = ?";
        try {
            PreparedStatement pst = DBconnection.getConnection().prepareStatement(sql);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                initializedata(rs);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
        return false;
    }

   
    private void initializedata(ResultSet rs) {

        try {
            this.studentId=rs.getInt(1);
            this.name = rs.getString(2);
            this.contact= rs.getLong(3);
            this.address=rs.getString(4);
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    /**
     * delete 
     */
    public void deleteStudent() {
        String sql = "select  studentId, name, contact, address  from student";
        try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            StudentLists = new ArrayList<String>();
            while (rs.next()) {
                StudentLists.add(" Student ID: "+rs.getString(1) + " - " +" Name: "+ rs.getString(2)+ " - " + " Contact: "+rs.getString(3) + " - " +" Address: "+ rs.getString(4));
            }

        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
        Iterator itr = StudentLists.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }
        System.out.println();
        System.out.println("--------------------------------------");
        try {
            System.out.print("Enter the ID of student you want to delete: ");
            Scanner sc = new Scanner(System.in);
            int studentId = Integer.parseInt(sc.nextLine());
            if(isInDatabase(studentId)==true) {
                deleteStudentFromDB(studentId);
            }else{
                System.out.println("Student ID doesn't exist!!");
            }
        }catch (InputMismatchException ex){
            System.out.println("Error!! Enter integer type value!!");
            System.out.println();
        }
    }

    /**
     * delete 
     */
    private void deleteStudentFromDB(int studentId){
        String sql = "delete from student  where studentId=?";
        try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println(" deleted successfully!!");
            System.out.println();
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
    }

    /**
     * display 
     */
    public void displayStudent() {
        String sql = "select * from student where studentId=? ";
    
            System.out.print("Enter the ID of student : ");
            Scanner sc = new Scanner(System.in);
            int studentId = Integer.parseInt(sc.nextLine());
            if(isInDatabase(studentId)==true) {
            	displaystudentfromDB();
            	try {
        			PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
        			pstmt.setInt(1, studentId);
        			ResultSet rs = pstmt.executeQuery();
        			System.out.println("........");
        		 } catch (SQLException ex) {
                    System.out.println();
                    System.out.println("Error: "+ ex.getMessage());
        		}
            }else{
                System.out.println("Student ID doesn't exist!!");
            }
      
        
    
   
    }
    
    private void displaystudentfromDB() {
    	Scanner sc = new Scanner(System.in);
    	String sql = "select * from student where studentId="+studentId ;
        
    	try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
           ResultSet rs = pstmt.executeQuery();

            StudentLists = new ArrayList<String>();
            while (rs.next()) {
                StudentLists.add("Student ID: "+rs.getString(1) + " - " +" Name: "+ rs.getString(2)+ " - " + " Contact: "+rs.getString(3) + " - " +" Address: "+ rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println();
            System.out.println("Error: "+ ex.getMessage());
        }
        System.out.println("--------------------------------------");
        Iterator itr = StudentLists.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------------------------");
        System.out.println();
    	
    }

    /**
     update
    
     */
    public void updateStudent(){
    
     Scanner sc = new Scanner(System.in);
        try {
           
            displayStudent();
            
            if(isInDatabase(studentId)==true) {
                System.out.print("Enter the new name for the student: ");
                String name = sc.nextLine();
                System.out.print("Enter the new contact for the student: ");
                long contact=Long.parseLong(sc.nextLine());
                System.out.print("Enter the new address for the student: ");
                String address = sc.nextLine();
                String sql = "update student set name=?, contact=?, address=? where studentId=?";
                try {
                    PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
                    pstmt.setString(1, name);
                     pstmt.setLong(2,contact);
                    pstmt.setString(3, address);
                    pstmt.setInt(4, studentId);
                    pstmt.executeUpdate();
                    pstmt.close();
                    System.out.println();
                    System.out.println(" updated successfully!!");
                    System.out.println();
                } catch (SQLException ex) {
                    System.out.println();
                    System.out.println("Error: "+ ex.getMessage());
                }
            }else{
                System.out.println("Error!!  ID doesn't exists!!");
                System.out.println();
            }
        }catch (InputMismatchException ex){
            System.out.println("Error:"+ex.getMessage());
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
   
}
	


