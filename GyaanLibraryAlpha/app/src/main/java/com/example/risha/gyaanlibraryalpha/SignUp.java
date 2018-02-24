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
    }

    public void validate(View view)
    {
        String firstName;
        String lastName;
        String username;
        String password;
        String repeatPassword;
        boolean valid = true;
        EditText firstNameText = (EditText)findViewById(R.id.firstName);
        username = firstNameText.getText().toString();
        EditText lastNameText = (EditText)findViewById(R.id.lastName);
        password = lastNameText.getText().toString();
        EditText usernameText = (EditText)findViewById(R.id.username);
        username = usernameText.getText().toString();
        EditText passwordText = (EditText)findViewById(R.id.password);
        password = passwordText.getText().toString();
        EditText repeatPasswordText = (EditText)findViewById(R.id.repeatPassord);
        username = repeatPasswordText.getText().toString();

        if (firstNameText.length() == 0)
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (lastNameText.length() == 0)
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (usernameText.length() == 0)
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (password.length() == 0)
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (repeatPasswordText.length() == 0)
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (passwordText.equals(repeatPasswordText))
        {
            Toast.makeText(SignUp.this, "", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (valid)
            createAccount(firstNameText.getText().toString(), lastNameText.getText().toString(), usernameText.getText().toString(), passwordText.getText().toString());
    }

    private String usernames;
    private String passwords;

    private void createAccount(String firstName, String lastname, String username, String password)
    {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user_" + username);

        myRef.setValue(firstName + ", " + lastname + ", " + username + ", " + password);

        myRef = database.getReference("username");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usernames = (String) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef.setValue(usernames + ", " + username);

        myRef = database.getReference("password");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                passwords = (String) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        myRef.setValue(passwords + ", " + password);
    }

    public void login(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
