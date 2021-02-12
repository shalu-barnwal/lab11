package com.example.lab6;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername, mDate;
    private RadioGroup mRadioGroup,gRadioGroup;
    private CheckBox mCheckBangalore, mCheckChennai, mCheckMumbai, mCheckDelhi;
    private ImageView mImageView;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mSubmit = findViewById(R.id.btnSubmit);
        Button mReset = findViewById(R.id.btnReset);

        mUsername = findViewById(R.id.editTextUsername2);
        mRadioGroup = findViewById(R.id.radioGroup);
        gRadioGroup = findViewById(R.id.gGroup);
        mCheckBangalore = findViewById(R.id.checkBangalore);
        mCheckChennai = findViewById(R.id.checkChennai);
        mCheckMumbai = findViewById(R.id.checkMumbai);
        mCheckDelhi = findViewById(R.id.checkDelhi);
        mImageView = findViewById(R.id.imageView1);
        mDate = findViewById(R.id.date);

        final Calendar calendar = Calendar.getInstance();

        mDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mDate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, year,month,day);
                datePickerDialog.show();

            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mUsername.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter username",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer displayMsg = new StringBuffer();
                displayMsg.append("Username: ");
                displayMsg.append(mUsername.getText()).append("\n");

                int selectedRadio = mRadioGroup.getCheckedRadioButtonId();
                Button ageButton = findViewById(selectedRadio);
                if(selectedRadio == -1){
                    Toast.makeText(MainActivity.this, "Please select one age group",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    displayMsg.append("Age Group: ");
                    displayMsg.append(ageButton.getText()).append("\n");
                }

                int selectedRBtn = gRadioGroup.getCheckedRadioButtonId();
                Button genderButton = findViewById(selectedRBtn);
                if(selectedRadio == -1){
                    Toast.makeText(MainActivity.this, "Please select your gender",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    displayMsg.append("Gender : ");
                    displayMsg.append(genderButton.getText()).append("\n");

                }

                displayMsg.append("Preferred City: ");
                if(mCheckBangalore.isChecked()){
                    displayMsg.append(mCheckBangalore.getText());
                }
                if(mCheckChennai.isChecked()){
                    displayMsg.append(", ").append(mCheckChennai.getText());
                }
                if(mCheckMumbai.isChecked()){
                    displayMsg.append(", ").append(mCheckMumbai.getText());
                }
                if(mCheckDelhi.isChecked()){
                    displayMsg.append(", ").append(mCheckDelhi.getText());
                }

                mImageView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, displayMsg,Toast.LENGTH_SHORT).show();

            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                mUsername.setText("");
                mRadioGroup.clearCheck();
                gRadioGroup.clearCheck();
                mCheckBangalore.setChecked(false);
                mCheckDelhi.setChecked(false);
                mCheckMumbai.setChecked(false);
                mCheckChennai.setChecked(false);
                mImageView.setVisibility(View.INVISIBLE);
            }
        });
    }


}