import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;


abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}

class FoodFactory{
	static FoodFactory getFactory() {
		return new FoodFactory();
	}
	void registerCuisine(String cuisineKey, Cuisine cuisine) {
		
	}
}

class Chinese extends Cuisine{
	ArrayList<String> dish;
	Chinese(){
		dish = new ArrayList();
		
	}
	
	 public  Cuisine serveFood(String dish) {
		 this.dish.add(dish);
		 return this;
	 }
}
class Japanese extends Cuisine{
	ArrayList<String> dish;
	Japanese(){
		dish = new ArrayList();
		
	}
	
	 public  Cuisine serveFood(String dish) {
		 this.dish.add(dish);
		 return this;
	 }
}
class Mexican extends Cuisine{
	ArrayList<String> dish;
	Mexican(){
		dish = new ArrayList();
		
	}
	
	 public  Cuisine serveFood(String dish) {
		 this.dish.add(dish);
		 return this;
	 }
}
class Italian extends Cuisine{
	ArrayList<String> dish;
	Italian(){
		dish = new ArrayList();
		
	}
	
	 public  Cuisine serveFood(String dish) {
		 this.dish.add(dish);
		 return this;
	 }
}
public class   MyApplication{                                          
	
	private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();
	
    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }
    
    
    
    
    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
