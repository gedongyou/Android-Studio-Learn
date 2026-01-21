package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.modelb_12_11.LoginActivity;
import com.example.modelb_12_11.R;

import java.util.ArrayList;
import java.util.List;

public class SplashViewAdapter extends PagerAdapter implements View.OnClickListener {

    private final List<View> mView;
    private final Context context;

    public SplashViewAdapter(Context context, int[] imgArr, String[] contentArr) {
        this.context = context;
        mView = new ArrayList<>();
        for (int i = 0; i < imgArr.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_splash_view, null);
            ImageView sp_img = view.findViewById(R.id.sp_img);
            TextView sp_name = view.findViewById(R.id.sp_name);
            RadioGroup sp_radio = view.findViewById(R.id.sp_radio);
            Button go_btn = view.findViewById(R.id.go_btn);
            go_btn.setOnClickListener(this);

            sp_img.setImageResource(imgArr[i]);
            sp_name.setText(contentArr[i]);


            if (i == imgArr.length - 1) {
                go_btn.setVisibility(View.VISIBLE);
            }
            mView.add(view);
        }

    }

    @Override
    public int getCount() {
        return mView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mView.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mView.get(position));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
