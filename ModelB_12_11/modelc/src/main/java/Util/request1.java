package Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import bean.Const;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class request1 {
    private static String baseURL = Const.baseURL;
    private static OkHttpClient client = new OkHttpClient();
    private static MediaType Ctype = MediaType.parse("application/json");
    private static Handler handler = new Handler(Looper.getMainLooper());

    public interface HttpCallback {
        void onSuccess(String result);
    }

    private static void handleError(Context context, Exception e) {
        handler.post(() -> {
            Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
        });
    }

    public static void get(Context context, String url, HttpCallback callback) {
        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        Request request = new Request.Builder()
                .url(baseURL + url)
                .get()
                .header("Authorization", token)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handleError(context, e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    String result = response.body().string();
                    handler.post(() -> callback.onSuccess(result));
                } catch (Exception e) {
                    handleError(context, e);
                }
            }
        });
    }


    public static void post(Context context, String url, String json, HttpCallback callback) {
        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");


        RequestBody body = RequestBody.create(json, Ctype);
        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
        Request request = new Request.Builder()
                .url(baseURL + url)
                .post(body)
                .header("Authorization", token)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handleError(context, e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    String result = response.body().string();
                    handler.post(() -> callback.onSuccess(result));
                } catch (Exception e) {
                    handleError(context, e);
                }

            }
        });
    }
}
