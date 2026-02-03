package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.model_d.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import bean.users;


public class yhgl_Adapter extends RecyclerView.Adapter<yhgl_Adapter.UserViewHolder> {

    private final Context context;
    private final List<users> userList;

    public yhgl_Adapter(Context context, List<users> userList) {
        this.context = context;
        this.userList = userList;
    }


    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull UserViewHolder holder, int position) {
        users user = userList.get(position);
        holder.realName.setText(user.getRealName());
        holder.userName.setText(user.getUsername());
        holder.phone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public View item_content;
        TextView realName, userName, phone;

        public UserViewHolder(@NotNull View itemView) {
            super(itemView);
            realName = itemView.findViewById(R.id.realName);
            userName = itemView.findViewById(R.id.userName);
            phone = itemView.findViewById(R.id.phone);
            item_content = itemView.findViewById(R.id.content_layout);
        }
    }
}
