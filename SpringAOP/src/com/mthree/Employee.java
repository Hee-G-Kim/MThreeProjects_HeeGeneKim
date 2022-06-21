package com.mthree;

public class Employee {

         private int eid;
         private String fname;
         private String lname;
         
         public void Employee() {
                  
         }

         public int getEid() {
                  return eid;
         }

         public void setEid(int eid) {
                  this.eid = eid;
         }

         public Employee(int id, String fname, String lname) {
                  super();
                  this.eid = id;
                  this.fname = fname;
                  this.lname = lname;
         }

//         public int getId() {
//                  return eid;
//         }
//
//         public void setId(int id) {
//                  this.id = id;
//         }

         public String getFname() {
                  return fname;
         }

         public void setFname(String fname) {
                  this.fname = fname;
         }

         public String getLname() {
                  return lname;
         }

         public void setLname(String lname) {
                  this.lname = lname;
         }

         @Override
         public String toString() {
                  return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + "]";
         }

//         @Override
//         public String toString() {
//                  return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
//         }
         
         
}
