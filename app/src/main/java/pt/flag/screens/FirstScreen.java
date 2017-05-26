package pt.flag.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pt.flag.R;

/**
 * Created by Formando on 26/05/2017.
 */

public class FirstScreen extends Screen{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen );
    }
}
