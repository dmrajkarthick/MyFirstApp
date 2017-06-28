package com.example.rkarthic.myfirstapp;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Entity;

import java.io.IOException;

/**
 * Created by rkarthic on 27-06-2017.
 */

public class ApiConnector {

    public JSONArray GetAllUsers()
    {
        //URL to access the script that return all the users from the DB.
        String url = "http://10.0.2.2/myAppTesting/index.php";

        HttpEntity httpEntity = null;
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();

        }catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;
        if(httpEntity !=null)
        {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);
                Log.e("Entity response : ", entityResponse);
                jsonArray = new JSONArray(entityResponse);
            }catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }
}
