package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static String[] unitsGenerated;
    String[] units = {"kilometres", "metres", "centimetres", "millimetres", "miles", "yards", "feet", "inches"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnConvert);
        View view = new View(this);
        generateUnits();

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                convertInput(units);
            }
        });
    }

    public void generateUnits(){


        Random random = new Random();
        Vector<String> alreadyUsed = new Vector<String>();

        int[] textViews = new int[2];                                       //giving number values to each textview
        textViews[0] = R.id.tvUnit1;
        textViews[1] = R.id.tvUnit2;

        for(int v : textViews){                                             //for each textview listed in line 26-27
            TextView tv = (TextView)findViewById(v);                   //declaring textview
            String nextString;
            do {
                nextString = units[random.nextInt(units.length)];           //generates a random unit from the array above
            } while (alreadyUsed.contains(nextString));                     //this loops generates another unit if it has already been used
            alreadyUsed.add(nextString);                                    //it adds the used unit to a list so that it wont pick it again
            tv.setText(nextString);                                         //displays text in textview
        }

        TextView unit1 = (TextView) findViewById(R.id.tvUnit1);                   //checking the value of tvUnit1
        String firstUnit = unit1.getText().toString();
        Log.d(TAG, "unit1 is " + firstUnit);

        TextView unit2 = findViewById(R.id.tvUnit2);                   //checking the value of tvUnit2
        String secondUnit = unit2.getText().toString();
        Log.d(TAG, "unit2 is " + secondUnit);

//        Intent intent = new Intent();                                   //use this to transfer data to second activity
//            String fUnit = secondUnit;
//            intent.putExtra("fUnit", fUnit);
//
//            String sUnit = secondUnit;
//            intent.putExtra("sUnit", sUnit);
//        startActivity(intent);
        unitsGenerated = new String[2];
        unitsGenerated[0] = firstUnit;
        unitsGenerated[1] = secondUnit;
//        return unitsGenerated;
        convertInput(units);

        Intent intentUnit1 = new Intent(MainActivity.this, SecondActivity.class);
        String sendUnit1 = firstUnit;
        intentUnit1.putExtra("sendFirst", sendUnit1);
        startActivity(intentUnit1);

        Intent intentUnit2 = new Intent(MainActivity.this, SecondActivity.class);
        String sendUnit2 = secondUnit;
        intentUnit2.putExtra("sendSecond", sendUnit2);
        startActivity(intentUnit2);
    }

    public void convertInput(String[] unitsGenerated){
//        String[] unitsGenerated = generateUnits(view);
        String x = unitsGenerated[0];                                   //add breakpoint for debugging
//        String y = unitsGenerated[1];                                   //add breakpoint for debugging


        EditText userInput = findViewById(R.id.etUserInput);
        String numberInput = userInput.getText().toString();

        Intent intentUserInput = new Intent(MainActivity.this, SecondActivity.class);
        String sendInput = numberInput;
        intentUserInput.putExtra("sendInput", sendInput);
        startActivity(intentUserInput);

        //converting string to double
        double valueEntered = Double.parseDouble(numberInput);
        TextView converted = findViewById(R.id.tvConverted);

        //converting entered number to desired unit
        if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "metres") {
            double convertedValue = valueEntered * 1000;
            converted.setText(String.valueOf((double) convertedValue));
                Intent intentConverted = new Intent(MainActivity.this, SecondActivity.class);
                Double numberConverted = convertedValue;
                intentConverted.putExtra("sendConverted", numberConverted);
                startActivity(intentConverted);
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 100000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 1000000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1.609;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered * 1094;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 3281;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 39370;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 1000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 100;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 1000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1609;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered * 1.094;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 3.281;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 39.37;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 100000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 100;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 10;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 160934;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 91.44;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered / 30.48;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered / 2.54;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 1000000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 1000;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered / 10;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1.609e+6;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 914;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered / 305;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered / 25.4;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered * 1.609;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered * 1609;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 160934;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 1.609e+6;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered * 1760;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 5280;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "miles" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 63360;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 1094;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 1.094;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 91.44;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 914;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1760;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 3;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "yards" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 36;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 3281;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 3.281;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 30.48;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 305;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 5280;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 3;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "feet" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 12;
                converted.setText(String.valueOf((double) convertedValue));

            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 39370;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 39.37;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 2.54;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 25.4;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 63360;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 36;
                converted.setText(String.valueOf((double) convertedValue));
            } else if (unitsGenerated[0] == "inches" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered / 12;
                converted.setText(String.valueOf((double) convertedValue));

            }else {
            converted.setText("Unable to convert :(");
        }

//        Intent intentConverted = new Intent(MainActivity.this, SecondActivity.class);
//        Double numberConverted = convertedValue;
//        intentConverted.putExtra("sendConverted", numberConverted);
//        startActivity(intentConverted);



    }
}



