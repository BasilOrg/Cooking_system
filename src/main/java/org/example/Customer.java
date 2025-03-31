package org.example;

import java.util.ArrayList;

public class Customer {

    private static String dietaryPreference;
    private  String name;
    private static String allergy;

    static ArrayList<Customer> ac=new ArrayList<>();





    public static void storeCustomer(Customer customer) {

        ac.add(customer);
    }

    public static void searchCustomerName(String name) {
        for (Customer customer : ac) {
            Customer typ = new Customer();
            typ = customer;
            if (name.equals(typ.name)) {
                System.out.println(customer);
            }
        }
    }


    @Override
    public String toString() {

        return ( "Customer Name:"+name+'\t'+"DietaryPreference:"+dietaryPreference+"\t"+"Allergy:"+allergy+"\n");
    }


    public Customer() {

    }


    public void setName(String name){

                  this.name=name;
    }

    public String getName(){

                       return name;
    }







      public  void setDietaryPreference(String dietaryPreference){

                              Customer.dietaryPreference =dietaryPreference;
    }

    public static String getDietaryPreference(){

                   return dietaryPreference;
    }









          public  void  setAllergy(String allergy){

                             Customer.allergy =allergy;
          }

          public static String getAllergy(){

              return allergy;
        }









}
