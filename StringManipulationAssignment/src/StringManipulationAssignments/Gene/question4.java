package StringManipulationAssignments.Gene;

public class question4 {

	public static void main(String[] args) {
		/* Find the substring which is having max length, if two strings lengths are equal
		return the first one.
				Sample input 1 : "Hi How are you"
				Sample output 1 : How
				Sample input 2 : "This is java String program"
				Sample output 2 : program*/
		
		String str = "Hi How are you";
		String[] words = str.split(" ");
		
		int max = words[0].length();
		String maxWord =  words[0];
		for (int i = 1; i < words.length; i++) {

				if (words[i].length() > max ) {
				     max =words[i].length();
				     maxWord = words[i];
				}
		}
		System.out.println(maxWord);

	}

}
