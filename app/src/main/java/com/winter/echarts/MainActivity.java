package com.winter.echarts;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private EChartView echartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        echartView = findViewById(R.id.echartview);
        echartView.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Gson gson = new Gson();
            String geoJson = gson.toJson(GetJsonDataUtil.getJson(getApplicationContext(), "wuhan.json"));
            geoJson = geoJson.substring(1, geoJson.length() - 1);
            echartView.refreshEchartsWithJson(geoJson);
        }
    }
}
