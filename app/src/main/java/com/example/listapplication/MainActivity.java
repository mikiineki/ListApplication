package com.example.listapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] foodItems;
    String[] foodPrices;
    String[] foodDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        foodItems = res.getStringArray(R.array.foodItems);
        foodPrices = res.getStringArray(R.array.foodPrices);
        foodDescriptions = res.getStringArray(R.array.foodDescriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, foodItems, foodPrices, foodDescriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });
    }
}
