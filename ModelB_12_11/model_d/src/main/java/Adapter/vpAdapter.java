package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.model_d.R;
import com.example.model_d.VideoActivity;
import com.example.model_d.imageViewActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class vpAdapter extends PagerAdapter {
    private final Context context;
    private final String[] tabArr;
    private final List<int[]> imgList;
    private final List<String[]> nameList;
    private final List<int[]> mediaList;
    private int BarPosition = 1;


    List<View> mView = new ArrayList<>();

    public vpAdapter(Context context, String[] tabArr, List<int[]> imgList, List<String[]> nameList, List<int[]> mediaList) {
        this.context = context;
        this.imgList = imgList;
        this.nameList = nameList;
        this.tabArr = tabArr;
        this.mediaList = mediaList;

        for (int i = 0; i < tabArr.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.wzsp_fag, null);

            int[] imgArr = imgList.get(i);
            String[] nameArr = nameList.get(i);
            int[] ResId = mediaList.get(i);


            ImageView img1 = view.findViewById(R.id.img1);
            ImageView img2 = view.findViewById(R.id.img2);
            ImageView img3 = view.findViewById(R.id.img3);
            ImageView img4 = view.findViewById(R.id.img4);
            img1.setImageResource(imgArr[0]);
            img2.setImageResource(imgArr[1]);
            img3.setImageResource(imgArr[2]);
            img4.setImageResource(imgArr[3]);

            TextView tv1 = view.findViewById(R.id.name1);
            TextView tv2 = view.findViewById(R.id.name2);
            TextView tv3 = view.findViewById(R.id.name3);
            TextView tv4 = view.findViewById(R.id.name4);
            tv1.setText(nameArr[0]);
            tv2.setText(nameArr[1]);
            tv3.setText(nameArr[2]);
            tv4.setText(nameArr[3]);


            img1.setOnClickListener(v -> {
                Intent intent;
                if (tv1.getText().toString().contains("照片")) {
                    intent = new Intent(context, imageViewActivity.class);
                } else {
                    intent = new Intent(context, VideoActivity.class);
                }
                intent.putExtra("ResID", ResId[0]);
                context.startActivity(intent);
            });

            img2.setOnClickListener(v -> {
                Intent intent;
                if (tv2.getText().toString().contains("照片")) {
                    intent = new Intent(context, imageViewActivity.class);
                } else {
                    intent = new Intent(context, VideoActivity.class);
                }
                intent.putExtra("ResID", ResId[1]);
                context.startActivity(intent);

            });

            img3.setOnClickListener(v -> {
                Intent intent;
                if (tv3.getText().toString().contains("照片")) {
                    intent = new Intent(context, imageViewActivity.class);
                } else {
                    intent = new Intent(context, VideoActivity.class);
                }
                intent.putExtra("ResID", ResId[2]);
                context.startActivity(intent);

            });

            img4.setOnClickListener(v -> {
                Intent intent;
                if (tv4.getText().toString().contains("照片")) {
                    intent = new Intent(context, imageViewActivity.class);
                } else {
                    intent = new Intent(context, VideoActivity.class);
                }
                intent.putExtra("ResID", ResId[3]);
                context.startActivity(intent);

            });

            mView.add(view);
        }


    }

    @Override
    public int getCount() {
        return tabArr.length;
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

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabArr[position];
    }


}
