package com.example.gpacalci;

import androidx.appcompat.app.AppCompatActivity;

// import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        spinner = findViewById(R.id.mainspin);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,R.array.SEM, android.R.layout.simple_spinner_item);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getItemAtPosition(position).equals("choose"))
                {

                }

                else
                {
                    String text = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                if (parent.getItemAtPosition(position).equals("sem1"))
                {
                    Intent intent1 = new Intent(MainActivity.this, SEM_1.class);
                    startActivity(intent1);

                }
                if (parent.getItemAtPosition(position).equals("sem2"))
                {
                    Intent intent2 = new Intent(MainActivity.this, SEM_2.class);
                    startActivity(intent2);

                }
                if (parent.getItemAtPosition(position).equals("sem3"))
                {
                    Intent intent3 = new Intent(MainActivity.this, SEM_3.class);
                    startActivity(intent3);

                }
                if (parent.getItemAtPosition(position).equals("sem4"))
                {
                    Intent intent4 = new Intent(MainActivity.this, SEM_4.class);
                    startActivity(intent4);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enableIntent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
                enableIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(enableIntent);

            }
        });
    }
}