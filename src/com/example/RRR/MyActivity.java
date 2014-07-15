package com.example.RRR;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initBar();
        initButton();

    }

    private void initBar() {
        ProgressBar rProgress;
        rProgress = (ProgressBar) findViewById(R.id.rProgress);
        rProgress.setVisibility(View.INVISIBLE);
    }

    private void loadBar() {
        ProgressBar rProgress;
        rProgress = (ProgressBar) findViewById(R.id.rProgress);
        rProgress.setVisibility(View.VISIBLE);
        rProgress.setMax(100);
        int p = 0;
        while (p < 100){
            rProgress.setProgress(p);
            Log.i("RRR Dev", "incrementing progress");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p+=10;
        }
        rProgress.setVisibility(View.INVISIBLE);
    }

    private void initButton() {
        Button messageButton;
        messageButton = (Button) findViewById(R.id.rbutton);


        messageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("RRR Dev", "Button Click event");
                loadBar();
                Toast.makeText(
                        MyActivity.this,
                        "Refreshing",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }


}
