package com.mthree;

public class StaticDemo {

         static {
                  System.out.println("Inside static block 1");
         }
         public static void main(String[] args) {
                  System.out.println("Inside main()");

         }
         static {
                  System.out.println("Inside static block 2");
         }

}
