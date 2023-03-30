package com.maprod.countermaprod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount;

    private int count = 0;
    private static final String KEY_COUNT = "key";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast toast = Toast.makeText(this, R.string.activity_create, Toast.LENGTH_SHORT);
        toast.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCount = findViewById(R.id.textCount);
        Button buttonCount = findViewById(R.id.buttonCount);

        buttonCount.setOnTouchListener(touchListener);
        buttonCount.setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, R.string.activity_start, Toast.LENGTH_SHORT);
        toast.show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, R.string.activity_resume, Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.BOTTOM, 0, 0);

        toast.show();
        super.onResume();
    }

    @SuppressLint("RtlHardcoded")
    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, R.string.activity_stop, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, R.string.activity_destroy, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, R.string.activity_pause, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Toast toast = Toast.makeText(this, R.string.activity_restart, Toast.LENGTH_SHORT);
        toast.show();
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_COUNT, count);
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt(KEY_COUNT);
        textCount.setText("" + count);
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
    }


    private final View.OnClickListener listener = new View.OnClickListener() {

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            count++;
            textCount.setText("" + count);

        }
    };

    private final View.OnTouchListener touchListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    };
}