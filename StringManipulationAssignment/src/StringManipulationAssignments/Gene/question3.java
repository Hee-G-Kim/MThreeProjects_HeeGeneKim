package StringManipulationAssignments.Gene;

public class question3 {

	public static void main(String[] args) {
		
		String s= "Hello World"; // o/p: dello WorlH
		
		int leng =s.length(); //11
		String[] reversed= new String[leng];//11
		
	
		String temp1;
		
		//put H in temp
		temp1 = Character.toString(s.charAt(0)); 
		reversed[0]= Character.toString(s.charAt(leng-1));//d
		
		reversed[leng-1]=temp1;
		
		//7
		for (int i = 1; i < leng-1 ; i++) {
			
			reversed[i]= Character.toString(s.charAt(i)); 
			
		} 
		for (int i = 0; i < reversed.length; i++) {
			System.out.print(reversed[i]);
		}	

	}

}
