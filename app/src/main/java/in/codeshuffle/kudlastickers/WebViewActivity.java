package in.codeshuffle.kudlastickers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebViewActivity extends AppCompatActivity {

    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }
}
