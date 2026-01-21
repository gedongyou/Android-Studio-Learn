package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.modelc.R;

import java.util.List;

import bean.xl_data;

public class ListViewAdapter extends BaseAdapter {
    private final Context context;
    private final List<xl_data> rows;

    public ListViewAdapter(Context context, List<xl_data> rows) {
        this.context = context;
        this.rows = rows;
    }

    @Override
    public int getCount() {
        return rows.size();
    }

    @Override
    public Object getItem(int position) {
        return rows.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rows.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        TextView startTime = view.findViewById(R.id.startTime);
        TextView endTime = view.findViewById(R.id.endTime);
        TextView name = view.findViewById(R.id.name);
        TextView price = view.findViewById(R.id.price);

        startTime.setText(rows.get(position).getStartTime());
        endTime.setText(rows.get(position).getEndTime());
        name.setText(rows.get(position).getName());
        price.setText("￥" + rows.get(position).getPrice());
        return view;
    }
}
