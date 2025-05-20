package empService;

import java.nio.channels.Pipe.SourceChannel;
import java.sql.*;
import java.util.Scanner;
import EmpEntity.Employe;

public class EmpService {

    private static final String URL = "jdbc:postgresql://localhost:5432/EMP Management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static final Scanner sc = new Scanner(System.in);
    
    /////////////////////////////////////////////////////////////////////////////////
    public void insert() {
    	System.out.print("No. Of EMP: ");
    	int count=sc.nextInt();
    	for(int i=1;i<=count;i++) {
    		save();
    	}
    	 
    }

    public int save() {
    	int res=0;

        System.out.println("ENTER The EMP Details: ");
        System.out.print("EMP ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume leftover newline
        System.out.print("EMP Name: ");
        String name = sc.nextLine();
        System.out.print("EMP Age: ");
        int age = sc.nextInt();
        System.out.print("EMP Salary: ");
        int salary = sc.nextInt();

        Employe e1 = new Employe();
        e1.setid(id);
        e1.setname(name);
        e1.setage(age);
        e1.setsalary(salary);

        String query = "INSERT INTO employe (id, name, age, salary) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = conn.prepareStatement(query)
        ) {
            pst.setInt(1, e1.getid());
            pst.setString(2, e1.getname());
            pst.setInt(3, e1.getage());
            pst.setInt(4, e1.getsalary());

            res=pst.executeUpdate(); 
            if (res !=0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("EMP ID Exists.Insertion failed.");
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }    	return res;

    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
    public int delete() 
    {
    	int res=0;
    	System.out.print("Enter the Emp ID:");
    	int id=sc.nextInt();
    	
    	Employe e1=new Employe();
    	e1.setid(id);
    	
    	String delete="DELETE from employe WHERE id=?";
    	
    	try {
				Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pst=con.prepareStatement(delete);
				
				pst.setInt(1, e1.getid());
				res=pst.executeUpdate();
				
				if(res!=0)System.out.println("Data Deleted!!!!!!!!");
				else {
					System.out.println("data not deleted");
					}
			}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return res; 
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///
    
    public void update() {
    	
    	
    	System.out.println("Press 1 to Update Name!!! ");
    	System.out.println("Press 2 to Update Age!!! ");
    	System.out.println("Press 3 to Update Salary!!! ");
    	System.out.println("Press 4 to Update All !!! ");
    	System.out.println("Enter the choice");
    	int choice=sc.nextInt();
    	
    	switch (choice) {
		case 1:updatename();
			break;
		case 2:updateAge();
			break;
		case 3:updateSalary();
			break;
		case 4:updateAll();
		break;

		default:System.out.println("Press Valid Choice!!!");
			break;
		}
    }

    	
    
    
    public int updatename() {
    	int res=0;
    	System.out.println("Enter the Emp ID:");
    	int id=sc.nextInt();sc.nextLine();
    	System.out.println("Enter the Emp Name:");
    	String name=sc.nextLine();
    	
    	Employe e1=new Employe();
    	e1.setid(id);
    	e1.setname(name);
    	
    	String update="UPDATE employe set name=? WHERE id=? ";
    	
    	try {
				Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstm=con.prepareStatement(update);
				
				pstm.setString(1, e1.getname());
				pstm.setInt(2, e1.getid());
				res=pstm.executeUpdate();
				if (res > 0) {
		            System.out.println("Emp Name Updated successfully.");
		        } else {
		            System.out.println("EMP ID Doesn't Exists.Updation failed.");
		        }
			} 
    	catch (SQLException e) 
    		{
			e.printStackTrace();
			} 
    	return res;
    	}
    public int updateSalary() {
    	int res=0;
    	System.out.println("Enter the Emp ID:");
    	int id=sc.nextInt();
    	System.out.println("Enter the Salary");
    	int salary=sc.nextInt();
    	
    	Employe e1=new Employe();
    	e1.setid(id);
    	e1.setsalary(salary);
    	
    	String update="UPDATE employe set salary=? WHERE id=? ";
    	try {
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstm=con.prepareStatement(update);
			
			pstm.setInt(1, e1.getsalary());
			pstm.setInt(2, e1.getid());
			
			res=pstm.executeUpdate();
			if (res > 0) {
	            System.out.println("Emp Salary Updation successfully.");
	        } else {
	            System.out.println("EMP ID Doesn't Exists.Updation failed.");
	        }
		} 
    	catch (SQLException e) 
		{
		e.printStackTrace();
		} 
    	return res;
    	}
    
    
    
    public int updateAge() {
    	int res=0;
    	System.out.println("Enter the Emp ID:");
    	int id=sc.nextInt();
    	System.out.println("Enter the Age");
    	int age=sc.nextInt();
    	
    	Employe e1=new Employe();
    	
    	e1.setid(id);
    	e1.setage(age);
    	String update="UPDATE employe set age=? WHERE id=? ";
    	try {
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstm=con.prepareStatement(update);
			
			pstm.setInt(1, e1.getage());
			pstm.setInt(2, e1.getid());
			pstm.executeUpdate();
			if (res > 0) {
	            System.out.println("Emp Age Updation successfully.");
	        } else {
	            System.out.println("EMP ID  Doesn't Exists.Updation failed.");
	        }
		} 
    	catch (SQLException e) 
		{
		e.printStackTrace();
		} 
    	return res;
    }
    public int updateAll() {
    	int res=0;
    	System.out.println("Enter the Emp ID:");
    	int id=sc.nextInt();
    	sc.nextLine();
    	System.out.println("Enter the Name: ");
    	String name=sc.nextLine();
    	System.out.println("Enter the Age: ");
    	int age=sc.nextInt();
    	System.out.println("Enter the Salary: ");
    	int salary=sc.nextInt();
    	
    	Employe e1=new Employe();
    	e1.setid(id);
    	e1.setname(name);
    	e1.setage(age);
    	e1.setsalary(salary);
    	
    	String updateAll="UPDATE employe set name=?, age=?,salary=? WHERE id=?";
    	
    	try {
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstm=conn.prepareStatement(updateAll);
			
			pstm.setString(1, e1.getname());
			pstm.setInt(2, e1.getage());
			pstm.setInt(3, e1.getsalary());
			pstm.setInt(4, e1.getid());
			res=pstm.executeUpdate();
			if (res > 0) {
	            System.out.println("Employee Information Updated successfully.");
	        } else {
	            System.out.println("EMP ID Doesn't Exists.Insertion failed.");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return res;
    }   
    
/////////////////////////////////////////////////////////////////////////////////////////////////
///
    public void select() {
    	System.out.println("PRESS 1 TO FETCH EMPLOYE DETAILS USING ID:");
    	System.out.println("PRESS 2 TO FETCH ALL EMPLOYES DETAILS:");
    	System.out.println("Enter The Choice: ");
    	int choice=sc.nextInt();
    	switch (choice) {
		case 1:fetch();
			break;
		case 2:fetchAll();
			break;
		default:System.out.println("Enter a valid choice!!!!!");
			break;
		}
    }
    
    public boolean fetch() {
    	boolean res=true;
    	
    	
    	System.out.print("Enter the Emp ID: ");
    	int id=sc.nextInt();
    	Employe e1=new Employe();
    	
    	e1.setid(id);
    	
    	String fetch="SELECT * from employe WHERE id=?";
    	try {
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stm=conn.prepareStatement(fetch);
			stm.setInt(1,e1.getid());
			ResultSet rs= stm.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("Emp ID: "+rs.getInt(1));
				System.out.println("Emp name: "+rs.getString(2));
				System.out.println("Emp Age: "+rs.getInt(3));
				System.out.println("Emp Salary: "+rs.getInt(4));
				}
			rs.close();stm.close();conn.close();
			if(res) {
				System.out.println("Data Fetched!!!!");
			}else System.out.println("Emp ID not found!!!");
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    public boolean fetchAll() {
    	boolean res=true;
    	
    	
    	String fetchAll="SELECT * FROM employe";
    	
    	try {
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(fetchAll);
				while(rs.next()) {
					System.out.println("Emp ID: "+rs.getInt(1));
					System.out.println("Emp name: "+rs.getString(2));
					System.out.println("Emp Age: "+rs.getInt(3));
					System.out.println("Emp Salary: "+rs.getInt(4));
					System.out.println();
				}
				rs.close();stm.close();conn.close();
				if(res) {
					System.out.println("Data Fetched!!!!");
				}else System.out.println("Emp ID not found!!!");
				
		} catch (SQLException e) {	
			e.printStackTrace();
		}
    	return res;
    }
}


