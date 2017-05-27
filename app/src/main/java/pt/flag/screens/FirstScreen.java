package pt.flag.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pt.flag.R;

/**
 * Created by Formando on 26/05/2017.
 */

public class FirstScreen extends Screen{

    private Button button;
    private TextView label;
    private EditText input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        label = (TextView) findViewById(R.id.first_screen_label);
        button = (Button) findViewById(R.id.first_screen_button);
        input = (EditText) findViewById(R.id.first_screen_input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                showToast(text);
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(FirstScreen.this, text, Toast.LENGTH_SHORT).show();
    }
}
