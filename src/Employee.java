/* **********************************************************
 * Programmer:	McFadden
 * Class:       CS30S
 * 
 * Assignment:	Assignment Three
 *
 * Description:	Calculate employee's pay given their hourly wage and amount of
 *              hours worked
 * ************************************************************/
 
 import java.text.DecimalFormat;
 
 public class Employee
 {  // begin class
 	
 	// *********** class constants **********
 	
        private static int nextId = 1000;      // unique skater id
        private final int MAXhours = 40;    //max hours worked before OT 
        private final double OT = 1.5;      //Overtime multiplier
 	
 	// ********** instance variable **********
 	
        private int id;       // Skater id number
        private int hours;    //varible for hours worked
        private int wage;     //variable for wage (hourly wage)
        
        //formats numbers to stop at two decimals
        private DecimalFormat formatter = new DecimalFormat("#0.00"); 
        
 	// ********** constructors ***********
 	
        /********************************************************
         * Purpose:        create a new employee object which will
         *                 read in hours worked and wage
         *                 
         *         
         * Interface:
         *     in:         Hours Worked (int) and wage (double)
         *     out:        none
         ********************************************************/     
        public Employee(int h, int w){
            id = nextId++;     // set id and increment for next instance 
            
            hours = h;      //assigns hours worked to appropriate variable
            wage = w;       //assigns wage to appropriate variable
            
     } // end default constructor
     
 	// ********** accessors **********
 	
        /********************************************************
        * Purpose:        returns employee data
        *         
        * Interface:
        *     in:         None
        *     out:        id (int)
        ********************************************************/
        public int returnEmployeeID (){ 
            return (id); //returns id
        } // end returnEmployeeID
        
        /********************************************************
        * Purpose:        Calculates and returns regular pay
        *         
        * Interface:
        *     in:         None
        *     out:        RegPay (double)
        ********************************************************/
        public double returnRegPay (){ 
            double RegPay;
            
            if (hours>MAXhours){
                //calculates 40 hours of reg pay because overtime is worked
                RegPay = MAXhours * wage; 
            }//end of if
            else{
                //calculates reg pay with hours worked because no overtime worked
                RegPay = hours * wage;
            }//end of else
            return (RegPay); //returns RegPay
        } // end returnRegPay
        
        /********************************************************
        * Purpose:        Calculates and returns overtime pay
        *         
        * Interface:
        *     in:         None
        *     out:        OTPay (double)
        ********************************************************/
        public double returnOTPay (){ 
            double OTPay;
            
            if (hours>MAXhours){
                //times hours over 40 by ovetime wage
                OTPay = (hours-MAXhours) * wage * OT; 
            }//end of if
            else{
                //no overtime worked
                OTPay = 0;
            }//end of else
            
            return (OTPay); //returns OTPay
        } // end returnOTPay
        
        /********************************************************
        * Purpose:        Calculates and returns gross pay
        *         
        * Interface:
        *     in:         None
        *     out:        GrossPay (double)
        ********************************************************/
        public double returnGrossPay (){ 
            double GrossPay;
            
            //adds overtime pay to regular pay to get gross pay
            GrossPay = this.returnOTPay() + this.returnRegPay();
            
            return (GrossPay); //returns GrossPay
        } // end returnRegPay
        
        /********************************************************
        * Purpose:        Overrides toString to return all info
        *         
        * Interface:
        *     in:         None
        *     out:        string of info
        ********************************************************/
        public String toString (){
            String info = ""; //holds all info
            
            //adds spacer/line
            info += ("\n**********************************\n");
            //adds the id
            info += ("Employee Id: " + this.returnEmployeeID() + "\n");
            //adds hours worked
            info += ("Hours Worked: " + hours + "\n");
            //adds wage
            info += ("Wage: " + wage + "\n");
            //adds regular Pay
            info += ("Regular Pay" + this.returnRegPay() + "\n");
            //adds Overtime pay
            info += ("Overtime Pay: " + this.returnOTPay() + "\n");
            //adds gross pay
            info += ("Gross Pay: " + this.returnGrossPay() + "\n");
            //adds spacer/line
            info += ("\n**********************************\n");

            return info; //returns info
        } // end toString
        
 	// ********** mutators **********
 
 }  // end class