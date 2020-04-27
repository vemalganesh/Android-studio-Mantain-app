package com.example.maintainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

        EditText etModel,etDistance,etDateTime,etTotalPrice,etPartsChanged,etRepairShop;
        Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etModel = findViewById(R.id.et_model);
        etDateTime = findViewById(R.id.et_DateTime);
        etDistance = findViewById(R.id.et_distance);
        etTotalPrice = findViewById(R.id.et_price);
        etPartsChanged = findViewById(R.id.et_parts);
        etRepairShop = findViewById(R.id.et_repaired);
        btSubmit = findViewById(R.id.bt_submit);

        final AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation( this,R.id.et_model, RegexTemplate.NOT_EMPTY, R.string.invalid_model);
        awesomeValidation.addValidation( this,R.id.et_DateTime, RegexTemplate.NOT_EMPTY, R.string.invalid_DateTime_empty);
        awesomeValidation.addValidation( this,R.id.et_distance, RegexTemplate.NOT_EMPTY, R.string.invalid_distance_empty);
        awesomeValidation.addValidation( this,R.id.et_price, RegexTemplate.NOT_EMPTY, R.string.invalid_price_empty);
        awesomeValidation.addValidation( this,R.id.et_repaired, RegexTemplate.NOT_EMPTY, R.string.invalid_repairShop_empty);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext()
                    ,"Form Validate Successfully...", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Validation Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
