package com.example.us.quocnhan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.us.inputdatabase_t163472_w06.R;

public class AddCarActivity extends AppCompatActivity {
    Button them,sua,xoa,thoat;
    EditText engay,ethang,enam,egio;
   car ca= new car(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        them=(Button)findViewById(R.id.btn_them);
        sua=(Button)findViewById(R.id.btn_sua);
        xoa=(Button)findViewById(R.id.btn_xoa);

        thoat=(Button)findViewById(R.id.btn_thoat);
        engay=(EditText)findViewById(R.id.et_ngay);
        ethang=(EditText)findViewById(R.id.et_thang);
        enam=(EditText)findViewById(R.id.ed_nam);
        egio=(EditText)findViewById(R.id.ed_gio);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lay thong tin de chuyen qua coso dulieu
                ca.taotime(engay.getText().toString(),ethang.getText().toString(),enam.getText().toString(),egio.getText().toString());
                finish();
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ca.suatime(engay.getText().toString(),ethang.getText().toString(),enam.getText().toString(),egio.getText().toString());
                finish();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ca.xoatime(engay.getText().toString());
                finish();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
