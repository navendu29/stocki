package com.example.saakshi.mystocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e=(EditText) findViewById(R.id.ee);

        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String word=e.getText().toString();

                Intent i=new Intent(Main2Activity.this,Tickers_Activity.class);

                i.putExtra("search",word);
                startActivity(i);



            }
        });





    }
}
