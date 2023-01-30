package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveProfile();
    }

    private void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.nameEntry);
        TextView statusView = findViewById(R.id.statusEntry);

        editor.putString("name", nameView.getText().toString());
        editor.putString("status", statusView.getText().toString());

        editor.apply();
    }

    private void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "Kanishk");
        String status = preferences.getString("status", "Working on Lab 4!");

        TextView nameView = findViewById(R.id.nameEntry);
        nameView.setText(name);

        TextView statusView = findViewById(R.id.statusEntry);
        statusView.setText(status);
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}