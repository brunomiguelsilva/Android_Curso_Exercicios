package pt.flag.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.flag.R;

/**
 * Created by Formando on 31/05/2017.
 */

public class ActionsScreen extends Screen {
    private static final String EDIT_TEXT_VALUE = "EditTextValue";
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0x1;

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

        String temp = editTextOpenActivity.getText().toString();
        if (temp.isEmpty())
            buttonOpenActivity_2.setEnabled(false);
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

    private void findViews() {
        buttonOpenActivity_1 = (Button) findViewById(R.id.actions_screen_button_open_activity_1);
        buttonOpenUrl = (Button) findViewById(R.id.actions_screen_button_open_url);
        buttonOpenDialer = (Button) findViewById(R.id.actions_screen_button_open_dialer);
        editTextOpenActivity = (EditText) findViewById(R.id.actions_screen_edit_text_open_activity);
        buttonOpenActivity_2 = (Button) findViewById(R.id.actions_screen_button_open_activity_2);
        buttonMakeCall = (Button) findViewById(R.id.actions_screen_button_make_call);
    }


    private void addListeners() {
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
                String temp = editTextOpenActivity.getText().toString();
                if (temp.isEmpty())
                    buttonOpenActivity_2.setEnabled(false);
                else
                    buttonOpenActivity_2.setEnabled(true);
            }
        });

        buttonOpenActivity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionsScreen.this, DetailsScreen.class);
                String textToSend = editTextOpenActivity.getText().toString();
                intent.putExtra(DetailsScreen.DETAILS_TEXT, textToSend);
                startActivity(intent);
            }
        });

        buttonMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 911111111));

                if (ContextCompat.checkSelfPermission(ActionsScreen.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {

                    ActivityCompat.requestPermissions(ActionsScreen.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);

                    // MY_PERMISSIONS_REQUEST_CALL_PHONE is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
                else
                {
                    //You already have permission
                    try
                    {
                        startActivity(intent);
                    }
                    catch (SecurityException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the phone call
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 911111111));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
