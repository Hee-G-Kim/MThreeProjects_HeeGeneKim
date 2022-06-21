package exercisestatecapitals3;

public class StateCapitals3 {

         private  String name;
         private int Population;
         private double squareMileage;
         public StateCapitals3(String name, int population, double squareMileage) {
                  super();
                  this.name = name;
                  Population = population;
                  this.squareMileage = squareMileage;
         }
         public String getName() {
                  return name;
         }
         public void setName(String name) {
                  this.name = name;
         }
         public int getPopulation() {
                  return Population;
         }
         public void setPopulation(int population) {
                  Population = population;
         }
         public double getSquareMileage() {
                  return squareMileage;
         }
         public void setSquareMileage(double squareMileage) {
                  this.squareMileage = squareMileage;
         }
         @Override
         public String toString() {
                  return "StateCapitals3 [name=" + name + ", Population=" + Population + ", squareMileage="
                                    + squareMileage + "]";
         }
         

}


