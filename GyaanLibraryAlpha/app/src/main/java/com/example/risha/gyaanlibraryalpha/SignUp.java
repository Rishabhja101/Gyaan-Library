package com.example.risha.gyaanlibraryalpha;



import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;



import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;



public class SignUp extends AppCompatActivity {



    private FirebaseAuth mAuth;

    private String usernames;

    private String passwords;

    private String oldUsernames[];

    private  boolean created;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

                        .setAction("Action", null).show();

            }

        });

        getUsernames();
        created = false;
    }



    public void validate(View view) {

        String firstName;

        String lastName;

        String username;

        String password;

        String repeatPassword;

        boolean valid = true;

        EditText firstNameText = (EditText) findViewById(R.id.firstName);

        username = firstNameText.getText().toString();

        EditText lastNameText = (EditText) findViewById(R.id.lastName);

        password = lastNameText.getText().toString();

        EditText usernameText = (EditText) findViewById(R.id.username);

        username = usernameText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.password);

        password = passwordText.getText().toString();

        EditText repeatPasswordText = (EditText) findViewById(R.id.repeatPassord);

        repeatPassword = repeatPasswordText.getText().toString();



        if (firstNameText.getText().toString().length() == 0) {

            Toast.makeText(SignUp.this, "First Name is required", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (lastNameText.getText().toString().length() == 0) {

            Toast.makeText(SignUp.this, "Last Name is required", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (username.length() == 0) {

            Toast.makeText(SignUp.this, "Username is required", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (password.length() == 0 || repeatPassword.length() == 0) {

            Toast.makeText(SignUp.this, "Password is required", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (!password.contentEquals(repeatPassword)) {

            Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (!usernameIsUnique(username))

        {

            Toast.makeText(SignUp.this, "This username already exists", Toast.LENGTH_SHORT).show();

            valid = false;

        }

        if (valid) {

            createAccount(firstNameText.getText().toString(), lastNameText.getText().toString(), usernameText.getText().toString(), passwordText.getText().toString());
        }

    }



    private boolean usernameIsUnique(String usernameString){

        for (int i = 0; i < oldUsernames.length; i++){

            if (oldUsernames[i].equals(usernameString)){

                return false;

            }

        }

        return true;

    }



    private void getUsernames(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("username");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                oldUsernames = dataSnapshot.getValue().toString().split(", ");

            }



            @Override

            public void onCancelled(DatabaseError databaseError) {



            }

        });

    }



    private void createAccount(String firstName, String lastname, final String username, final String password){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user_" + username);
        myRef.setValue(firstName + ", " + lastname + ", " + username + ", " + password);
        myRef = database.getReference("username");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usernames = (String) dataSnapshot.getValue();
                if (!created)
                    createAccountPart2(username, password);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    private void createAccountPart2(final String username, final String password){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = myRef = database.getReference("password");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                passwords = (String) dataSnapshot.getValue();
                if (!created)
                    createAccountPart3(username, password);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    private void createAccountPart3(final String username, final String password){
        if (!created) {
            created = true;
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("username");
            myRef.setValue(usernames + ", " + username);
            myRef = database.getReference("password");
            myRef.setValue(passwords + ", " + password);
            finish();
        }
    }


    private  void Finish(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void login(View view){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }



}