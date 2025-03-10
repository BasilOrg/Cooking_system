package org.example;

public class Customer {

    private  String dietaryPreference;
    private  String name;
    private  String allergy;



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

    public  String getDietaryPreference(){

                   return dietaryPreference;
    }









          public  void  setAllergy(String allergy){

                             this.allergy=allergy;
          }

          public String getAllergy(){

              return allergy;
        }









}
