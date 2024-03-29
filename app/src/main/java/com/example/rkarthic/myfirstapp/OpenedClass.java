package com.example.rkarthic.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rkarthic.R;

/**
 * Created by rkarthic on 20-06-2017.
 */

public class OpenedClass extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = getData.getString("etName", "Raj Karthick is..");
        String values = getData.getString("list", "4");

        if(values.contentEquals("1"))
        {
            question.setText(et);
        }

        /*Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
        question.setText(gotBread);*/
    }

    private void initialize() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvTex);
        returnData = (Button) findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", setData);
        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
         switch (checkedId)
         {
             case R.id.rcrazy:
                 setData = "Probably right!";
                 break;
             case R.id.rsupercrazy:
                 setData = "Definitely right!";
                 break;
             case R.id.rsuperlazy:
                 setData = "Spot On!";
                 break;
         }
        test.setText(setData);
    }
}
