public class TestEmployee{
	
	int x; //instance variables- out sode of 
	          //method but wihtin class
	static int y; //static variablele
	Employee e1; //instance variable- 
		             //Employee -user defind dta type
					 
	public static void main (String args[]){
	
		System.out.println("Welcome to Java");
		int x; //local variable
		Employee e1 = null; //local variable- 
		             //Employee -user defind dta type
		//e1.id = 10; --> will cause null pointrer error
		e1 = new Employee(); //object ==stroed in heap	
		e1.setId(-10);	
		Employee e2 = new Employee();
		e2.setId(1000);
		e1.setName("Jooperd");
		System.out.println(e1.getId());
		System.out.println(e2.getId());
		Employee.printCompanyName();
		System.out.println(e1.getName());
		e1.printCompanyName();
		//Employee.doCoding();//TestEmployee.java:24: error: 
		//non-static method doCoding() 
		//cannot be referenced from a static context Employee.doCoding();
		
		
		
		
		
		
		
		
		
		
	}
	



}
