package com.example.convertisseurdevise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner s1,s2;
    EditText tx1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.montatnt);
        s1 = findViewById(R.id.spFrom);
        s2 = findViewById(R.id.spTo);
        b1 = findViewById( R.id.btn1);

        String [] from = { "DTN","Euro","USD"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        s1.setAdapter(ad);
        String [] to = { "DTN","Euro","USD"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        s2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Double total;

               Double M=Double.parseDouble(tx1.getText().toString());
               if (s1.getSelectedItem().toString() == "DTN" && s2.getSelectedItem().toString() == "Euro" || s2.getSelectedItem().toString() == "USD")
               {
                   total = M * 0.31 ;
                   Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
               }
                if (s1.getSelectedItem().toString() == "Euro" && s2.getSelectedItem().toString() == "DTN")
               {
                   total = M * 3.23 ;
                   Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
               }
                if (s1.getSelectedItem().toString() == "USD" && s2.getSelectedItem().toString() == "DTN")
                {
                    total = M * 3.24 ;
                    Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                }
                else if (s1.getSelectedItem().toString() == "Euro" || s1.getSelectedItem().toString() == "USD" && s2.getSelectedItem().toString() == "USD" || s2.getSelectedItem().toString() == "Euro")
                {
                    total = M * 1.00 ;
                    Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}