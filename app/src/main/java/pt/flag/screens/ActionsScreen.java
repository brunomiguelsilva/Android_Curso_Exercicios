package pt.flag.screens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pt.flag.R;

/**
 * Created by Formando on 31/05/2017.
 */

public class ActionsScreen extends Screen {
    private static final String EDIT_TEXT_VALUE = "EditTextValue";

    private Button buttonOpenActivity_1;
    private Button buttonOpenUrl;
    private Button buttonOpenDialer;
    private EditText editTextOpenActivity;
    private Button buttonOpenActivity_2;
    private Button buttonMakeCall;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actions_screen);

        findViews();
        addListeners();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EDIT_TEXT_VALUE, editTextOpenActivity.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString(EDIT_TEXT_VALUE);
        editTextOpenActivity.setText(value);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findViews()
    {
        buttonOpenActivity_1 = (Button) findViewById(R.id.actions_screen_button_open_activity_1);
        buttonOpenUrl = (Button) findViewById(R.id.actions_screen_button_open_url);
        buttonOpenDialer = (Button) findViewById(R.id.actions_screen_button_open_dialer);
        editTextOpenActivity = (EditText) findViewById(R.id.actions_screen_edit_text_open_activity);
        buttonOpenActivity_2 = (Button) findViewById(R.id.actions_screen_button_open_activity_2);
        buttonMakeCall = (Button) findViewById(R.id.actions_screen_button_make_call);
    }

    private void addListeners(){
        buttonOpenActivity_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionsScreen.this, SecondScreen.class);
                startActivity(intent);
            }
        });

        buttonOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intent);
            }
        });

        buttonOpenDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 911111111));
                startActivity(intent);
            }
        });

        editTextOpenActivity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonOpenActivity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 911111111));
                startActivity(intent);
            }
        });
    }
}
