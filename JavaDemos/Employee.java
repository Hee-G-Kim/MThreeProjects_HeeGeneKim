public class Employee
{
		//public static int id; //instance variable, non -primitive data type
		private int id;
		private String name;
		public static String CompanyName; 
		
		public String getName(){
			return name;
		}
		public void setName(String name){
			this.name = name;
		}
		
		public int getId(){
			return id;
		}
		public void setId(int id){
			this.id  = id;
		}
		
		
		//INSTANCEA METHOD
		public void doCoding(){
			
			System.out.println("Employee is coding");
			
		}
		
		public static void printCompanyName(){
			
			System.out.println("company name is" + CompanyName);
		}
		

		//public static void main(String[] args){

		//Employee e1 = new Employee();
		//e1.id = 1;
		//e1.name = "Gene";
		//System.out.println("e1.id");
	//}
}