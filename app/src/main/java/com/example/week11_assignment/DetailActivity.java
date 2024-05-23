package com.example.week11_assignment;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView titleTv, detailTv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleTv = (TextView) findViewById(R.id.itemtitle);
        detailTv = (TextView) findViewById(R.id.detail);
        iv = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");
        String detail_msg = intent.getStringExtra("detail_msg");
        int id = intent.getIntExtra("id", 0);

        iv.setImageResource(id);
        titleTv.setText(title);
        detailTv.setText("가격: " + price + "\n" + detail_msg);
    }
}