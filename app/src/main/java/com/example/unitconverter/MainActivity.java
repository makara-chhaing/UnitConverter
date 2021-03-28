package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp_type;
    EditText inputText;
    TextView firstResult, secondResult, thirdResult;
    TextView firstUnit, secondUnit, thirdUnit;
    String inputString, item, firstResultString, secondResultString, thirdResultString;
    double input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_type = findViewById(R.id.spiner_type_id);

        inputText = findViewById(R.id.et_input_id);

        firstResult = findViewById(R.id.first_result_id);
        secondResult = findViewById(R.id.second_result_id);
        thirdResult = findViewById(R.id.third_result_id);
        firstUnit = findViewById(R.id.first_unit_id);
        secondUnit = findViewById(R.id.second_unit_id);
        thirdUnit = findViewById(R.id.third_unit_id);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_units, R.layout.support_simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_type.setAdapter(dataAdapter);

        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputText.getText().clear();
                firstUnit.setText("");
                secondUnit.setText("");
                thirdUnit.setText("");
                firstResult.setText("");
                secondResult.setText("");
                thirdResult.setText("");
                item = sp_type.getItemAtPosition(position).toString();
                if(item.toLowerCase().equals("kilograms")){
                    firstUnit.setText("Gram");
                    secondUnit.setText("Ounce(Oz)");
                    thirdUnit.setText("Pound(lb)");
                }
                if(item.toLowerCase().equals("celsius")){
                    firstUnit.setText("Fahrenheit");
                    secondUnit.setText("Kelvin");
                    thirdUnit.setText("");
                }
                if(item.toLowerCase().equals("metre")){
                    firstUnit.setText("Centimetre");
                    secondUnit.setText("Foot");
                    thirdUnit.setText("Inch");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void CalculateKilograms(View view){
        if (!item.toLowerCase().equals("kilograms")){
            Toast.makeText(MainActivity.this, "Please Choose the correct conversion icon", Toast.LENGTH_LONG).show();
            return;
        }
        inputString = inputText.getText().toString();
        if(inputString.isEmpty()) return;
        input = Double.parseDouble(inputString);
        firstResultString = String.format("%.2f", Kilograms.CalculateGram(input));
        secondResultString = String.format("%.2f", Kilograms.CalculateOunce(input));
        thirdResultString = String.format("%.2f", Kilograms.CalculatePound(input));
        firstResult.setText(firstResultString);
        secondResult.setText(secondResultString);
        thirdResult.setText(thirdResultString);
    }
    public void CalculateCelcius(View view){
        if (!item.toLowerCase().equals("celsius")){
            Toast.makeText(MainActivity.this, "Please Choose the correct conversion icon", Toast.LENGTH_LONG).show();
            return;
        }
        inputString = inputText.getText().toString();
        if(inputString.isEmpty()) return;
        input = Double.parseDouble(inputString);
        firstResultString = String.format("%.2f", Celsius.CalculateFahrenheit(input));
        secondResultString = String.format("%.2f", Celsius.CalculateKelvin(input));
        firstResult.setText(firstResultString);
        secondResult.setText(secondResultString);
        thirdResult.setText("");
    }
    public void CalculateMetre(View view){
        if (!item.toLowerCase().equals("metre")){
            Toast.makeText(MainActivity.this, "Please Choose the correct conversion icon", Toast.LENGTH_LONG).show();
            return;
        }
        inputString = inputText.getText().toString();
        if(inputString.isEmpty()) return;
        input = Double.parseDouble(inputString);
        firstResultString = String.format("%.2f", Metre.CalculateCentimetre(input));
        secondResultString = String.format("%.2f", Metre.CalcualteFoot(input));
        thirdResultString = String.format("%.2f", Metre.CalculateInch(input));
        firstResult.setText(firstResultString);
        secondResult.setText(secondResultString);
        thirdResult.setText(thirdResultString);
    }

}