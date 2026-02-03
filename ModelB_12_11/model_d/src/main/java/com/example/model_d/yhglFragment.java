package com.example.model_d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import Adapter.yhgl_Adapter;
import Util.Utils;
import Util.request;
import bean.users;

public class yhglFragment extends Fragment {


    private List<users> userList;
    private int menuWidth;
    private int openedPosition = -1;
    private yhgl_Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
uu
        View view = inflater.inflate(R.layout.fragment_yhgl, container, false);
        menuWidth = Utils.dp2px(getContext(), 200);

        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        request.get(getContext(), "/users", result -> {
            Gson gson = new Gson();
            userList = gson.fromJson(result, new TypeToken<List<users>>() {
            }.getType());

            Toast.makeText(getContext(), userList.get(1).getRealName(), Toast.LENGTH_SHORT).show();
            adapter = new yhgl_Adapter(getContext(), userList);
            recyclerView.setAdapter(adapter);


            ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

                @Override
                public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {

                }
            };
            new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
        });


        return view;
    }
}