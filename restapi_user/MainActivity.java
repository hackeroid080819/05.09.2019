package com.example.a2608_;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);

        // create client
        OkHttpClient client = new OkHttpClient();

        // create a request object
        String url = "https://randomuser.me/api/";
        Request request = new Request.Builder().url(url).build();

        // enqueue - add item to the request queue
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                mTextViewResult.setText(e.getMessage());
            }
            String temp = "";
            // SUCCESS!!!
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    // non graphic commands
                    final String myResponse = response.body().string();

                    JSONObject data = null;

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();

                    WebResult mw = gson.fromJson(myResponse, WebResult.class);

                    Log.d("====", "Done");

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // grahic commands (UI)
                            mTextViewResult.setText("London: " + temp);
                        }
                    });
                }
            }
        });
    }


}
