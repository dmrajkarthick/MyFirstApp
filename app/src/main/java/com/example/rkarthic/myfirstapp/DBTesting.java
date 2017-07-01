package com.example.rkarthic.myfirstapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rkarthic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rkarthic on 27-06-2017.
 */

public class DBTesting extends AppCompatActivity{

    private TextView dbContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testingdb);

        this.dbContent = (TextView) findViewById(R.id.tvDBContent);
        new GetAllUserDetails().execute(new ApiConnector());
    }

    private class GetAllUserDetails extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // it is executed on BackGround thread.
            return params[0].GetAllUsers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            setTextToTextView(jsonArray);
        }
    }

    public void setTextToTextView(JSONArray jsonArray) {
        String s = "";
        for(int i=0; i<jsonArray.length();i++)
        {
            String test ="";
            JSONObject json = null;
            try{
                json = jsonArray.getJSONObject(i);
                s = s + "S no : " + json.getInt("sno") +"\n"+
                        "Name : " + json.getString("name") + "\n" +
                        "Father Name : " + json.getString("father_name") + "\n" +
                        "date of Birth : " + json.getString("DOB") + "\n";
            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

        this.dbContent.setText(s);
    }
}
