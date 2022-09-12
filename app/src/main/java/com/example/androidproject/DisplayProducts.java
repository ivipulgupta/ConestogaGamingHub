package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayProducts extends AppCompatActivity {

    ImageView display_imageView;
    TextView display_description,display_title;
    Button btn_cart;
    TextView display_price;
    TextView display_details;


    String data1,data2, data3,data4;
    int myImage;
    int imgtrs;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);


        display_imageView = findViewById(R.id.display_imageView);
        display_title = findViewById(R.id.display_title);
        display_description = findViewById(R.id.display_description);
        btn_cart = findViewById(R.id.btn_cart);

        display_price = findViewById(R.id.price);
        display_details = findViewById(R.id.display_details);




        getData();
        setData();



    }

    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("display_imageView")){
            data1 =getIntent().getStringExtra("data1");
            data2 =getIntent().getStringExtra("data2");
            data3 =getIntent().getStringExtra("data3");
            data4 =getIntent().getStringExtra("data4");

            myImage = getIntent().getIntExtra("display_imageView",1);

        }else {
            Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        display_title.setText(data1);
        display_description.setText(data2);
        display_imageView.setImageResource(myImage);
        display_price.setText(data3);
        display_details.setText(data4);
        imgtrs = myImage;
        value = display_title.getText().toString();

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newactivity();
            }

        });

    }

    public void newactivity(){
        Intent intent = new Intent(this ,Form.class);
        intent.putExtra("data1",value);
        intent.putExtra("display_imageView",imgtrs);
        startActivity(intent);
    }
}