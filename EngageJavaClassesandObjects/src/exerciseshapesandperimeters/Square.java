package exerciseshapesandperimeters;

public class Square extends Shape {

         public int area;
         private int perimeter;
         
         
         public Square(){
                  //
         }

         @Override
         public void getArea() {
                  this.area = perimeter/4*2;
                  System.out.println("inside square getArea");

         }

         @Override
         public void getPerimeter(int side) {
                  // TODO Auto-generated method stub
                  this.perimeter=side*4;
                  System.out.println("inside square getPerimeter");
         }

}
