package com.example.diffutildemo.diffutils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.diffutildemo.R;
import com.example.diffutildemo.diffutils.common.SencondActivity;
import com.example.diffutildemo.diffutils.diffutil.MainActivity;
import com.example.diffutildemo.diffutils.sortedlist.SortedListActivity;


public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        findViewById(R.id.btnDiff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.btnSortedList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, SortedListActivity.class));
            }
        });
        findViewById(R.id.btnCommon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, SencondActivity.class));
            }
        });
    }
}
