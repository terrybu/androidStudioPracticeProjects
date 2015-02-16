package com.terrybu.android.handlerpractice1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {

    ProgressBar progressBar;
    Thread thread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This app demonstrates how a background thread (MyThread) communicates back to the main thread

        progressBar = (ProgressBar) findViewById(R.id.progressBarRight);
        thread = new Thread(new MyThread()); //you pass a Runnable object to Thread constructor to start that thread
        thread.start();
        handler = new Handler(){
            //now we have a handler associated with this MainActivity message queue
            //this handler can both GET incoming messages and SEND messages
            //we get here and then send down in MyTHread run()
            @Override
            public void handleMessage(Message msg) {
                this.obtainMessage();
                progressBar.setProgress(msg.arg1);
            }
        };
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i=0; i < 100; i++) {
                Message message = Message.obtain(); //gets a Message object from the Messages pool,
                //you do this for memory saving purposes instead of calling message constructor - this is the way to do it
                message.arg1 = i;
                handler.sendMessage(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
