package com.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringORM.dao.StudentDao;
import com.SpringORM.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("ormConfig.xml");
        StudentDao stuDao = context.getBean("studentDao",StudentDao.class);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        while(go) 
        {
	        System.out.println("Press 1 : for Adding new student");
	        System.out.println("Press 2 : for Displaying all students");
	        System.out.println("Press 3 : for Getting details of single student");
	        System.out.println("Press 4 : for Deleting a student");
	        System.out.println("Press 5 : for Updating a student");
	        System.out.println("Press 6 : for Exit");
	        
	        try {
	        	int input = Integer.parseInt(br.readLine());
	        	switch (input) {
			
	        	case 1 : // Adding new student
	        			// Taking input from user
	        			System.out.println("Enter user name : ");
	        			String uName = br.readLine();
	        			 
	        			System.out.println("Enter user city : ");
	        			String uCity = br.readLine();
	        			
	        			// Creating Student obj and setting values
	        			Student st = new Student();
	        			st.setStudentName(uName);
	        			st.setStudentCity(uCity);
	        			
	        			// Saving Student obj to DB, by calling insert() of StudentDao
	        			int r = stuDao.insert(st);
	        			System.out.println("Student Insertion Done.."+ r);
	        			System.out.println("**********************************");
	        			
	        			break;	
	    
	        			
	        	case 2 : // Displaying all students
	        			System.out.println("*************************************************");
	        			System.out.println("*************************************************");
	        			List<Student> allStudents = stuDao.getAllStudent();
       			 		for(Student s : allStudents) {
//       			 		System.out.println(s);
       			 			System.out.println("Student Id   : "+s.getStudentId());
       			 			System.out.println("Student Name : "+s.getStudentName());
       			 			System.out.println("Student City : "+s.getStudentCity());
       			 			System.out.println("__________________________________");
       			 		}
       			 		System.out.println("**********************************");
	        			break;
	      
	        			
	        	case 3 : // Getting details of single student
	        			System.out.println("__________________________________");
	        			System.out.println("Enter user id :");
       			 		int uId = Integer.parseInt(br.readLine());
       			 		Student s = stuDao.getStudent(uId);
       			 		System.out.println("Student Id   : "+s.getStudentId());
			 			System.out.println("Student Name : "+s.getStudentName());
			 			System.out.println("Student City : "+s.getStudentCity());
       			 		
			 			System.out.println("**********************************");
	        			break;
	        	
	      
	        	case 4 : // Deleting a student
	        			System.out.println("__________________________________");
	        			System.out.println("Enter user id :");
   			 			int userId = Integer.parseInt(br.readLine());
   			 			stuDao.deleteStudent(userId);
	        			System.out.println("Student Deleted");
	        			
	        			System.out.println("**********************************");
       			 		break;
	    
       			 		
	        	case 5 : // Updating a student
	        			System.out.println("__________________________________");
	        			System.out.println("Enter user id :");
			 			int usrId = Integer.parseInt(br.readLine());
			 			
			 			System.out.println("Enter user name : ");
	        			String usrName = br.readLine();
	        			 
	        			System.out.println("Enter user city : ");
	        			String usrCity = br.readLine();
	        			
	        			// Creating Student obj and setting values
	        			Student studen = new Student(usrId,usrName,usrCity);
	        			stuDao.updateStudent(studen);
	        			
	        			System.out.println("**********************************");
       			 		break;
	        	
	        	case 6 : // Exiting
	        			System.out.println("**********************************");
	        			go = false;
       			 		break;
	        	}
	        	
	        }
	        catch(Exception e) {
	        	System.out.println("Invalid Input !! Try with another one.");
	        	System.out.println(e.getMessage());
	        }
	    }
        
        System.out.println("Thank you for you time..EXIT !!");
        
    }
}
