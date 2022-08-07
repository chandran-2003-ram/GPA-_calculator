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

public class SEM_4 extends AppCompatActivity {
    EditText EDT_DM, EDT_CN, EDT_DBMS, EDT_OS, EDT_ES, EDT_SDM, EDT_DBMS_LAB, EDT_OS_LAB, EDT_CN_LAB;
    Dialog dialog;
    Button confirm,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_sem4);

        EDT_DM = findViewById(R.id.DM_GRADE);
        EDT_CN = findViewById(R.id.CN_grade);
        EDT_DBMS = findViewById(R.id.DBMS_GRADE);
        EDT_OS = findViewById(R.id.OS_GRADE);
        EDT_ES = findViewById(R.id.ES_GRADE);
        EDT_SDM = findViewById(R.id.SDM_GRADE);
        EDT_DBMS_LAB = findViewById(R.id.DBMS_LAB_GRADE);
        EDT_OS_LAB = findViewById(R.id.OS_LAB_GRADE);
        EDT_CN_LAB = findViewById(R.id.CN_LAB_GRADE);

        confirm = findViewById(R.id.sem4_confirm_BTN);
        home = findViewById(R.id.SEM4_homeBTN);

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

        EDT_DM.addTextChangedListener(textWatcher);
        EDT_CN.addTextChangedListener(textWatcher);
        EDT_DBMS.addTextChangedListener(textWatcher);
        EDT_OS.addTextChangedListener(textWatcher);
        EDT_ES.addTextChangedListener(textWatcher);
        EDT_SDM.addTextChangedListener(textWatcher);
        EDT_DBMS_LAB.addTextChangedListener(textWatcher);
        EDT_OS_LAB.addTextChangedListener(textWatcher);
        EDT_CN_LAB.addTextChangedListener(textWatcher);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sem4 = new Intent(SEM_4.this, MainActivity.class);
                startActivity(sem4);
            }
        });
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            double sub1 = 0;
            String Assign1 = EDT_DM.getText().toString();
            double sub2 = 0;
            String Assign2 = EDT_CN.getText().toString();
            double sub3 = 0;
            String Assign3 = EDT_DBMS.getText().toString();
            double sub4 = 0;
            String Assign4 = EDT_OS.getText().toString();
            double sub5 = 0;
            String Assign5 = EDT_ES.getText().toString();
            double sub6 = 0;
            String Assign6 = EDT_SDM.getText().toString();
            double sub7 = 0;
            String Assign7 = EDT_DBMS_LAB.getText().toString();
            double sub8 = 0;
            String Assign8 = EDT_OS_LAB.getText().toString();
            double sub9 = 0;
            String Assign9 = EDT_CN_LAB.getText().toString();


            if(!Assign1.isEmpty()&&!Assign2.isEmpty()&&!Assign3.isEmpty()
                    &&!Assign4.isEmpty()&&!Assign5.isEmpty()&&!Assign6.isEmpty()
                    &&!Assign7.isEmpty()&&!Assign8.isEmpty()&&!Assign9.isEmpty())
            {
                if (Assign1.equals("O"))
                    sub1 = 10;
                else if (Assign1.equals("A+"))
                    sub1 = 9;
                else if (Assign1.equals("A"))
                    sub1 = 8;
                else if (Assign1.equals("B+"))
                    sub1 = 7;
                else if (Assign1.equals("B"))
                    sub1 = 6;
                else if (Assign1.equals("RA"))
                    sub1 = 0;

                if (Assign2.equals("O"))
                    sub2 = 10;
                else if (Assign2.equals("A+"))
                    sub2 = 9;
                else if (Assign2.equals("A"))
                    sub2 = 8;
                else if (Assign2.equals("B+"))
                    sub2 = 7;
                else if (Assign2.equals("B"))
                    sub2 = 6;
                else if (Assign2.equals("RA"))
                    sub2 = 0;

                if (Assign3.equals("O"))
                    sub3 = 10;
                else if (Assign3.equals("A+"))
                    sub3 = 9;
                else if (Assign3.equals("A"))
                    sub3 = 8;
                else if (Assign3.equals("B+"))
                    sub3 = 7;
                else if (Assign3.equals("B"))
                    sub3 = 6;
                else if (Assign3.equals("RA"))
                    sub3 = 0;

                if (Assign4.equals("O"))
                    sub4 = 10;
                else if (Assign4.equals("A+"))
                    sub4 = 9;
                else if (Assign4.equals("A"))
                    sub4 = 8;
                else if (Assign4.equals("B+"))
                    sub4 = 7;
                else if (Assign4.equals("B"))
                    sub4 = 6;
                else if (Assign4.equals("RA"))
                    sub4 = 0;

                if (Assign5.equals("O"))
                    sub5 = 10;
                else if (Assign5.equals("A+"))
                    sub5 = 9;
                else if (Assign5.equals("A"))
                    sub5 = 8;
                else if (Assign5.equals("B+"))
                    sub5 = 7;
                else if (Assign5.equals("B"))
                    sub5 = 6;
                else if (Assign5.equals("RA"))
                    sub5 = 0;

                if (Assign6.equals("O"))
                    sub6 = 10;
                else if (Assign6.equals("A+"))
                    sub6 = 9;
                else if (Assign6.equals("A"))
                    sub6 = 8;
                else if (Assign6.equals("B+"))
                    sub6 = 7;
                else if (Assign6.equals("B"))
                    sub6 = 6;
                else if (Assign6.equals("RA"))
                    sub6 = 0;

                if (Assign7.equals("O"))
                    sub7 = 10;
                else if (Assign7.equals("A+"))
                    sub7 = 9;
                else if (Assign7.equals("A"))
                    sub7 = 8;
                else if (Assign7.equals("B+"))
                    sub7 = 7;
                else if (Assign7.equals("B"))
                    sub7 = 6;
                else if (Assign7.equals("RA"))
                    sub7 = 0;

                if (Assign8.equals("O"))
                    sub8 = 10;
                else if (Assign8.equals("A+"))
                    sub8 = 9;
                else if (Assign8.equals("A"))
                    sub8 = 8;
                else if (Assign8.equals("B+"))
                    sub8 = 7;
                else if (Assign8.equals("B"))
                    sub8 = 6;
                else if (Assign8.equals("RA"))
                    sub8 = 0;

                if (Assign9.equals("O"))
                    sub9 = 10;
                else if (Assign9.equals("A+"))
                    sub9 = 9;
                else if (Assign9.equals("A"))
                    sub9 = 8;
                else if (Assign9.equals("B+"))
                    sub9 = 7;
                else if (Assign9.equals("B"))
                    sub9 = 6;
                else if (Assign9.equals("RA"))
                    sub9 = 0;

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