package com.cookandroid.doitmission04;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText edittext;
    TextView textView;
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.edittext);
        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        edittext.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(80);
                edittext.setFilters(filter);

                //2019038030 김진영
                if (s.length() % 8 == 0) { // 8자일 때마다 줄바꿈
                    edittext.append("\n");
                }
            }

            public void afterTextChanged(Editable s) {}
        });
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), (CharSequence) edittext.getText(), Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        finish();
    }
}