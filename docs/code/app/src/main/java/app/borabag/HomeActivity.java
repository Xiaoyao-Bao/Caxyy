package app.borabag;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{

    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get username from login page
        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.ViewReward);
        textView.setText("Hello, " + message + ". You have earned 580 points!");

        // Perform scan function on button click
        final Button scanButton = findViewById(R.id.btnScan);
        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("tag", "Scan button pressed");
                try {

                    Log.d("test", "redirected!!1");
                    Intent intent = new Intent(String.valueOf(app.borabag.barcode.BarcodeCaptureActivity.class));
                    startActivityForResult(intent, 1);

                    Log.d("test", "redirected!!2");

                } catch (Exception e) {

                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                    startActivity(marketIntent);

                }
            }
        });

        final Button findButton = findViewById(R.id.btnFind);
        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("tag", "Find button pressed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.co.uk/maps"));
                startActivity(intent);
            }
        });

        final Button exploreButton = findViewById(R.id.btnExplore);
        exploreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("tag", "Explore button pressed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://plasticoceans.org"));
                startActivity(intent);
            }


        });

        final FloatingActionButton profileButton = findViewById(R.id.floatingActionButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("tag", "Explore button pressed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://lh3.googleusercontent.com/FK_Q9AIkevM1KyRs2_KUus97ZqkAK0ZPZXGlkPmUJprHzDE8Vn79qT9wfXff-TEyPjwMPBKnCOhnaWQIg7zKrQqBQsP0ZYzH051K9SU9Y_mQedxG6E2GGfVugOoXJfkepCqooOTNcKKRaHCu4cN6USkndi8enAY07W3x1_DqfGKwSaYwJcGxFSVPp_hXnbA0vhjdwbV6Kbeq8qHBeq8FLqgm-xQ8qh5XC9D__JySZHxHwX4vDxVk3xj38h1B8nv-dHD_y8Fi2GJ-pPm2XPYouiYmF34KAYVfbI4Tre6wyoe_Iv3tm0nf0szzQ0UNtAO01xjDX1QrqQMjLVYla9d0qoEZw7jdL-oCAscDCRnh7c6YNjMRu43paAAcbJwKJpNKWUHpbOlGlmUqMCi8A_roRgna4HFML_eQGkiD1HZrdc6XiFabjFfLx--9Bbk0qDrSltAf3ShIrc08UY1d11V9GV9W2dj_inbZDjyNRJ0s4yff8lYalLWymMVWOQlcccRQtlJWWbLLObQuSqK4jP0PL1R7lDtN_9X1SLn4PfPQz7rJaWef9-l34jdhj9UZBs5aoKS95K-muwGV3j9t3o9_J9FsSNPK499tJYU8I80PT0L01aE1UYs8L1WT7KAorJBrPQCBG9_I9bQBKmpJean_hH4LAInviIs=w360-h640-no"));
                startActivity(intent);
            }


        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("test", "redirected!!3");
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("test", "redirected!!4");
        if (requestCode == 0) {
            Log.d("test", "redirected!!5");

            if (resultCode == RESULT_OK) {

                Log.d("test", "redirected!!6");
                String contents = data.getStringExtra("SCAN_RESULT");
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }
}
