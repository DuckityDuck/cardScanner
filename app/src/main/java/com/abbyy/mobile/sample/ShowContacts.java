package com.abbyy.mobile.sample;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;
import static com.abbyy.mobile.sample.R.id.textView;


public class ShowContacts extends Activity {
    private final String TAG = "ShowContacts";
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("Scanned");
        displayInformation();
        final String finalMessage = "Name:Catherine Fang";



/*
        //while (index != -1){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = finalMessage;
                int index = result.indexOf(" ");
                final String firstName = result.substring(5,index);
                final String lastName = result.substring(index + 1);
                Log.e(TAG, "First name = " + firstName + ", Last name = " + lastName);
                // https://www.linkedin.com/search/results/index/?keywords=Catherine%20Fang&origin=GLOBAL_SEARCH_HEADER
                url = "https://www.linkedin.com/search/results/index/?keywords=" + firstName +"%20" + lastName + "&origin=GLOBAL_SEARCH_HEADER";
                try {
                    result = result + "\n" + fetchResult(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "result = " + result);
                final String finalResult = result;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Capture the layout's TextView and set the string as its text
                        TextView textView = (TextView) findViewById(R.id.textView2);
                        textView.setText(finalResult);
                    }
                });
            }
        });
        thread.start();

        // }
*/

    }

    String fetchResult(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(ShowContacts.this, MainActivity.class);
        startActivity(intent);
    }

    public void displayInformation(){
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra("Scanned"));



    }

    public void copyText(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", getIntent().getStringExtra("Scanned"));
        clipboard.setPrimaryClip(clip);

    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
