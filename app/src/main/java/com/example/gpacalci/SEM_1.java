package com.example.gpacalci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SEM_1 extends AppCompatActivity {
    EditText EDT_CHE, EDT_PHY, EDT_MAT, EDT_ENG, EDT_CLAB, EDT_CHEMLAB, EDT_PHYLAB, EDT_C, EDT_BES;
    Button  home, confirm;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_sem1);

        EDT_BES = findViewById(R.id.BES_GRADE);
        EDT_C = findViewById(R.id.C_grade);
        EDT_CHE = findViewById(R.id.che_grade);
        EDT_PHY = findViewById(R.id.phy_grade);
        EDT_MAT = findViewById(R.id.mat_grade);
        EDT_ENG = findViewById(R.id.eng_grade);

        EDT_CLAB = findViewById(R.id.Clab_grade);
        EDT_CHEMLAB = findViewById(R.id.chemlab_grade);
        EDT_PHYLAB = findViewById(R.id.phylab_grade);

        confirm = findViewById(R.id.sem1_confirm_BTN);
        home = findViewById(R.id.sem1_homeBTN);

        confirm.setEnabled(false);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button okay = dialog.findViewById(R.id.btn_okay);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        EDT_CHE.addTextChangedListener(textWatcher);
        EDT_PHY.addTextChangedListener(textWatcher);
        EDT_MAT.addTextChangedListener(textWatcher);
        EDT_ENG.addTextChangedListener(textWatcher);
        EDT_CLAB.addTextChangedListener(textWatcher);
        EDT_CHEMLAB.addTextChangedListener(textWatcher);
        EDT_PHYLAB.addTextChangedListener(textWatcher);
        EDT_C.addTextChangedListener(textWatcher);
        EDT_BES.addTextChangedListener(textWatcher);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sem1 = new Intent(SEM_1.this, MainActivity.class);
                startActivity(sem1);
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            double sub1;
            String Assign1 = EDT_CHE.getText().toString();
            double sub2;
            String Assign2 = EDT_PHY.getText().toString();
            double sub3;
            String Assign3 = EDT_MAT.getText().toString();
            double sub4;
            String Assign4 = EDT_ENG.getText().toString();
            double sub5;
            String Assign5 = EDT_CLAB.getText().toString();
            double sub6;
            String Assign6 = EDT_CHEMLAB.getText().toString();
            double sub7;
            String Assign7 = EDT_PHYLAB.getText().toString();
            double sub8;
            String Assign8 = EDT_C.getText().toString();
            double sub9;
            String Assign9 = EDT_BES.getText().toString();


            if(!Assign1.isEmpty()&&!Assign2.isEmpty()&&!Assign3.isEmpty()
                    &&!Assign4.isEmpty()&&!Assign5.isEmpty()&&!Assign6.isEmpty()
                    &&!Assign7.isEmpty()&&!Assign8.isEmpty()&&!Assign9.isEmpty())
            {
                sub1 = Double.parseDouble(Assign1);
                sub2 = Double.parseDouble(Assign2);
                sub3 = Double.parseDouble(Assign3);
                sub4 = Double.parseDouble(Assign4);
                sub5 = Double.parseDouble(Assign5);
                sub6 = Double.parseDouble(Assign6);
                sub7 = Double.parseDouble(Assign7);
                sub8 = Double.parseDouble(Assign8);
                sub9 = Double.parseDouble(Assign9);

                confirm.setEnabled(true);

                double result = (sub1 + sub2 + sub3 + sub4 + sub5 + sub6 + sub7 + sub8 + sub9) / 9;

                TextView display =  dialog.findViewById(R.id.display);
                display.setText(Double.toString(result));

            }
            else
            {
                confirm.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}