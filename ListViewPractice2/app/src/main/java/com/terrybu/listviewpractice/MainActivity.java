package com.terrybu.listviewpractice;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.terrybu.listviewpractice.adapters.MoonsAdapter;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    private ListView moonsListView;
    private MoonsAdapter moonsAdapter;

    private List<String> moons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        moons = Arrays.asList(res.getStringArray(R.array.moons_array));
        moonsListView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        moonsAdapter = new MoonsAdapter(moons);
        moonsListView.setAdapter(moonsAdapter);
    }
}
