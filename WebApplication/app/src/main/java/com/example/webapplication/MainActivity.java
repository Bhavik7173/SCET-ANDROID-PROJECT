package com.example.webapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
//        String HtmlData = "<html><body><h1>Hello, Good Afternoon Students </h1></body></html>";
        /*String HtmlData = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        [data-type='rad']{\n" +
                "            border: 2px double red;\n" +
                "            color: brown;\n" +
                "            border-radius: 3px;\n" +
                "        }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div data-type=\"rad\">First Div</div><br>\n" +
                "    <button data-type=\"rad\">Button</button><br>\n" +
                "    <p>First Para</p><br>\n" +
                "</body>\n" +
                "</html>\n";
        webView.loadData(HtmlData,"text/html","UTF-8");*/

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.google.com");
        webView.loadUrl("https://classroom.google.com/c/NDk3MjI1NzA1MzY5");
    }
}
