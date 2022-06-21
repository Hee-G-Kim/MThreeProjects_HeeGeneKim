package com.mthree;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component(value = "a3") //it is exactly like saying  <bean id="a3" class="com.mthree.Address"  lazy-init="true" scope="singleton">
public class Address {
         @Value(value = "Australia")
         private String country;
         @Value(value = "Canberra")
         private String state;
         @Value(value = "2000")
         private String street;
         @Value(value = "45 politics rd")
         private String postcode;

         public Address() {
                  System.out.println("Inside default constructor of Address");
         }
         //
      
         public Address(String country, String state, String street, String postcode) {
                  System.out.println("Inside parametised constructor of Address");
                  this.country = country;
                  this.state = state;
                  this.street = street;
                  this.postcode = postcode;
         }
         public String getStreet() {
                  return street;
         }
         public void setStreet(String street) {
                  System.out.println("Inside setStreet of Address ");
                  this.street = street;
         }
         
         public String getCountry() {
                  return country;
         }

         public void setCountry(String country) {
                  System.out.println("Inside setCountry of Address ");
                  this.country = country;
         }

         public String getState() {
                  return state;
         }


         public void setState(String state) {
                  System.out.println("Inside setState of Address ");
                  this.state = state;
         }


         public String getPostcode() {
                  return postcode;
         }


         public void setPostcode(String postcode) {
                  System.out.println("Inside setPostcode of Address ");
                  this.postcode = postcode;
         }



         @Override
         public String toString() {
                  return "Address [country=" + country + ", state=" + state + ", street=" + street + ", postcode="
                                    + postcode + "]";
         }




        
}
