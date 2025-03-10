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
        for(int i=0;i< ac.size();i++) {
            Customer typ = new Customer();
            typ = ac.get(i);
            if(name.equals(typ.name)){
                System.out.println(ac.get(i));
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

                              this.dietaryPreference=dietaryPreference;
    }

    public static String getDietaryPreference(){

                   return dietaryPreference;
    }









          public  void  setAllergy(String allergy){

                             this.allergy=allergy;
          }

          public static String getAllergy(){

              return allergy;
        }









}
