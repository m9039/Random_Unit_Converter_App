package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String[] units = {"kilometres", "metres", "centimetres", "millimetres", "miles", "yards", "feet", "inches"};
    String generatedUnit1;
    String generatedUnit2 = "";
    double convertedValue = 1;
    double valueEntered = 0;
    double convertedValue3dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //As soon as the app starts, the generateUnits method is called
        generateUnits();

        Button btn = findViewById(R.id.btnConvert);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            //Once units have been generate and user has input a number, they click on the button to call convertClicked method
            public void onClick(View v) {
                convertClicked();
            }
        });
    }

    public void generateUnits(){
        //Instantiate random class
        Random random = new Random();

        //Create variables for TextViews from the .xml file so that we can later set values to them
        TextView tvUnit1 = findViewById(R.id.tvUnit1);
        TextView tvUnit2 = findViewById(R.id.tvUnit2);

        //Generates one random integer number in the range of 0-7 because the length of "units" array is 8
        //Calls the string value (unit) according to that number in the array
        //Displays the unit in the textview
        int unitOne = random.nextInt(units.length);
        generatedUnit1 = units[unitOne];
        tvUnit1.setText(generatedUnit1);

        //Create a boolean and while loop to keep randomising new integer if it is equal to the integer number from above
        //If it does not equal, it can stop generating new integer and displays the unit in textview
        boolean generateAgain = true;
        while (generateAgain) {
            int unitTwo = random.nextInt(units.length);
            if (unitTwo != unitOne){
                generatedUnit2 = units[unitTwo];
                generateAgain = false;
            }
        }
        tvUnit2.setText(generatedUnit2);
    }

    //This method is launched after user input has been converted
    public void goToSecondActivity(){
        //Sets the new converted value to 3 decimal places and if it is >0.5 it rounds up
        convertedValue3dp = new BigDecimal(convertedValue).setScale(3, RoundingMode.HALF_UP).doubleValue();
        //Converts Double to String
        String strConvertedValue = String.valueOf(convertedValue3dp);
        String strValueEntered = String.valueOf(valueEntered);

        //Creates a new intent to: Launch SecondActivity class and pass on the variables
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("sendFirst", generatedUnit1);
        intent.putExtra("sendSecond", generatedUnit2);
        intent.putExtra("sendInput", strValueEntered);
        intent.putExtra("sendConverted", strConvertedValue);
        startActivity(intent);
    }

    //convertClicked is called when the convert button is clicked
    public void convertClicked(){
        //EditText allows user to input integer (whole numbers) or double (decimal) data type; not string or char
        //Converts into to a string so that it can later
        EditText userInput = findViewById(R.id.etUserInput);
        String numberInput = userInput.getText().toString().trim();

        //Detect an empty string and set it to "0" to prevent error message
        if (numberInput.equals("")){
            numberInput = "0";
        }

        //Converting String to Double
        valueEntered = Double.parseDouble(numberInput);

        //Converting original input to new generated unit by checking if the unit generated matches the parameters
        //Compute desired value using the corresponding formula
        //Once input is converted, goToSecondActivity method is called
        if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("metres")) {
            convertedValue = valueEntered * 1000;
            goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 100000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 1000000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 1.609;
                goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered * 1094;
                goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered * 3281;
                goToSecondActivity();
            } else if (generatedUnit1.equals("kilometres") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered * 39370;
                goToSecondActivity();

            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 1000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 100;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 1000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 1609;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered * 1.094;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered * 3.281;
                goToSecondActivity();
            } else if (generatedUnit1.equals("metres") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered * 39.37;
                goToSecondActivity();

            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 100000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered / 100;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 10;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 160934;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered / 91.44;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered / 30.48;
                goToSecondActivity();
            } else if (generatedUnit1.equals("centimetres") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered / 2.54;
                goToSecondActivity();

            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 1000000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered / 1000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered / 10;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 1609000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered / 914;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered / 305;
                goToSecondActivity();
            } else if (generatedUnit1.equals("millimetres") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered / 25.4;
                goToSecondActivity();

            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered * 1.609;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered * 1609;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 160934;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 1609000;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered * 1760;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered * 5280;
                goToSecondActivity();
            } else if (generatedUnit1.equals("miles") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered * 63360;
                goToSecondActivity();

            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 1094;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered / 1.094;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 91.44;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 914;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 1760;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered * 3;
                goToSecondActivity();
            } else if (generatedUnit1.equals("yards") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered * 36;
                goToSecondActivity();

            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 3281;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered / 3.281;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 30.48;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 305;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 5280;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("yards")) {
                convertedValue = valueEntered / 3;
                goToSecondActivity();
            } else if (generatedUnit1.equals("feet") && generatedUnit2.equals("inches")) {
                convertedValue = valueEntered * 12;
                goToSecondActivity();

            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("kilometres")) {
                convertedValue = valueEntered / 39370;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("metres")) {
                convertedValue = valueEntered / 39.37;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("centimetres")) {
                convertedValue = valueEntered * 2.54;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("millimetres")) {
                convertedValue = valueEntered * 25.4;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("miles")) {
                convertedValue = valueEntered / 63360;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("yards")){
                convertedValue = valueEntered / 36;
                goToSecondActivity();
            } else if (generatedUnit1.equals("inches") && generatedUnit2.equals("feet")) {
                convertedValue = valueEntered / 12;
                goToSecondActivity();
        }
    }
}



