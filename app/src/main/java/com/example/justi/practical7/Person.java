package com.example.justi.practical7;

/**
 * Created by mhosein 2018.
 */

import android.app.Application;

import java.io.Serializable;

public class Person extends Application implements Serializable {
//
    public String firstName;
    public String lastName;
    public int orders;
    public int id;
    public static int idCounter=100;

    public Person(String first, String last, int ord) {
        firstName = first;
        lastName = last;
        orders = ord;
        id=idCounter;
        idCounter+=100;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public int getOrders () {
        return orders;
    }


    public void updateOrders(int change){

        orders = orders + change;
    }


    public String toString() {
        return new String(id+" "+firstName +  " " + lastName + " " +  orders);
    }

}
