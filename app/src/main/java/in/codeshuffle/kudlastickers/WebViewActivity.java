package in.codeshuffle.kudlastickers;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import in.codeshuffle.kudlastickers.util.Utils;

public class WebViewActivity extends AppCompatActivity {

    public static final String URL = "url";
    private WebView webView;
    private ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);


        //If no internet, show dialog
        Intent launcherIntent = getIntent();
        if (!Utils.isNetworkAvailable(this)) {
            new AlertDialog.Builder(this)
                    .setTitle("No Internet connection")
                    .setMessage("Seems like you are not connected to Internet. This page needs an active Internet connection to load. Please enable Internet and retry!")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("Ok", (dialog, which) -> finish())
                    .setCancelable(false)
                    .create().show();
            return;
        }

        //If Connected to Internet, Show the URL content
        String url = Utils.URL.CONTRIBUTE_URL;
        if (launcherIntent != null) {
            url = launcherIntent.getStringExtra(URL);
            switch (url) {
                case Utils.URL.CONTRIBUTE_URL:
                    setTitle("Contribute Stickers");
                    break;
                case Utils.URL.FEEDBACK_URL:
                    setTitle("Feedback");
                    break;
                case Utils.URL.ABOUT_DEV_URL:
                    setTitle("About Developer");
                    break;
                case Utils.URL.OPEN_SOURCE_LICENSE_URL:
                    setTitle("Licenses");
                    break;
            }
        }

        //Init webview
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 0)
                    progressBar.setVisibility(View.VISIBLE);

                progressBar.setProgress(progress);

                if (progress == 100)
                    progressBar.setVisibility(View.GONE);
            }
        });

        webView.loadUrl(url);
    }
}
