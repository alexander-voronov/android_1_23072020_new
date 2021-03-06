package com.geekbrains.a1l1_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView textView2;
    final static String dataKey = "dataKey";
    private TextView counterTextView;
    private Button randomCounterBtn;
    private final String counterDataKey = "counterDataKey";
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        findViewById(R.id.button_city_selection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
        findViews();
        showDataFromSecondActivity();
        setOnClickBehaviourToBtn();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        String text = counterTextView.getText().toString();
        saveInstanceState.putString(counterDataKey, text);
        super.onSaveInstanceState(saveInstanceState);
        Log.d(TAG, "onSaveInstanceState");
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(counterDataKey);
        counterTextView.setText(text);
        Log.d(TAG, "onRestoreInstanceState");
    }

    private void findViews() {
        counterTextView = findViewById(R.id.containerTextView);
        randomCounterBtn = findViewById(R.id.randomCounterBtn);
        textView2 = findViewById(R.id.textView2);

    }

    private void setOnClickBehaviourToBtn() {
        randomCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(counterTextView.getText().toString());
                String newValue = String.valueOf(++count);
                counterTextView.setText(newValue);

            }
        });
    }

    private void showDataFromSecondActivity() {
        String data = getIntent().getStringExtra(MainActivity2.dataKey);
        textView2.setText(data);
    }


}