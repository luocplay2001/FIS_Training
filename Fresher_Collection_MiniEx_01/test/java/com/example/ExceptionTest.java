package com.example;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionTest {

    public static void main(String[] args) {
//        try {
//            double data = 1/0;
//        } catch (Exception ex) {
////            ex.printStackTrace();
//            System.out.println("Error");
//        }
//        System.out.println("App running");

        try {
            System.out.println("About to open a file");
            InputStream in = new FileInputStream("missingfile.txt");
            System.out.println("File open");
        } catch (FileNotFoundException e) {
            System.out.println("Don'n read file");
//            e.printStackTrace();
        }
        System.out.println("App running");
    }

    @Test
    void testException() {
        double a = 0;
        double b = 0;
        double data = divideA_B(a,b);
    }


    public static double divideA_B(double a, double b) {
        return a/b;
    }
}
