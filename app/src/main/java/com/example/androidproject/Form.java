package com.example.androidproject;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.*;
import android.content.*;

public class Form extends AppCompatActivity {

    //declaring variables
    ImageView img_form;
    int imgint;
    String data1;
    Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_form);

        //referencing variables to desired buttons
        img_form = findViewById(R.id.img_form);
        checkoutButton = findViewById(R.id.checkout);

        //setting up onclick listener on button
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            //this will call function names switchToThankYouPage
            {
                switchToThankYouPage();
            }
        });

        //This will call functions named below
        getData();
        setData();
    }


    //this function will be called when user clicks on button and it will use the data1 and display_iamgeview
    // which we had created in another java class
    private void getData(){
        if(getIntent().hasExtra("data1"))
        {
            //using getstringextra to store image in a variable
            data1 =getIntent().getStringExtra("data1");
            imgint = getIntent().getIntExtra("display_imageView",1);

        }else {
            Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show();
        }
    }

    //this function will be called when user clicks button and it will set image according to user selection
    private void setData(){
        img_form.setImageResource(imgint);
    }

    //this function will switch user to thank you page
    public void switchToThankYouPage() {
        Intent intent = new Intent(this, ThankYou.class);
        startActivity(intent);
    }

}