package net.braniumacademy.exercises43;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import net.braniumacademy.exercises1.CountryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnExercises1 = findViewById(R.id.btn_exercises1);
        btnExercises1.setOnClickListener(v -> {
            Intent intent = new Intent(this, CountryActivity.class);
            startActivity(intent);
        });
    }
}