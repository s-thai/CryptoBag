package infs3634.cryptobag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;
    private Coin mCoin;

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mName = findViewById(R.id.tvName);
        mSymbol = findViewById(R.id.tvSymbol);
        mValue = findViewById(R.id.tvValueNameField);
        mChange1h = findViewById(R.id.tvChange1hNameField);
        mChange24h = findViewById(R.id.tvChange1DayNameField);
        mChange7d = findViewById(R.id.tvChange1WeekNameField);
        mMarketcap = findViewById(R.id.tvMarketcapNameField);
        mVolume = findViewById(R.id.tvVolumeNameField);
        mSearch = findViewById(R.id.ivSearch);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        mCoin = Coin.getCoins().get(position);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        setTitle(mCoin.getName());
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setTextKeepState(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + "%");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + "%");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                searchCoin(mCoin.getName());
            }
        });
    }

    private void searchCoin(String name){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }


}
