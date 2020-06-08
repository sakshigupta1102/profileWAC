package com.example.sakshigupta.profile;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class githubsearch1 extends AppCompatActivity {
TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_githubsearch1);
        textview = findViewById(R.id.textviewjson);
        URL searchurl = NeworkUtil.buildRepoSearchurl("android");
         new GithubQueryTask().execute(searchurl);
    }

    public class GithubQueryTask extends AsyncTask<URL,Void,String>{

        @Override
        protected String doInBackground(URL... params) {
            URL url = params[0];
            String githubresults= null;
            try{
                githubresults = NeworkUtil.getResponsefromhttp(url);
            }catch (IOException e){
                e.printStackTrace();
            }
            return githubresults;
        }
        @Override
        protected  void onPostExecute(String githubStringresult){
            if(githubStringresult != null && !githubStringresult.equals("")){
                textview.setText(githubStringresult);
            }

        }
    }


}
