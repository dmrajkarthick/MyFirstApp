package com.example.rkarthic.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rkarthic on 14-06-2017.
 */

public class Email extends AppCompatActivity implements View.OnClickListener{
    
    EditText personEmail, intro, personsName, stupidThings, hatefulAction, outro;
    String emailAdd, beginning, name, stupidAction, hatefulAct, out;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        intializeVars();
        sendEmail.setOnClickListener(this);
    }

    private void intializeVars() {
        personEmail = (EditText) findViewById(R.id.etEmail);
        intro = (EditText) findViewById(R.id.etIntro);
        personsName = (EditText) findViewById(R.id.etPersonName);
        stupidThings = (EditText) findViewById(R.id.etStupidThings);
        hatefulAction = (EditText) findViewById(R.id.etHatefulAction);
        outro = (EditText) findViewById(R.id.etOutRo);
        sendEmail = (Button) findViewById(R.id.bsendEmail);
    }

    @Override
    public void onClick(View v) {
        convertEditTextVarsIntoStrings();
        String[] emailAddress = {emailAdd};
        String message = "Hello and welcome! " +
                " This is the message";

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "This is the subject");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);
    }

    private void convertEditTextVarsIntoStrings() {
        emailAdd = personEmail.getText().toString();
        beginning = intro.getText().toString();
        name = personsName.getText().toString();
        stupidAction = stupidThings.getText().toString();
        hatefulAct = hatefulAction.getText().toString();
        out = outro.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
