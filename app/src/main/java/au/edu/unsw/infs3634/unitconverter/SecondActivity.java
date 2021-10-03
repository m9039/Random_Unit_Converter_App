package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Bundle bundle = getIntent().getExtras();
//        autoUnits = bundle.getStringArrayList("list");
//
        Intent intentFirst = getIntent();
        String unit1 = intentFirst.getStringExtra("sendFirst");
        TextView autoFirstUnit = findViewById(R.id.tvUnit1);
        autoFirstUnit.setText(unit1);

        Intent intentSecond = getIntent();
        String unit2 = intentSecond.getStringExtra("sendSecond");
        TextView autoSecondUnit = findViewById(R.id.tvUnit2);
        autoSecondUnit.setText(unit2);

        Intent intentInput = getIntent();
        String input = intentInput.getStringExtra("sendInput");
        TextView numberInputted = findViewById(R.id.tvUserInput);
        numberInputted.setText(input);

        Intent intentConverted = getIntent();
        String converted = intentConverted.getStringExtra("sendConverted");
        TextView numberConverted = findViewById(R.id.tvConvertedInput);
        numberConverted.setText(converted);



//        Bundle bundle = getIntent().getExtras();
//        String transferConverted = bundle.getStringArrayList("converted");
    }
}