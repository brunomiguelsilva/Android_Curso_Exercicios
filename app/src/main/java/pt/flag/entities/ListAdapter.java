package pt.flag.entities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pt.flag.R;

/**
 * Created by Formando on 02/06/2017.
 */

public class ListAdapter extends ArrayAdapter<AdapterItem> {
    public static final String TAG = "ListAdapter";

    public ListAdapter(Context context, List<AdapterItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "getView() position = " + position);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View rootView = layoutInflater.inflate(R.layout.adapter_item, null);

        TextView rowLabel = (TextView)rootView.findViewById(R.id.adapter_item_row_label);
        TextView valueLabel = (TextView)rootView.findViewById(R.id.adapter_item_value_label);

        AdapterItem item = getItem(position);

        rowLabel.setText(String.valueOf(item.getRow()));
        valueLabel.setText(String.valueOf(item.getValue()));

        return rootView;
    }
}
