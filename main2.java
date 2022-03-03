package project2;

/*
	- Project 2
	- Dave Dominique, Miguel Contreras-Suarez, Nicolas Rumiche
*/

import java.util.Scanner;
import java.util.ArrayList;


public class main2 {

	public static void main(String[] args) {

		int count = 0;
	    Scanner scan = new Scanner(System.in);
	    
	    person people[] = new person[100];
	    //.instanceof (Object instance of Class)

	   // System.out.println("Welcome to my Personal Managment Program Nikoleeee \n\nChoose one of the options: \n");
	    boolean loop = true;
	    while(loop)
	    {
	      System.out.println("1- Enter the infomation of a faculty \n2- Enter the information of a student \n3- Print tuition invoice for a student \n4- Print faculty information \n5- Enter the information of a staff member \n6- Print the information of a staff memeber\n7-Exit Program \n");
	      System.out.print("\tEnter your selection: ");

	      switch(scan.next())
	      {
	        case "1": 
	        count++;
	        for(int i = 0; i < 100; i++)
	        {
	          if(people[i] == null)
	          {
	            people[i] = new Faculty();
	            System.out.println("Enter the faculty info: ");
	            System.out.print("\tName of the faculty: ");
	            scan.nextLine();
	            people[i].setName(scan.nextLine());
	            System.out.print("\n\tID: ");
	            people[i].setID(scan.next());
	            System.out.print("\n\tRank: ");
	            scan.nextLine();
	            String user = scan.nextLine();
	            int loop2 = 1;
	            while(loop2 == 1)
	            {
	              if(user.equalsIgnoreCase("professor") || user.equalsIgnoreCase("adjunct"))
	              {
	                ((Faculty) people[i]).setRank(user);
	                loop2 = 0;
	              } 
	              else
	              {
	                System.out.println("\t\"" + user + "\" is invalid\n");
	                System.out.print("\tRank: ");
	                scan.nextLine();
	                user = scan.nextLine();
	                loop2 = 1;
	              }
	            }
	            System.out.print("\n\tDepartment: ");
	            String user2 = scan.next();
	            int loop3 = 1;
	            while(loop3 == 1)
	            {
	              if(user2.equalsIgnoreCase("mathematics") || user2.equalsIgnoreCase("engineering") || user2.equalsIgnoreCase("sciences"))
	              {
	                ((employee) people[i]).setDept(user2);
	                loop3 = 0;
	              }
	              else
	              {
	                System.out.println("\t\"" + user2 + "\" is invalid\n");
	                System.out.print("\tDepartment: ");
	                user2 = scan.next();
	                loop3 = 1;
	              }
	            }
	            break;
	          }
	        }
	        System.out.println("\nFaculty added!\n");
	          break;

	        case "2": 
	        count++;
	        for(int i = 0; i < 100; i++)
	        {
	          if(people[i] == null)
	          {
	            people[i] = new student();
	            System.out.println("Enter the student info: ");
	            System.out.print("\tName of the student: ");
	            scan.nextLine();
	            people[i].setName(scan.nextLine());
	            System.out.print("\n\tID: ");
	            people[i].setID(scan.next());
	            System.out.print("\n\tGpa: ");
	            ((student) people[i]).setgpa(scan.nextDouble());
	            System.out.print("\n\tCredit Hours: ");
	            ((student) people[i]).setCH(scan.nextInt());
	            break;
	          }
	        }
	        System.out.println("\nStudent added!\n");
	          break;

	  
	        case "3": System.out.print("\tEnter the student's id: ");
	        String studentid = scan.next();
	        int flag = 0;
	        for(int i = 0; i < count; i++)
	        {
	          
	          if(people[i].getID().equalsIgnoreCase(studentid)) //object insance of class
	          {
	        	  people[i].print();
	            flag = 1;
	            break;
	          }         
	        }
	        if(flag == 0)
	        {
	        	System.out.println("\nNo Student matched!\n");
	        }
	        break;
	        
	        
	        //NO FACULTY MATCHED DOESN'T WORK
	        case "4": System.out.print("\tEnter the faculty's id: ");
	        String facultyId = scan.next();
	        int flag1 = 0;
	        for(int i = 0; i < count ; i++)
	        {
	          if(people[i].getID().equalsIgnoreCase(facultyId))
	          {
	            flag1 = 1;
	            
	            people[i].print();
	            
//	            System.out.println("\n-------------------------------------------");
//	            System.out.println(people[i].getName() + "\t\t" + people[i].getID());
//	            System.out.println((((employee) people[i]).getDept() + " department, " + (((Faculty) people[i]).getRank())));
//	            System.out.println("----------------------------------------------");
	            break;
	          }
	        }
	        if(flag1 == 0)
	        {
	          System.out.println("\nNo Faculty Member matched!\n");
	        }
	        break;

	        case "5": 
	        for(int i = 0; i < 100; i++)
	        {
	          if(people[i] == null)
	          {
	        	count++;
	            people[i] = new Staff();
	            System.out.print("\tName of the staff member: ");
	            scan.nextLine();
	            people[i].setName(scan.nextLine());
	            System.out.print("\n\tEnter the id: ");
	            people[i].setID(scan.next());
	            System.out.print("\n\tDepartment: ");
	            ((employee) people[i]).setDept(scan.next());
	            System.out.print("\n\tStatus, Enter P for Part time or Enter F for Full Time: ");
	            ((Staff) people[i]).setStatus(scan.next());
	            break;
	          }
	        }
	        System.out.println("\nStaff member added!\n");
	        break;

	  
	        case "6": System.out.print("\tEnter the Staff's id: ");
	        int flag2 = 0;
	        String staffId = scan.next();
	        for(int i = 0; i < count; i++)
	        {
	          if(people[i].getID().equalsIgnoreCase(staffId))
	          {
	            flag2 = 1;
	            people[i].print();
	            break;
	          }
	        }
	        if(flag2 == 0)
	        {
	          System.out.println("\nNo Staff Member matched!\n");
	        }
	        break;

	        case "7": System.out.println("\nGoodbye!\n");
	          loop = false;
	          break;
	          
	        default: System.out.println("\nInvalid entry - please try again\n");
	          break;
	      }  
	    }
	    scan.close();
	  }
	}



abstract class person{
	String name;
	String id;
	
	public person () {
		name = null;
		id = null;
	}
	
	public person (String Name, String  ID) {
		
		this.name = Name;
		this.id = ID;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setID(String ID) {
		this.id = ID;
		
	}
	
	public String getID() {
		return id;
	}
	
	public abstract void print();
}


abstract class employee extends person{
	
	private String department;

	
	public employee() {
		
		department = null;

	}
	
	public employee(String Department) {
		this.department = Department;
	}
	
	
	public String getDept()
	{
		return department;
	}
	
	public void setDept (String NewDepartment)
	{
		this.department = NewDepartment;
	}
	
}

class student extends person{
	
	double gpa;
	int credit_hours;
	
	public student() {
		gpa = 0;
		credit_hours = 0;
	}
	
	public student(double gpa, int credithours) {
		
		this.gpa = gpa;
		this.credit_hours = credithours;
	}
	
	public void setgpa(double gpa) {
		this.gpa = gpa;
		
	}
	
	public double getGPA() {
		return gpa;
	}
	
	
	public void setCH(int credit_hours) {
		this.credit_hours = credit_hours;
		
	}
	
	public int getCH() {
		return credit_hours;
	}
	
	
	
	
	public void print() {
		
		System.out.println("----------------------------------------------------------------");
		System.out.println(name + "             "+ id);
		System.out.println("Credit Hours: " + credit_hours + " ($236.45/credit hour) ");
		System.out.println("Fees: $52");
		
		System.out.println("\n\nTotal payment (after discount): $" + String.format("%.2f",totalcost(gpa)) + "    " +  "($"+ String.format("%.2f", discountt(gpa))+ " discount applied)");

		System.out.println("----------------------------------------------------------------");
	}
	
	
	public double totalcost (double gpa)
	{
		double total = 52 + credit_hours* 236.45;
		
		if (gpa >= 3.85)
		{
			total = total * .85;
		}
		
		return total;
	}
	

	public double discountt (double gpa)
	{
		double discount = 52 + credit_hours* 236.45;
		
		if (gpa >= 3.85)
		{
			discount = discount * .15;
			return discount;
		}
		
		return 0;
	}	
}

class Faculty extends employee
{
	
    private String Rank;
    
    public Faculty() {
    	Rank = null;
    	
    }
    
    public Faculty(String rank) {
    	this.Rank = rank;
   
    }
    
   
    public String getRank() {
    	return Rank;
    }
    	
    public void setRank(String Rank) {
    	this.Rank = Rank;
    }
    
    
    public void print()
    {
        System.out.print( name + "       " + id + "\n" + getDept() + " " + Rank);
        
    }
}

class Staff extends employee{

	private String status;
	
	public Staff() {
		status = null;
	}
	
	public Staff(String Status) {
		this.status = Status;
	}
	
	public String getStatus() {
		return status;
	}
		
	public void setStatus(String status) {
		this.status = status;
	}


	public void print() {
	
		System.out.print( name + "    " + id + "\n" + getDept() + ",  " + status + "\n---------------------------------");
	}
	

}
