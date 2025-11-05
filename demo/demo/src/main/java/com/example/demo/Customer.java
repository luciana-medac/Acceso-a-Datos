package com.example.demo;
public class Customer {

    private int id;
    private String firstName;
    private String lastName;

    //CONSTRUCTOR VACIO
    public Customer(){
    }

    //CONSTRUCTOR
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //GETTERS
    public int getId() {
        return id;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
    
}
