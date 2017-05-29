package pt.flag.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pt.flag.R;

/**
 * Created by Formando on 29/05/2017.
 */

public class LayoutScreen extends Screen {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_screen);
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
