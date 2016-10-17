package com.example.jianjianhong.imagescaledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mainAct_list);
        ImageAdapter adapter = new ImageAdapter(this, getData());
        listView.setAdapter(adapter);

    }

    public List<Integer> getData() {
        List<Integer> imageIds = new ArrayList<>();
        imageIds.add(R.drawable.dog1);
        imageIds.add(R.drawable.dog2);
        imageIds.add(R.drawable.dog3);
        imageIds.add(R.drawable.dog4);
        imageIds.add(R.drawable.dog5);
        imageIds.add(R.drawable.dog1);
        imageIds.add(R.drawable.dog2);
        imageIds.add(R.drawable.dog3);
        imageIds.add(R.drawable.dog4);
        imageIds.add(R.drawable.dog5);
        imageIds.add(R.drawable.dog1);
        imageIds.add(R.drawable.dog2);
        imageIds.add(R.drawable.dog3);
        imageIds.add(R.drawable.dog4);
        imageIds.add(R.drawable.dog5);
        imageIds.add(R.drawable.dog1);
        imageIds.add(R.drawable.dog2);
        imageIds.add(R.drawable.dog3);
        imageIds.add(R.drawable.dog4);
        imageIds.add(R.drawable.dog5);
        return imageIds;
    }
}
