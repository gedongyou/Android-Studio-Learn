package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter08.R;

import java.util.List;

import bean.Planet;

public class PlanetListWithButtonAdapter extends BaseAdapter {
    private Context mContext;
    private List<Planet> mPlaneList;

    public PlanetListWithButtonAdapter(Context mContext, List<Planet> mPlanet) {
        this.mContext = mContext;
        this.mPlaneList = mPlanet;
    }

    @Override
    public int getCount() {
        return mPlaneList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPlaneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_list_with_button, null);
        ImageView icon = view1.findViewById(R.id.icon);
        TextView tv_name = view1.findViewById(R.id.name);
        TextView tv_desc = view1.findViewById(R.id.desc);
        Button btn_planet = view1.findViewById(R.id.btn_click);


        Planet planet = mPlaneList.get(i);
        icon.setImageResource(planet.image);
        tv_name.setText(planet.name);
        tv_desc.setText(planet.desc);
        btn_planet.setOnClickListener(view2 -> {
            Toast.makeText(mContext, "你点击了" + planet.name, Toast.LENGTH_SHORT).show();
        });
        return view1;
    }


}
