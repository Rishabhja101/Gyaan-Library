package com.example.risha.gyaanlibraryalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseBookView extends AppCompatActivity {

    private static final String TAG = "Gulshan-";
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


//    private TextView txtDetails;
//    private EditText inputName, inputEmail;
//    private Button btnSave;
    RecyclerView r;
    MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_book_view);


        // Displaying toolbar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

//        txtDetails = (TextView) findViewById(R.id.txt_user);
//        inputName = (EditText) findViewById(R.id.name);
//        inputEmail = (EditText) findViewById(R.id.email);
//        btnSave = (Button) findViewById(R.id.btn_save);
        r = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        r.setLayoutManager(layoutManager);


        mFirebaseInstance = FirebaseDatabase.getInstance(); // Create Firebase Data Reference
        // get reference to 'Books' node
        mFirebaseDatabase = mFirebaseInstance.getReference("username"); // Firebase JSON data reference element
        Log.e(TAG, mFirebaseDatabase.toString());

        // store app title to 'app_title' node
        //mFirebaseInstance.getReference("Books").get .setValue("Books Realtime Database");

        // Firebase Data listener
        mFirebaseInstance.getReference("Books").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                ArrayList<String> bookNames = new ArrayList<>();
                bookNames.add(appTitle);

                Log.e(TAG, appTitle); // appTitle shows JSON Data from Firebase

                adapter = new MyRecyclerViewAdapter(getApplicationContext(), bookNames);
                adapter.setClickListener(new MyRecyclerViewAdapter.ItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(FirebaseBookView.this, "clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                r.setAdapter(adapter);

                // update toolbar title
                //getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });
        /* End GulshanK */

    }
}
