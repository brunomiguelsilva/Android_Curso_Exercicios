package pt.flag.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pt.flag.R;

/**
 * Created by Silva on 27/05/2017.
 */

public class SecondScreen extends Screen {
    private Button buttonMinus;
    private Button buttonPlus;
    private TextView labelResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        buttonMinus = (Button) findViewById(R.id.second_screen_button_minus);
        buttonPlus = (Button) findViewById(R.id.second_screen_button_plus);
        labelResult = (TextView) findViewById(R.id.second_screen_label_result);

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = labelResult.getText().toString();
                int value = Integer.parseInt(text);
                labelResult.setText(String.valueOf(--value));
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = labelResult.getText().toString();
                int value = Integer.parseInt(text);
                labelResult.setText(String.valueOf(++value));
            }
        });
    }
}
