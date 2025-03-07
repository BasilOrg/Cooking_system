package org.example;

public class Customer {

    public static String dietaryPreference;
    public static String name;
    public static String allergy;



    public Customer() {

    }


    public static boolean testName(String name) {
        name=name.toUpperCase();
        if(name.equalsIgnoreCase("Basil")||name.equalsIgnoreCase("Yezane"))return true;

         else return false;
    }








}
