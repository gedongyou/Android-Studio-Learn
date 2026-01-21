package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bean.GoodsInfo;

public class ImagePagerAdapter extends PagerAdapter {
    private final Context mContext;
    private final ArrayList<GoodsInfo> mGoodsList;
    List<ImageView> mImageList = new ArrayList<>();

    public ImagePagerAdapter(Context mContext, ArrayList<GoodsInfo> mGoodsList) {
        this.mContext = mContext;
        this.mGoodsList = mGoodsList;
        for (GoodsInfo info : mGoodsList) {
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            view.setImageResource(info.pic);
            mImageList.add(view);
        }
    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView view = mImageList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView view = mImageList.get(position);
        container.removeView(view);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }
}
