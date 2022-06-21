package com.mthree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportService {

         private String filename;
         private PrintWriter writer;
         
         public  ReportService() {
               System.out.println("Inside defaut contstrucor");
         }

         public String getFilename() {
                  return filename;
         }

         public void setFilename(String filename) {
                  System.out.println("Inside setfilename for reportservice: " + filename);
                  this.filename = filename;
         }
         public void doInit() {
                  System.out.println("Inside doinit, init writer ");
                  try {
                           writer = new PrintWriter(this.filename);
                  } catch (FileNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }
         }
         
         public void generateReport() {
                  System.out.println("Inside generateReport-business method");
                  writer.write("generating a report..");
         }
         
         public void doDestroy() {
                  System.out.println("Inside doDestroy");
                  writer.close();
         }
         
}
