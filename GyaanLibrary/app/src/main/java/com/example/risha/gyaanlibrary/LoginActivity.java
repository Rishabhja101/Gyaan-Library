package com.example.risha.gyaanlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
//    private FirebaseAuth mAuth;
//    private String username;
//    private String password;
//    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mAuth = FirebaseAuth.getInstance();
        Toast.makeText(this, "LoginActivity", Toast.LENGTH_SHORT).show();
        // bundle = getIntent().getBundleExtra("pass");
    }
/*
    private void GetCredentials() {
        EditText usernameText = (EditText) findViewById(R.id.username);
        username = usernameText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.password);
        password = passwordText.getText().toString();
    }

    int userIndex;

    public void AttemptLogin(View view) {
        GetCredentials();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("username");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userIndex = 0;
                String usernames[] = dataSnapshot.getValue().toString().split(",");
                while (userIndex < usernames.length && !usernames[userIndex].equals(username)) {
                    userIndex++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("password");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String passwords[] = dataSnapshot.getValue().toString().split(",");
                if (userIndex < passwords.length && passwords[userIndex].equals(password)) {
                    Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
//                } else {
                    Toast.makeText(LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void CreateUser(View view) {
        GetCredentials();
        Toast.makeText(LoginActivity.this, "asdfsdafsdafadsfghtyrkjyutmkyuilyuilkuiykyuik.", Toast.LENGTH_SHORT).show();
    }
*/
}
