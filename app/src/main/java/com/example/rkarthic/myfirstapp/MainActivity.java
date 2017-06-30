package com.example.rkarthic.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int counter1, counter2;
    Button add, sub;
    TextView display1, display2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter1 = counter2 = 0;

        add = (Button) findViewById(R.id.add_button);
        sub = (Button) findViewById(R.id.subtract_button);

        display1 = (TextView) findViewById(R.id.displayTextKarthi);
        display2 = (TextView) findViewById(R.id.displayTextGnana);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
                display1.setText("Karthi " + counter1);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                display2.setText("Gnana " + counter2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutUs:
                Intent i = new Intent("com.example.rkarthic.ABOUT");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent("com.example.rkarthic.PREFS");
                startActivity(p);
                break;
            case R.id.menuSearch:
                /*
                have a look at this feature
                Log.i("HI","Hello");
                android.widget.SearchView searchView = (android.widget.SearchView)item.getActionView();

                searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {


                        return false;
                    }
                });
*/
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }



}
