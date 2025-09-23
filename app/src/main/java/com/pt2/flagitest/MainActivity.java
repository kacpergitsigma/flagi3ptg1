package com.pt2.flagitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int remainingFlags = 4;
    TextView task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        task = ((TextView)findViewById(R.id.text));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void correctFlag(View view) {
        Toast.makeText(this, R.string.don_t_touch_this_color, Toast.LENGTH_SHORT).show();
    }
    public void incorrectFlag(View view) {
        remainingFlags--;
        view.setVisibility(View.INVISIBLE);
        if (remainingFlags == 0) {
            task.setText(R.string.congratulations_congratulations_this_is_the_polish_flag);
            findViewById(R.id.nextCountryButton).setVisibility(View.VISIBLE);
        }
    }

    public void nextCountry(View view) {
        view.setVisibility(View.INVISIBLE);
        findViewById(R.id.button2).setVisibility(View.VISIBLE);
        findViewById(R.id.button3).setVisibility(View.VISIBLE);
        findViewById(R.id.button4).setVisibility(View.VISIBLE);
        findViewById(R.id.button5).setVisibility(View.VISIBLE);
        findViewById(R.id.button6).setVisibility(View.VISIBLE);
        task.setText(R.string.taskua);
    }
}