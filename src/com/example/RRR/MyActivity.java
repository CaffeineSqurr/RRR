package com.example.RRR;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import android.os.Handler;

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
//        rProgress.setVisibility(View.INVISIBLE);
        return;
    }

    private static int p = 0;

    private Handler handle = new Handler();

    private ProgressBar rProgress;

    private void loadBar() {
        rProgress = (ProgressBar) findViewById(R.id.rProgress);
//        rProgress.setVisibility(View.VISIBLE);
        rProgress.setMax(100);
	new Thread(new Runnable() {
		public void run() {
        	p = 0;
        	while (p < 100){
	    		handle.post(new Runnable() {
				public void run() {
            				rProgress.setProgress(p);
				}
	    		});
            		Log.i("RRR Dev", "incrementing progress");

            		try {
				Thread.sleep(1000);	
            		} catch (InterruptedException e) {
                		e.printStackTrace();
            		}
            		p+=10;
        	}
        rProgress.setProgress(p);
	Log.i("RRR Dev", "done incrementing progress");
	}}).start();
//        rProgress.setVisibility(View.INVISIBLE);
        return;
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
        return;
    }


}
