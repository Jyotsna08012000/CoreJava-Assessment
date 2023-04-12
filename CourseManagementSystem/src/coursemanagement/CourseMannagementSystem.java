package coursemanagement;

import java.util.Scanner;

public class CourseMannagementSystem {

	public static void main(String[] args) {
		
		CourseRecord cr = new CourseRecord ();
		
		Course cur = new Course();
		
		
		 cur.setCourseId(1);
         cur.setCourseName("java");
         cur.setCourseFees(3500);
         cur.setCourseDuration("six mnt");
         cur.setCourseDetails("core java");
         
         cr.add(cur);
         Scanner sc = new Scanner(System.in);
 		
         int option = 0;
         
    
         do {
             menu();
             option = sc.nextInt();
  
            
             switch (option) {
  
            
             case 1:
  
                 System.out.print( "What is the Course id: ");
                 int courseId = sc.nextInt();
                 
                 sc.nextLine();
                 System.out.print( "What is the Course Name: ");
                 String courseName = sc.nextLine();
                 
                
                 System.out.print( "What is the Course Fees: ");
                 int courseFees = sc.nextInt();
                 
                 sc.nextLine();
                 System.out.print( "What is the Course Duration: ");
                 String courseDuration = sc.nextLine();
                 
                
                 System.out.print( "What is the Course Details: ");
                 String courseDetails = sc.nextLine();
      
                
                    cur= new Course (courseId,courseName,courseFees,courseDuration,courseDetails);
                    cr.add(cur);                   
                    
                     System.out.println(cur.toString());

                  break;
                  
             case 2:
            	 
                 
                 System.out.print(
                     "What is the Course id  ? ");
                 int courseId1= sc.nextInt();
  
                
                 cr.delete(courseId1);
  
                 break;
  
            
             case 3:
  
               
                 System.out.print(
                     "What is the Course id number? ");
  
                 int courseId2  = sc.nextInt();
                 cr.edit(courseId2,sc);
  
                 break;
             case 4:
            	 
                 
                 System.out.print(
                     "What is the Course id ? ");
                 int courseId3 = sc.nextInt();
  
                 if (cr.search(courseId3)==null) {
                     System.out.println( "Course id does not exist\n");
                        
                 }
  
                 break;
  
             case 5:
                 cr.view();
                 break;
                 
             case 6:
            	 
                
                 System.out.println(
                     "\nThank you for using the program. Goodbye!\n");
                 System.exit(0);
  
                 break;
  
             default:
  
               
                 System.out.println("\nInvalid input\n");
                 break;
             }
         }
  
        
         while (option != 6);
     }
	public static void menu()
    {
 
       
        System.out.println("MENU");
        System.out.println("1: Add Course");
        System.out.println("2: Delete Course");
        System.out.println("3: Edit Student");
        System.out.println("4: Search Student");
        System.out.println("5: view Students");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
    }
  
         
		

	}


