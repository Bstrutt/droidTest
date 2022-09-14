package com.example.buttontest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "ehhhh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Test Section
        FileInputStream fin = null;
        try {
            fin = openFileInput("CoordsFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = "";

        try {
            int c;
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            fin.close();
        } catch (Exception e){

        }
        JSONObject json = null;
        try {
            json = new JSONObject(temp);
        } catch (Throwable t){
            Log.e(TAG, "Couldn't find JSON");
        }

        // ------------------------

        super.onCreate(savedInstanceState);

        TextView field = new TextView(this);
        try {
            field.setText(json.getJSONObject("x").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView field2 = new TextView(this);
        try {
            field2.setText(json.getJSONObject("x").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ConstraintLayout con = (ConstraintLayout) findViewById(R.id.constrantLayout);
        con.addView(field);
        con.addView(field2);

        setContentView(R.layout.activity_second);
    }
}

