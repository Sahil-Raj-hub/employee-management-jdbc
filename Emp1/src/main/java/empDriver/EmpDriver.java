 package empDriver ;

import java.util.Scanner;

import empService.EmpService;

public class EmpDriver {
    public static void main(String[] args) {
    	while(true) {
    	Scanner sc=new Scanner(System.in);
        System.out.println("!!!!!WELCOME TO MANAGEMENT SYSTEM!!!!!");
        System.out.println("PRESS 1 TO ADD EMPLOYEE DATA.");
        System.out.println("PRESS 2 TO UPDATE EMP DETAILS.");
        System.out.println("PRESS 3 TO FETCH THE EMPLOYEE DATA.");
        System.out.println("PRESS 4 TO DELETE EMPLOYEE DETAILS.");
        
        System.out.println("PRESS 5 TO EXIT MANAGEMENT SYSTEM.");
        EmpService service = new EmpService();
        System.out.println();
        int choice=sc.nextInt();
               
        
        switch (choice) {
		case 1:service.insert();
			break;
		case 4:service.delete();
			break;
		case 2:service.update();
				break;
		case 3:service.select();
				break;
		case 5: System.out.println("exiting...");
		System.out.println("!!!!! THANK YOU !!!!!");
				return;
		default:System.out.println("Insert a valid number");
				break;
		}
        
        }

        
    }
}
