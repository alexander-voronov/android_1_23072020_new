package com.geekbrains.a1l1_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    final static String dataKey = "dataKey";
    private final int requestCode = 32156;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                String selectCity1 = "Moscow";
                intent.putExtra(dataKey, selectCity1);
                startActivityForResult(intent, requestCode);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == this.requestCode && resultCode == RESULT_OK && data != null) {
            String strData = data.getStringExtra(MainActivity.dataKey);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }


}