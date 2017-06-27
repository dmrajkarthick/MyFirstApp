package com.example.rkarthic.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by rkarthic on 05-06-2017.
 */

public class TextPlay extends AppCompatActivity implements View.OnClickListener{


    Button chkCommand;
    ToggleButton passTog;
    EditText input;
    TextView disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        //initializing the app page elements
        assignTheVariables();

        //best way to implements the activity tracking methods and write corresponding logic inside that.
        passTog.setOnClickListener(this);
        chkCommand.setOnClickListener(this);
    }

    private void assignTheVariables()
    {
        chkCommand = (Button) findViewById(R.id.bResults);
        passTog = (ToggleButton) findViewById(R.id.toggleButton);
        input = (EditText) findViewById(R.id.etCommands);
        disp = (TextView) findViewById(R.id.tvResults);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bResults:

                String check = input.getText().toString();
                disp.setText(check);
                if(check.contentEquals("left"))
                {
                    /*MediaPlayer ourSong;
                    ourSong = MediaPlayer.create(TextPlay.this, R.raw.gunshot);
                    ourSong.release();*/
                    disp.setGravity(Gravity.LEFT);
                }
                else if(check.contentEquals("center"))
                {
                    disp.setGravity(Gravity.CENTER);
                }
                else if (check.contentEquals("right"))
                {
                    disp.setGravity(Gravity.RIGHT);
                }
                else if(check.contentEquals("blue"))
                {
                    disp.setTextColor(Color.BLUE);
                }
                else if(check.contentEquals("white"))
                {
                    disp.setTextColor(Color.WHITE);
                }
                else if(check.contentEquals("WTF"))
                {
                    Random crazy =  new Random();
                    disp.setText("WTF!!!!!");
                    disp.setTextSize(crazy.nextInt(75));
                    disp.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
                    switch (crazy.nextInt(3))
                    {
                        case 0:
                            disp.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            disp.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            disp.setGravity(Gravity.RIGHT);
                            break;
                    }
                }
                else
                {
                    disp.setText("invalid");
                    disp.setGravity(Gravity.CENTER);
                }


                break;

            case R.id.toggleButton:
                if(passTog.isChecked())
                {
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}