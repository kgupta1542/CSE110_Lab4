package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void OnShowCounterClicked(View view) {
        Intent intent  = new Intent(this, CounterActivity.class);

        TextView maxCountView = findViewById(R.id.maxCountView);
        String maxCountStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        if(!maybeMaxCount.isPresent()){
            Utilities.showAlert(this, "That isn't a number!");
            return;
        }

        int maxCount = maybeMaxCount.get();

        if(maxCount <= 0){
            Utilities.showAlert(this, "Please enter a positive number!");
            return;
        }

        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }
}