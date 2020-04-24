package com.example.test0320;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static java.lang.Double.*;

public class show_bmi_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi_);

        TextView show_name = (TextView) findViewById(R.id.tv_name);
        ImageView view1 = (ImageView) findViewById((R.id.iv_pic1));
        TextView show_bmi = (TextView) findViewById(R.id.tv_bmi1);

        Bundle bundle = getIntent().getExtras();
        String n = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");


        double bmi = parseDouble(w)/ (parseDouble(h) / 100.0 * parseDouble(h) / 100.0);
        DecimalFormat df = new DecimalFormat("#.#");



        String msg;
        if (bmi < 18.5) {
            msg = getString(R.string.strtoolow);
            Toast.makeText(this, "體重過輕", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.b2);
        } else if (bmi > 24) {
            msg = getString(R.string.strtoohigh);
            Toast.makeText(this, "體重過重", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b1);
        } else {
            msg = getString(R.string.strstd);
//            Toast.makeText(this, "體重正常", Toast.LENGTH_SHORT).show();
            view1.setImageResource(R.drawable.b3);
        }

        TextView b = findViewById(R.id.tv_bmi1);

        show_name.setText(n);
        show_bmi.setText(getString(R.string.strshowbmi) + df.format(bmi) + msg);

        }
        }


