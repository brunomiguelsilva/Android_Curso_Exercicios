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
    private static final String LABEL_VALUE = "LabelValue";
    private static final int MAX_VALUE = 10;
    private static final int MIN_VALUE = 0;

    private Button buttonMinus;
    private Button buttonPlus;
    private TextView labelResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        findViews();
        addListeners();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(LABEL_VALUE, labelResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString(LABEL_VALUE);   labelResult.setText(value);
    }

    private void findViews()
    {
        buttonMinus = (Button) findViewById(R.id.second_screen_button_minus);
        buttonPlus = (Button) findViewById(R.id.second_screen_button_plus);
        labelResult = (TextView) findViewById(R.id.second_screen_label_result);
    }

    private void addListeners(){
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = labelResult.getText().toString();
                int value = Integer.parseInt(text);
                //buttonMinus.setEnabled(value = MIN_VALUE);
                //buttonPlus.setEnabled(true);
                labelResult.setText(String.valueOf(--value));
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://slbenfica.pt"));
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = labelResult.getText().toString();
                int value = Integer.parseInt(text);
                //buttonPlus.setEnabled(value <= MAX_VALUE);
                //buttonMinus.setEnabled(true);
                labelResult.setText(String.valueOf(++value));
            }
        });
    }
}
