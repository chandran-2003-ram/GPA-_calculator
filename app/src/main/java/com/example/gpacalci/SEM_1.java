package com.example.gpacalci;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SEM_1 extends AppCompatActivity {
    EditText EDT_CHE, EDT_PHY, EDT_MAT, EDT_ENG, EDT_C_LAB, EDT_CHEM_LAB, EDT_PHY_LAB, EDT_C, EDT_BES;
    Button  confirm;
    Dialog dialog;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gpa-calculator-80e03-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_sem1);

        getSupportActionBar().setTitle("SEM 1");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        EDT_BES = findViewById(R.id.BES_GRADE);
        EDT_C = findViewById(R.id.C_grade);
        EDT_CHE = findViewById(R.id.che_grade);
        EDT_PHY = findViewById(R.id.phy_grade);
        EDT_MAT = findViewById(R.id.mat_grade);
        EDT_ENG = findViewById(R.id.eng_grade);

        EDT_C_LAB = findViewById(R.id.C_lab_grade);
        EDT_CHEM_LAB = findViewById(R.id.chem_lab_grade);
        EDT_PHY_LAB = findViewById(R.id.phy_lab_grade);

        confirm = findViewById(R.id.sem1_confirm_BTN);
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

        EDT_CHE.addTextChangedListener(textWatcher);
        EDT_PHY.addTextChangedListener(textWatcher);
        EDT_MAT.addTextChangedListener(textWatcher);
        EDT_ENG.addTextChangedListener(textWatcher);
        EDT_C_LAB.addTextChangedListener(textWatcher);
        EDT_CHEM_LAB.addTextChangedListener(textWatcher);
        EDT_PHY_LAB.addTextChangedListener(textWatcher);
        EDT_C.addTextChangedListener(textWatcher);
        EDT_BES.addTextChangedListener(textWatcher);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
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
            String Assign1 = EDT_CHE.getText().toString();
            double sub2 = 0;
            String Assign2 = EDT_PHY.getText().toString();
            double sub3 = 0;
            String Assign3 = EDT_MAT.getText().toString();
            double sub4 = 0;
            String Assign4 = EDT_ENG.getText().toString();
            double sub5 = 0;
            String Assign5 = EDT_C_LAB.getText().toString();
            double sub6 = 0;
            String Assign6 = EDT_CHEM_LAB.getText().toString();
            double sub7 = 0;
            String Assign7 = EDT_PHY_LAB.getText().toString();
            double sub8 = 0;
            String Assign8 = EDT_C.getText().toString();
            double sub9 = 0;
            String Assign9 = EDT_BES.getText().toString();


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

                Intent intent = getIntent();
                String name = intent.getStringExtra("name");

                databaseReference.child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(name).child("sem1").child("bes").setValue(Assign9);
                        databaseReference.child(name).child("sem1").child("c").setValue(Assign8);
                        databaseReference.child(name).child("sem1").child("chem").setValue(Assign1);
                        databaseReference.child(name).child("sem1").child("phy").setValue(Assign2);
                        databaseReference.child(name).child("sem1").child("mat").setValue(Assign3);
                        databaseReference.child(name).child("sem1").child("eng").setValue(Assign4);

                        databaseReference.child(name).child("sem1").child("c_lab").setValue(Assign5);
                        databaseReference.child(name).child("sem1").child("chem_lab").setValue(Assign6);
                        databaseReference.child(name).child("sem1").child("phy_lab").setValue(Assign7);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
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