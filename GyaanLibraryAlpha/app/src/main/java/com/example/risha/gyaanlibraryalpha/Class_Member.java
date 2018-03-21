package com.example.risha.gyaanlibraryalpha;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by risha on 2/27/2018.
 */

public  class Class_Member {
    public String username;
    public String firstName;
    public String lastName;
    public final int numAllowed = 5; // in days
    public final int checkoutTime = 14; // in days
    public int fines; // in dollars
    public ArrayList<String> rentals;
    public ArrayList<String> reservations;
    public  static Class_Member user;

    public Class_Member(final String newUsername){
        retireveInfo(newUsername);
    }

    private void addData(String username, String firstName, String lastName, ArrayList<String> rentals, ArrayList<String> reservations){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rentals = rentals;
        this.reservations = reservations;
    }

    private void retireveInfo(final String newUsername){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user_" + newUsername);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             //   String data[] = dataSnapshot.getValue().toString().split(", ");
           //     ArrayList<String> rentals = new ArrayList<String>();
          //      String[] rentalArray = data[4].split("|");
          //      for (int i = 0; i < rentalArray.length; i++){
          //          rentals.add(rentalArray[i]);
          //      }
          //      ArrayList<String> reservations = new ArrayList<String>();
           //         String[] reservationArray = data[5].split("|");
          //      for (int i = 0; i < reservationArray.length; i++){
          //          reservations.add(reservationArray[i]);
          //      }
          //      addData(newUsername, data[0], data[1], rentals, reservations);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void chockoutBook(Class_Book book){
        String rental = "";
        rental += book.id;
        rental += "-";
        rental += book.title;
        rental += "-";
        rental += book.author;
        rental += "-";
        rental += ""; // rental (current) date
        rental += "-";
        rental += ""; // due date
        rentals.add(rental);
    }

    public void reserveBook(Class_Book book)
    {
        String reservation = "";
        reservation += book.id;
        reservation += "-";
        reservation += book.title;
        reservation += "-";
        reservation += book.author;
        rentals.add(reservation);
    }

}
