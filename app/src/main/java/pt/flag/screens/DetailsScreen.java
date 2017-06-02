package pt.flag.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import pt.flag.R;

/**
 * Created by Silva on 02/06/2017.
 */

public class DetailsScreen extends Screen {
    public static final String DETAILS_TEXT = "EditTextValue";

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_screen);

        textView = (TextView) findViewById(R.id.details_screen_label);

        Intent intent = getIntent() ;
        String textReceived = intent.getStringExtra(DETAILS_TEXT);
        textView.setText(textReceived) ;
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
}
