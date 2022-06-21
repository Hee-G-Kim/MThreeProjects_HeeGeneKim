package interfaceexample;

public class MainInterface {

         public static void main(String[] args) {
                  
                  //polymorphism
                Van van = new Van(); //full van
                Vehicle vehicle = new Van();  //the van is a vehicle only
                Trackable trackable = new Van();  //van is a trackable

         }

}
