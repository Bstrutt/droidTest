package com.example.buttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);


    }

    public void goButton(View view) throws IOException {
        // Grab entered numbers.
        EditText xEdit = (EditText) findViewById(R.id.editTextNumber);
        EditText yEdit = (EditText) findViewById(R.id.editTextNumber2);
        int x = Integer.parseInt(xEdit.getText().toString());
        int y = Integer.parseInt(yEdit.getText().toString());

        //Open system files and record numbers there.
        Context context = getApplicationContext();
        FileOutputStream fOut = openFileOutput("CoordsFile", Context.MODE_PRIVATE);
        Toast toast = Toast.makeText(context, "Button pressed", Toast.LENGTH_LONG);
        toast.show();
        JSONObject json = new JSONObject();
        try {
            json.put("x", x);
            json.put("y", y);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String jsonString = json.toString();
        fOut.write(jsonString.getBytes());
        fOut.close();

        openNewActivity();
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }
    
}
