package assessment.basicprogrammingconcepts.gene;

public class SummativeSums {
            public static int sumIntArray(int[] a) {
                        int sum = 0;
                        for (int i = 0; i < a.length; i++) {
                                sum += a[i];    
                        }
                       return sum;
            }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	              
	            int[] numbers1 =new int[]{ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
	            int[] numbers2 =new int[]{ 999, -60, -77, 14, 160, 301 };
	            int[] numbers3 =new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
	                                    140, 150, 160, 170, 180, 190, 200, -99 } ;
	            
	            System.out.println("#1 Array Sum: " + sumIntArray(numbers1));
	            System.out.println("#2 Array Sum: " + sumIntArray(numbers2));
	            System.out.println("#3 Array Sum: " + sumIntArray(numbers3));
	            
	}
	            

}
