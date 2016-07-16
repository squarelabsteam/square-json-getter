package space.cubelabs.myaccount.data;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Made by Liam Edwards on 16/07/2016.
 * Copyright Liam Edwards, space.cubelabs.myaccount.data and Cube Labs
 */
public class HTTPDataHandler {
    static String stream = null;

    public HTTPDataHandler() {

    }

    public String GetHTTPData(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(urlConnection.getResponseCode() == 200) {
                InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                urlConnection.disconnect();
            } else {
                Log.e("HTTPDATA", "Error Not Working");
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {

        }
        // Return the data from specified url
        return stream;
    }
}
