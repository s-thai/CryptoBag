package infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Button nButton;
    public static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate Called");

        setContentView(R.layout.activity_main);


        nButton = findViewById(R.id.btnLaunchActivity);

        nButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                launchDetailActivity("Hello from Detail Activity");
            }
        });

    }

    private void launchDetailActivity(String message){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume Called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "onStop Called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause Called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy Called");
    }

}
