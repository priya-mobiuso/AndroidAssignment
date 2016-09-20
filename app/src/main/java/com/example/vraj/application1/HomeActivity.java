package com.example.vraj.application1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class HomeActivity extends Activity implements View.OnClickListener {
    Button mbtn_start, mbtn_stop, mbtn_exit;
    int c=0;
    final Handler mHandler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mbtn_start = (Button)findViewById(R.id.btn_start);
        mbtn_stop = (Button)findViewById(R.id.btn_stop);
        mbtn_exit = (Button)findViewById(R.id.btn_exit);

        mbtn_start.setOnClickListener(this);
        mbtn_stop.setOnClickListener(this);
        mbtn_exit.setOnClickListener(this);

    }


    final Runnable runnable = new Runnable() {

        public void run() {
            c++;
            Toast.makeText(getApplicationContext(), "notification" + c, Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(runnable, 5000);

        }
    };


    public void onClick(View v) {

        final Button btn=(Button)v;

        if (btn == mbtn_start) {
            runnable.run();
        }


        if (btn == mbtn_stop) {
            mHandler.removeCallbacks(runnable);
        }

        if (btn == mbtn_exit) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.dialogtitle);
            alertDialogBuilder.setMessage(R.string.dialogmessage);
            alertDialogBuilder.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });

            alertDialogBuilder.setNegativeButton(R.string.cancel,
                    new DialogInterface.OnClickListener() {


                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}






