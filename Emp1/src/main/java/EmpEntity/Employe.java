package EmpEntity;

public class Employe {


	
		private int id;
		private String name;
		private int age;
		private int salary;
		
		
		// Get method is used to give the data to the user of private variables.
		public Employe() {
		}
		public int getid() {
			return id;
		}
		public String getname() {
			return name;
		}
		public int getage() {
			return age;
		}
		public int getsalary() {
			return salary;
		}
		
		
		//Set method for the variables to set the data to the variables for private type variables.
		public void setid(int id) {
			this.id=id;
		}
		public void setname(String name) {
			this.name=name;
		}
		public void setage(int age) {
			this.age=age;
		}
		public void setsalary(int salary) {
			this.salary=salary;
		}
		
	}

