package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter08.R;

import java.util.List;

import bean.Planet;

public class PlanetGridAdapter extends BaseAdapter {

    Context mContext;
    List<Planet> mPlanetList;

    public PlanetGridAdapter(Context mContext, List<Planet> mPlanetList) {
        this.mContext = mContext;
        this.mPlanetList = mPlanetList;
    }

    @Override
    public int getCount() {
        return mPlanetList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPlanetList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_grid, null);
        TextView gv_name = view1.findViewById(R.id.gv_name);
        TextView gv_desc = view1.findViewById(R.id.gv_desc);
        ImageView gv_icon = view1.findViewById(R.id.gv_icon);


        gv_name.setText(mPlanetList.get(i).name);
        gv_desc.setText(mPlanetList.get(i).desc);
        gv_icon.setImageResource(mPlanetList.get(i).image);

        return view1;
    }
}
