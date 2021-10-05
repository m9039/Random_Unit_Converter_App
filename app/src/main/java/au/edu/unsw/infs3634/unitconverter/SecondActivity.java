package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView autoFirstUnit = findViewById(R.id.tvUnit1);
        TextView autoSecondUnit = findViewById(R.id.tvUnit2);
        TextView numberInputted = findViewById(R.id.tvUserInput);
        TextView numberConverted = findViewById(R.id.tvConvertedInput);

        Intent intent = getIntent();
        String firstUnit = intent.getStringExtra("sendFirst");
        autoFirstUnit.setText(firstUnit);

        String secondUnit = intent.getStringExtra("sendSecond");
        autoSecondUnit.setText(secondUnit);

        String numberInput = intent.getStringExtra("sendInput");
        numberInputted.setText(numberInput);

        String convertedValue = intent.getStringExtra("sendConverted");
        numberConverted.setText(convertedValue);

        Button restartButton = findViewById(R.id.btnRestart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }
}