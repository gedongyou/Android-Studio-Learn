package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.modelc.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class bannerAdapter extends PagerAdapter {

    private final Context context;
    private final List<View> mView;


    public bannerAdapter(Context context, int[] imgArr) {
        this.context = context;
        mView = new ArrayList();
        for (int i = 0; i < imgArr.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_view, null);
            ImageView img = view.findViewById(R.id.img);
            img.setImageResource(imgArr[i]);
            mView.add(view);

        }


    }

    @Override
    public int getCount() {
        return mView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View view = mView.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView(mView.get(position));
    }
}
