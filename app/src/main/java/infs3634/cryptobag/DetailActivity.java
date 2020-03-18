package infs3634.cryptobag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import java.text.NumberFormat;
import java.util.ArrayList;

import static infs3634.cryptobag.Coin.searchCoin;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new DetailFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.detailContainerScroll, fragment).commit();

    }

}