package br.edu.ifpb.notificationconect.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.edu.ifpb.notificationwear.util.HttpService;
import br.edu.ifpb.notificationwear.util.StringUtil;


public class LoginAsyncTask extends AsyncTask<String, Void, HttpURLConnection>{

    Context context;

    public LoginAsyncTask(Context activity) {

        this.context = activity;
    }

    @Override
    protected void onPreExecute() {

        Log.i("Notificationconect", "OnPreExecute");
    }

    @Override
    protected HttpURLConnection doInBackground(String... valores) {

        Log.i("Notificationconect", "doInBackground: " + valores[0]);

        HttpURLConnection connection = null;

        try {

            connection = HttpService.sendGetRequest("servicoservlet");

        } catch (MalformedURLException ex) {

            Log.e("Notificationconect","MalformedURLException");

        } catch (IOException ex) {

            Log.e("Notificationconect","MalformedURLException");
        }

        return connection;
    }

    @Override
    protected void onPostExecute(HttpURLConnection connection) {

        try {

            int status = connection.getResponseCode();

            Log.i("Notificationconect", "Status HTTP-Response: " + status);

            String contentValue = HttpService.getHttpContent(connection);
            JSONObject json = new JSONObject(contentValue);

            String nome = json.getString("nome");
            Toast.makeText(context, nome, Toast.LENGTH_LONG).show();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            Log.e("Notificationconect", "JSONException");
        }
    }
}
