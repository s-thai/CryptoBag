package infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {
    private TextView nDetailMessage;
    private Button nShowVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        nDetailMessage = findViewById(R.id.tvDetailMessage);
        nDetailMessage.setText(message);

        nShowVideoButton = findViewById(R.id.btnShowVideo);
        nShowVideoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showVideo( "https://www.youtube.com/watch?v=-iIbc-h9ijc");
            }
        });

    }

    private void showVideo(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
