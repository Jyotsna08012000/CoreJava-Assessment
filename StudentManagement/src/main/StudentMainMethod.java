package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Students.StudentCRUD;

public class StudentMainMethod {
	
	 public static void StudentMainMenu(){
		 
		 Scanner sc = new Scanner(System.in);
		 int selectedOption = 0;
		 
		 System.out.println("          1. Add Student               ");
		 System.out.println("          2. Update Student             ");
		 System.out.println("          3. Delet Student             ");
		 System.out.println("          4. Search Student                ");
		 System.out.println("          5. Exit                ");
		 System.out.print("\nEnter Option: ");
		 try{
	            StudentCRUD std = new StudentCRUD();
	            selectedOption = sc.nextInt();
	            switch (selectedOption){
	                case 1:
	                    System.out.println("\n\n\n");
	                    System.out.println("--------------------------------------");
	                    System.out.println("        Add Student              ");
	                    System.out.println("--------------------------------------");
	                    std.addStudent();
	                    System.out.println("--------------------------------------");
	                    System.out.println();
	                    break;
	                case 2:
	                    System.out.println("\n\n\n");
	                    System.out.println("--------------------------------------");
	                    System.out.println("           Update Course              ");
	                    System.out.println("--------------------------------------");
	                    std.updateStudent();
	                    System.out.println();
	                    System.out.println("--------------------------------------");
	                    break;
	                case 3:
	                    System.out.println("\n\n\n");
	                    System.out.println("--------------------------------------");
	                    System.out.println("           Delete Course              ");
	                    System.out.println("--------------------------------------");
	                    std.deleteStudent();
	                    System.out.println("--------------------------------------");
	                    System.out.println();
	                    break;
	                case 4:
	                    System.out.println("\n\n\n");
	                    System.out.println("--------------------------------------");
	                    System.out.println("           Search Student              ");
	                    System.out.println("--------------------------------------");
	                    std.displayStudent();
	                    System.out.println("--------------------------------------");
	                    System.out.println();
	                    break;
	                case 5:
	                    System.out.println("Exiting the application...");
	                    System.exit(0);

	                default:
	                    System.out.println("Error! Please input only the number options available above!!!");
	                    System.out.println("\n\n");
	                    StudentMainMenu();
	            }
		 }catch(InputMismatchException e) {
	            sc.next();
	            System.out.println("Please input only the number options available above!!!");
	            System.out.println();
	            System.out.println();
	            System.out.println();
	            StudentMainMenu();
		 }
		 
 }
	       

	public static void main(String[] args) {
		
		StudentMainMenu();
		

	}

}
