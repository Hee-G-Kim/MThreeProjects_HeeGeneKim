package StringManipulationAssignments.Gene;

public class question1 {

	public static void main(String[] args) {
		
		
		String s= "computer"; // r-e-t-u-p-m-o-c
		
		int l =s.length(); //l=8
		String[] reversedDash= new String[l];
		
		String temp1;
		
		temp1 = Character.toString(s.charAt(0));  //temp1=c
		reversedDash[0]= Character.toString(s.charAt(l-1))+"-";
		//reversedDash[0]= r-
		reversedDash[l-1]=temp1;//reversedDash[8]=c
		
		
		//String s= "computer"; // r-e-t-u-p-m-o-c
		int nl =s.length()-1; //7
		for (int i = 1; i < nl-3 ; i++) {
			
			String temp2;
			//put r in temp
			
			temp2 = Character.toString(s.charAt(i))+ "-"; 
			reversedDash[i]= Character.toString(s.charAt(nl-i))
					+ "-";//6
			reversedDash[nl-i]=temp2;
			
		} 
		for (int i = 0; i < reversedDash.length; i++) {
			System.out.print(reversedDash[i]);
		}	
		
		
	}

}
