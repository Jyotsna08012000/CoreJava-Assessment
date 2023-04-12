package coursemanagement;

import java.util.LinkedList;
import java.util.Scanner;

public class CourseRecord {
	
	LinkedList<Course> list;
	
        public CourseRecord() {
	        list = new LinkedList<>();
	    }
        
       public void add(Course cur) {
    	    if (!find(cur.getCourseId())) {
               list.add(cur);
           }
           else {
                 System.out.println(
                   "Course already exists in the Course list");
           }
       }
       
       private boolean find(int courseId) {
  		 for (Course l : list) {
  			   if (l.getCourseId() == courseId) {
                     System.out.println(l);
  	                return true;
  	            }
  		 }
  		return false;
  		 }
       public void delete(int courseId) {
    	   Course curDel = null;
    	   
           for ( Course ll : list) {
             if (ll.getCourseId() == courseId) {
                   curDel = ll;
               }
           }
             if (curDel == null) {
              System.out.println("Invalid course Id");
           }
           else {
    
               list.remove(curDel);
               System.out.println("Successfully removed course from the list");
           }
       }
       public Course search(int courseId)
       {
        for (Course l : list) {
             if (l.getCourseId() == courseId) {
                   return l;
               }
           }
    
           return null;
       }
       public void edit(int id, Scanner sc)
       {
    
           if (find(id)) {
               Course cur  = search(id);
    
               
               System.out.print("What is the new Course id  ? ");
                   int courseId = sc.nextInt();
    
                   sc.nextLine();
               System.out.print("What is the new Course Name ? ");
                    String courseName = sc.nextLine();
               
               System.out.print( "What is the new Course Fees  ? ");
                      int courseFees = sc.nextInt();
                   
                      sc.nextLine();
                   System.out.print( "What is the new Course Duration ? ");
                          String courseDuration = sc.nextLine();
                       
                       System.out.print("What is the new Course Details ? ");
                             String courseDetails = sc.nextLine();
                           
                           cur.setCourseId(courseId);
                           cur.setCourseName(courseName);
                           cur.setCourseFees(courseFees);
                           cur.setCourseDuration(courseDuration);
                           cur.setCourseDetails(courseDetails);
                           
                           System.out.println(
                                   "Course Updated Successfully");
                           }
                           else {
                    System.out.println("Course Not Found in the Course list");
                                   
                           }
                       }
       public void view()
       {
    
           if (list.isEmpty()) {
    
               System.out.println("The list has no course\n");
           }
           
           for (Course cur : list) {
    
               System.out.println(cur.toString());
           }
       }
   }
                   
       
	
	
       
	 


