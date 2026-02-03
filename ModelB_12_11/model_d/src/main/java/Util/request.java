package Util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import bean.Const;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class request {
    private static String BaseURL = Const.BaseURL;
    private static OkHttpClient client = new OkHttpClient();
    private static Handler handler = new Handler(Looper.getMainLooper());

    public interface HttpCallback {
        void onSuccess(String result);
    }

    private static void handleError(Context context, Exception e) {
        handler.post(() -> {
            Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
            Log.d("fuck", e.toString());
        });
    }

    public static void get(Context context, String url, HttpCallback callback) {
        Log.d("fuck", BaseURL + url);
        Request request = new Request.Builder()
                .url(BaseURL + url)
                .get()
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
