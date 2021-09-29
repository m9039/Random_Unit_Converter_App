package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateUnits();
    }

    public void generateUnits(){
        String[] units = {"kilometres", "metres", "centimetres", "millimetres", "miles", "yards", "feet", "inches"};

        Random random = new Random();

        int[] textViews = new int[2];
        textViews[0] = R.id.tvUnit1;
        textViews[1] = R.id.tvUnit2;

        Vector<String> alreadyUsed = new Vector<String>();

        for(int v : textViews){
            TextView tv = (TextView)findViewById(v);
            String nextString;
            do {
                nextString = units[random.nextInt(units.length)];
            } while (alreadyUsed.contains(nextString));
            alreadyUsed.add(nextString);
            tv.setText(nextString);
        }
    }
}


