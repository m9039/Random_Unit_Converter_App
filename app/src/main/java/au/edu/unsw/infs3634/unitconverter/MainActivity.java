package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static String[] unitsGenerated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateUnits(View view);
        convertInput();
    }

    public static String[] generateUnits(View view){
        String[] units = {"kilometres", "metres", "centimetres", "millimetres", "miles", "yards", "feet", "inches"};

        Random random = new Random();
        Vector<String> alreadyUsed = new Vector<String>();

        int[] textViews = new int[2];                                   //giving number values to each textview
        textViews[0] = R.id.tvUnit1;
        textViews[1] = R.id.tvUnit2;

        for(int v : textViews){                                         //for each textview listed in line 26-27
            TextView tv = (TextView)view.findViewById(v);               //declaring textview
            String nextString;
            do {
                nextString = units[random.nextInt(units.length)];       //generates a random unit from the array above
            } while (alreadyUsed.contains(nextString));                 //this loops generates another unit if it has already been used
            alreadyUsed.add(nextString);                                //it adds the used unit to a list so that it wont pick it again
            tv.setText(nextString);                                     //displays text in textview
        }

        TextView unit1 = view.findViewById(R.id.tvUnit1);                    //checking the value of tvUnit1
        String firstUnit = unit1.getText().toString();
        Log.d(TAG, "unit1 is " + firstUnit);

        TextView unit2 = view.findViewById(R.id.tvUnit2);                    //checking the value of tvUnit2
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
        return unitsGenerated;
        
    }

    public static void convertInput(View view){
        String[] unitsGenerated = generateUnits(View view)
        String x = unitsGenerated[0];                                   //add breakpoint for debugging
//        String y = unitsGenerated[1];                                   //add breakpoint for debugging


        EditText userInput = view.findViewById(R.id.etUserInput);
        String numberInput = userInput.getText().toString();

        //converting string to double
        double valueEntered = Double.parseDouble(numberInput);

        TextView converted = view.findViewById(R.id.tvConverted);
        //converting entered number to desired unit
        if (unitsGenerated[0] == "kilometres" || unitsGenerated[0] == "metres") {
            double convertedValue = valueEntered * 1000;
            converted.setText((double) convertedValue);
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 100000;
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 1000000;
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1.609;
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered * 1094;
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 3281;
            } else if (unitsGenerated[0] == "kilometres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 39370;

            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 1000;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered * 100;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 1000;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1609;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered * 1.094;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered * 3.281;
            } else if (unitsGenerated[0] == "metres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered * 39.37;

            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 100000;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 100;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "millimetres") {
                double convertedValue = valueEntered * 10;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 160934;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 91.44;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered / 30.48;
            } else if (unitsGenerated[0] == "centimetres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered / 2.54;

            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "kilometres") {
                double convertedValue = valueEntered / 1000000;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "metres") {
                double convertedValue = valueEntered / 1000;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "centimetres") {
                double convertedValue = valueEntered / 10;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "miles") {
                double convertedValue = valueEntered / 1.609e+6;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "yards") {
                double convertedValue = valueEntered / 914;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "feet") {
                double convertedValue = valueEntered / 305;
            } else if (unitsGenerated[0] == "millimetres" || unitsGenerated[1] == "inches") {
                double convertedValue = valueEntered / 25.4;

            }else {
            converted.setText("Unable to convert :(");
        }

        }






//        if (unitsGenerated[0] == "kilometres" || unitsGenerated[0] == "metres");
//        double convertedValue = valueEntered * 1000;
//            else if (unitsGenerated[0] == "kilometres" || unitsGenerated[0] == "centimetres");
//        double convertedValue = valueEntered * 100000;

    }
}


