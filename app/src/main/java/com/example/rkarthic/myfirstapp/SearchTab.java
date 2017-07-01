package com.example.rkarthic.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.rkarthic.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchTab extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ListView lv = (ListView)findViewById(R.id.listViewCountry);
        arrayCountry = new ArrayList<>();
        arrayCountry.addAll(Arrays.asList(getResources().getStringArray(R.array.array_country)));

        adapter = new ArrayAdapter<>(
                SearchTab.this,
                android.R.layout.simple_list_item_1,
                arrayCountry);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cool_menu, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();
        //searchView.setOnSearchClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);


                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String summa = (String) parent.getItemAtPosition(position);
        Class c = null;
        try {
            c = Class.forName("com.example.rkarthic.myfirstapp." + summa);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent a = new Intent(SearchTab.this, c);
        startActivity(a);
    }
}
