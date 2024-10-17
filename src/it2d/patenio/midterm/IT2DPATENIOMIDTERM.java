
package it2d.patenio.midterm;
import java.util.Scanner;

public class IT2DPATENIOMIDTERM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        
        System.out.print("Enter Action: ");
        int action= sc.nextInt();
        IT2DPATENIOMIDTERM ad=new IT2DPATENIOMIDTERM();
        
        switch(action){
            case 1:
                      ad.addAttendees();     
                break;
                
            case 2:
                           ad.viewAttendees();    
                break;
                
            case 3:
                
                           ad.viewAttendees();   
                           ad.updateAttendees();
                           ad.viewAttendees();
                break;
                
            case 4:
                
                          ad.viewAttendees(); 
                          ad.deleteAttendees(); 
                          ad.viewAttendees(); 
                
                
                
                break;

            case 5:
                    System.out.println("Exiting...");
                    break;

             default:
                    System.out.println("Invalid option. Please try again.");
                    break;
        
        }    
         System.out.print("Do you want to continue? (yes/no): ");
         response=sc.next();
        }while(response.equalsIgnoreCase("yes"));
         System.out.print("Thank you, See you soonest!"); 
       
    }

     public void addAttendees(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
         System.out.print("Date: ");
         String date= sc.nextLine();
         
         System.out.print("Status(Absent/Present/Tardy): ");
         String status= sc.nextLine();
         
         System.out.print("Remarks: ");
         String remarks= sc.nextLine();
         
         
        String sql = "INSERT INTO tbl_attendance (a_date, a_status, a_remarks) VALUES (?, ?, ?)";


        conf.addAttendance(sql, date, status, remarks);

    }
      
     private void viewAttendees() {
         config conf= new config();
         
        String aQuery = "SELECT * FROM tbl_attendance";
        String[] aHeaders = {"Attendace", "Date", "Status", "Remarks"};
        String[] aColumns = {"attendance_id", "a_date", "a_status", "a_remarks"};

        conf.viewAttendance(aQuery, aHeaders, aColumns);
    }
    
     private void updateAttendees(){

        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Attendance ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter New Status(Absent/Present/Tardy): ");
        String status= sc.next();
        

        String sql = "UPDATE tbl_attendance SET a_status = ? WHERE attendance_id = ?";
        conf.updateAttendance(sql, status, id); 
    }
      public void deleteAttendees() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Attendance ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tbl_attendance WHERE attendance_id = ?";
        conf.deleteAttendance(sql, id);
    }
      
}
     




