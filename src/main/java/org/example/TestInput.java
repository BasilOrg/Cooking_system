package org.example;

public class TestInput {



    public static boolean nameTest(String name) {

           name=name.toUpperCase();

           if(name.equals("BASIL"))return true;

           else  return false;
    }




    public static boolean dietaryPresencesTest(String dietaryPresences) {

        dietaryPresences=dietaryPresences.toUpperCase();

        if(dietaryPresences.equals("VEGAN")||dietaryPresences.equals("VEGETARIAN"))return true;


       else return false;
    }




    public static boolean allergiesTest(String allergies) {

        allergies=allergies.toUpperCase();
        if(allergies.equals("PEANUTS"))return  true;

        return false;
    }


}
