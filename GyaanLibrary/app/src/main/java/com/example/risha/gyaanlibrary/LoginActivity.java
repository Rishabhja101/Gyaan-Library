package com.example.risha.gyaanlibrary;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    private void GetCredentials(){
        EditText usernameText = (EditText)findViewById(R.id.username);
        username = usernameText.getText().toString();
        EditText passwordText = (EditText)findViewById(R.id.password);
        password = passwordText.getText().toString();
    }

    public void AttemptLogin(View view){
        GetCredentials();
      //  Toast.makeText(LoginActivity.this, "asdfasdfasdfadsfasdf",
      //          Toast.LENGTH_SHORT).show();

        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Authentication not failed.",
                                    Toast.LENGTH_SHORT).show();
                  } else {
                            // If sign in fails, display a message to the user.
                         Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                      }
                        Toast.makeText(LoginActivity.this, "Authentication somewhat failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });



    }

    public void CreateUser(View view){
        GetCredentials();
        Toast.makeText(LoginActivity.this, "asdfsdafsdafadsfghtyrkjyutmkyuilyuilkuiykyuik.",
                Toast.LENGTH_SHORT).show();
    }


}
