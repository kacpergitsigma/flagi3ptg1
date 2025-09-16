package com.pt2.flagitest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void test(View view) {
        view.setVisibility(View.INVISIBLE);
//        Toast text = Toast.makeText(this, "U CLICKED DA BUTTONE", Toast.LENGTH_SHORT);
//        text.show();
    }

    public void correctFlag(View view) {
        Toast.makeText(this, "Don't touch this color", Toast.LENGTH_SHORT).show();
    }
    public void incorrectFlag(View view) {
        view.setVisibility(View.INVISIBLE);
    }
}