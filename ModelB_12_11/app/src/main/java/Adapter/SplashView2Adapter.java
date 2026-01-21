package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modelb_12_11.R;

public class SplashView2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final int[] imgArr;
    private final String[] contentArr;

    public SplashView2Adapter(Context context, int[] imgArr, String[] contentArr) {
        this.context = context;
        this.imgArr = imgArr;
        this.contentArr = contentArr;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_splash_view2, parent, false);

        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView sp_img = holder.itemView.findViewById(R.id.sp_img);
        TextView sp_name = holder.itemView.findViewById(R.id.sp_name);
        Button go_btn = holder.itemView.findViewById(R.id.go_btn);

        sp_img.setImageResource(imgArr[position]);
        sp_name.setText(contentArr[position]);

        if (position == imgArr.length - 1) {
            go_btn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return imgArr.length;
    }
}