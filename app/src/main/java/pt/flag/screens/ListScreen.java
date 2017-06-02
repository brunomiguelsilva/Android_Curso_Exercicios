package pt.flag.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.flag.R;
import pt.flag.entities.AdapterItem;
import pt.flag.entities.ListAdapter;

/**
 * Created by Formando on 02/06/2017.
 */

public class ListScreen extends Screen {

    public static final int NUMBER_OF_ELEMENTS = 100000;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen);

        findViews();
        List<AdapterItem> items = createItems();

        ListAdapter adapter = new ListAdapter(this, items);

        listView.setAdapter(adapter);
    }

    private List<AdapterItem> createItems() {
        List<AdapterItem> items = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i <= NUMBER_OF_ELEMENTS; i++) {
            AdapterItem item = new AdapterItem(i, random.nextInt(100000));
            items.add(item);
        }

        return items;
    }

    private void findViews() {
        listView = (ListView)findViewById(R.id.list_screen_list_view);
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
