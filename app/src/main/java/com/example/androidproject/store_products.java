package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class store_products extends AppCompatActivity {

    RecyclerView recyclerView;

    //declaring and initializing arrays
    String s1[],s2[], s3[],s4[];
    int images[] = {R.drawable.pubg,R.drawable.gta,R.drawable.cod,R.drawable.fortnite,R.drawable.coc,R.drawable.ac};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_products);
        recyclerView = findViewById(R.id.recyclerView);

        //assigning values to array using getstringarray
        s1 = getResources().getStringArray(R.array.products);
        s2 = getResources().getStringArray(R.array.descriptions);
        s3 = getResources().getStringArray(R.array.prices);
        s4 = getResources().getStringArray(R.array.details);

        //passing values to myadapter
        MyAdapter myAdapter =new MyAdapter(this,s1,s2,s3,s4,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
