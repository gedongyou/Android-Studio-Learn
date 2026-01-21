package Util;

import android.app.ProgressDialog;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class request {
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


    private static ProgressDialog show(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("加载中...");
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }

    public static void get(Context context, String url, HttpCallback callback) {
        ProgressDialog dialog = show(context);
        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
        Request request = new Request.Builder()
                .url(baseURL + url)
                .get()
                .header("Authorization", token)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handleError(context, e);
                dialog.dismiss();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    String result = response.body().string();
                    handler.post(() -> callback.onSuccess(result));
                    dialog.dismiss();
                } catch (Exception e) {
                    handleError(context, e);
                    dialog.dismiss();
                }
            }
        });
    }


    public static void post(Context context, String url, String json, HttpCallback callback) {
        RequestBody body = RequestBody.create(json, Ctype);
        ProgressDialog dialog = show(context);
        Request request = new Request.Builder()
                .url(baseURL + url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handleError(context, e);
                dialog.dismiss();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    String result = response.body().string();
                    handler.post(() -> callback.onSuccess(result));
                    dialog.dismiss();
                } catch (Exception e) {
                    handleError(context, e);
                    dialog.dismiss();
                }

            }
        });
    }
}
