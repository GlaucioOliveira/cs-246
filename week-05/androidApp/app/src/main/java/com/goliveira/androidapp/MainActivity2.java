package com.goliveira.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView txtFavoriteScripture = null;
    Button btnSaveScripture = null;
    Scripture favoriteScripture = null;
    String preferenceKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        preferenceKey = preferenceKey = getString(R.string.preference_key);

        txtFavoriteScripture = findViewById(R.id.txtFavoriteScripture);
        btnSaveScripture = findViewById(R.id.btnSaveScripture);
        btnSaveScripture.setOnClickListener(this);

        favoriteScripture = (Scripture)getIntent().getSerializableExtra("FAVORITE_SCRIPTURE");

        if(favoriteScripture != null)
        {
            Log.i("MainActivity2", "Received intent with the favorite scripture: " + favoriteScripture.toString());

            txtFavoriteScripture.setText(favoriteScripture.toString());
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSaveScripture)
        {
            if(favoriteScripture != null)
            {
                Gson gson = new Gson();
                String favoriteScriptureJson = gson.toJson(favoriteScripture);

                SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(preferenceKey, favoriteScriptureJson);
                editor.commit();

                Toast.makeText(MainActivity2.this, getString(R.string.scripture_saved), 5).show();
            }
        }
    }
}