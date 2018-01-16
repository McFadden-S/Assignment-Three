// **********************************************************************
// Programmer:	McFadden
// Class:	CS30S
//
// Assignment:	Assignment Three
//
// Description:	The program will read hours worked and wage from a file and 
//              calculate the pay of the employee. calulations will take place
//              in the class and printing in client
//
// Input:       Hours worked and wage will be read in
//
// Output:      Will out put employee id, wage, hours worked, regular pay
//              overtime pay and gross pay
// ***********************************************************************

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class A3Client
{  // begin class
	public static void main(String args[]) throws FileNotFoundException, IOException
	{  // begin main
            
	// ***** declaration of constants *****
	// ***** declaration of variables *****
            
            ArrayList<Employee> employee = new ArrayList<>();
        
            BufferedReader fin = null;
            
            String strin;  //string for data read in
            String delim = "[ ]+"; //used to seperate data
            String[] tokens; //holds seperated data
            
            int hours;  //variable for hours worked
            double wage;   //variable for wage
            
	// ***** create objects *****
	// ***** create input stream *****
        
        try{
        //creates reader to read in data
        fin = new BufferedReader(new FileReader("EmployeeData.txt"));
        }//end of try
        catch (FileNotFoundException e){ //catches if file isnt found
            System.out.println("file not found");
        }//end of catch
        
	// ***** Print Banner *****
	
		System.out.println("**********************************");
		System.out.println("NAME:        McFadden");
		System.out.println("Class:       CS30S");
		System.out.println("Assignment:  Assignment Three");
		System.out.println("**********************************");
		
	// ***** Main Body *****
        
         //adds spacer/line before table
        System.out.println("\n***********************************************"
               + "********************************************\n");
        
        //prints header for table
        System.out.println("Employee Id\tHours Worked\tWage\t\tRegular Pay\t"
                + "Overtime Pay\tGross Pay");
        
        //adds spacer/line after header
        System.out.println("***********************************************"
               + "********************************************");
    
        strin = fin.readLine(); //reads in new line and primes the loop
        
        while (strin != null){ //start of EoF loop
            tokens = strin.split(delim); //seperates data
            
            //assigns splited data to variables
            hours = Integer.parseInt(tokens[0]);
            wage = Double.parseDouble(tokens[1]);
            
            //initilizes new employee with data read in
            employee.add(new Employee(hours, wage));

            strin = fin.readLine(); //reprimes loop with new line
        }//end of EoF loop
        
        //prints out data from the employees created
        for(Employee i: employee)
            System.out.println(i);
            
         //adds spacer/line after table
        System.out.println("\n***********************************************"
               + "********************************************\n");
        
        //prints id for employee number one
        System.out.println("Employee Number One's ID: " + employee.get(0).returnEmployeeID());
        //prints wage of employee two
        System.out.println("Employee Number Two's Wage: " + employee.get(1).returnWage());
        //prints regular pay of employee three
        System.out.println("Employee Number Three's Regular Pay: " + employee.get(2).returnRegPay());
        //prints overtime pay for employee four
        System.out.println("Employee Number Four's Overtime Pay: " + employee.get(3).returnOTPay());
        //prints gross pay of employee five
        System.out.println("Employee Number Five's Gross Pay: " + employee.get(4).returnGrossPay());
        
	// ***** closing message *****
	
		System.out.println("\nend of processing");
	
	}  // end main	
}  // end class