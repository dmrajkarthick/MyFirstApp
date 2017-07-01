package com.example.rkarthic.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.rkarthic.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rkarthic on 14-06-2017.
 */

public class Camera extends AppCompatActivity implements View.OnClickListener{
    ImageButton ib;
    Button button;
    ImageView iv;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        InputStream is = getResources().openRawResource(R.raw.clean_code_bg1);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void initialize() {
        ib = (ImageButton) findViewById(R.id.ibTakePic);
        iv = (ImageView) findViewById(R.id.ivReturnedPicture);
        button = (Button) findViewById(R.id.bSetWallpaper);

        button.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bSetWallpaper:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibTakePic:
                    i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, cameraData);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
