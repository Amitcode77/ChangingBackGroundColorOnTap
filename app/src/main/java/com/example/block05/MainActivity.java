package com.example.block05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
       final SharedPreferences.Editor editor = preferences.edit();

        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
         if (preferences.contains(("colorId")))
             layout.setBackgroundColor(preferences.getInt("colorId",0));
        RadioGroup radioGroupColors = (RadioGroup) findViewById(R.id.radioGroupColors);
        radioGroupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int ColorCode = 0;
                switch (checkedId) {
                    case R.id.radioButtonBlue:
                        ColorCode = (Color.BLUE);
                        break;
                    case R.id.radioButtonMagenta:
                        ColorCode= (Color.MAGENTA);
                        break;
                    case R.id.radioButtonYellow:
                        ColorCode= (Color.YELLOW);
                        break;
                }
                    layout.setBackgroundColor(ColorCode);
                    editor.putInt("ColorId",ColorCode);
                    editor.commit();
            }
        });

    }
}
