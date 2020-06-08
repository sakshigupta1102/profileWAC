package com.example.sakshigupta.profile;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NeworkUtil {
    private  static  final String GITHUB_BASE_URL ="https://api.github.com";
    private static  final String Github_User= "users";
    private static  final String GITHUB_REPOSITORY = "repositories";
    private static final String GITHUB_SEARCH= "search";
    private static final String PARAM_QUERY ="q";

    private  NeworkUtil(){

    }

    public static URL buildRepoSearchurl(String query){
        Uri buildUri = Uri.parse(GITHUB_BASE_URL).buildUpon().appendPath(GITHUB_SEARCH).appendPath(GITHUB_REPOSITORY)
                .appendQueryParameter(PARAM_QUERY,query).build();
        URL url = null;
        try{
            url = new URL(buildUri.toString());
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }
     public  static  String getResponsefromhttp(URL url) throws IOException{
         HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         try{
             InputStream input = urlConnection.getInputStream();
             Scanner scan = new Scanner(input);
             scan.useDelimiter("\\A");
             if(scan.hasNext()){
                 return scan.next();
             }else return null;
         }finally {
             urlConnection.disconnect();
         }
     }


}
