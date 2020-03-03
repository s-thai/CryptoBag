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
        mMarketcap = findViewById(R.id.tvMarketcapNameField);
        mVolume = findViewById(R.id.tvVolumeNameField);
        mSearch = findViewById(R.id.ivSearch);

        Intent intent = getIntent();
        String coinSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.i(TAG, "Coin-Symbol = " + coinSymbol);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Coin> coins = Coin.getCoins();

        final Coin coin = Coin.searchCoin(coinSymbol);

        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mValue.setTextKeepState(formatter.format(coin.getValue()));
        mChange1h.setText(coin.getChange1h() + "%");
        mChange24h.setText(coin.getChange24h() + "%");
        mChange7d.setText(coin.getChange7d() + "%");
        mMarketcap.setText(formatter.format(coin.getMarketcap()));
        mVolume.setText(formatter.format(coin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                searchCoin(coin.getName());
            }
        });
    }


}
