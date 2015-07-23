package com.terrybu.listviewpractice;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    private String[] moons;
    private ListView moonsListView;
    private ArrayAdapter<String> moonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getApplicationContext().getResources();
        moons = res.getStringArray(R.array.moons_array);
        moonsListView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        moonsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moons);
        moonsListView.setAdapter(moonsAdapter);
    }
}
