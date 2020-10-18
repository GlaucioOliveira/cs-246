package com.goliveira.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtBook = null;
    EditText txtChapter = null;
    EditText txtVerse = null;
    Button btnNext = null;
    Button btnLoadScripture = null;
    String preferenceKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceKey = getString(R.string.preference_key);

        LoadControls();

        btnNext.setOnClickListener(this);
        btnLoadScripture.setOnClickListener(this);
    }

    private void LoadControls(){
        btnNext = findViewById(R.id.btnNext);
        btnLoadScripture = findViewById(R.id.btnLoadScripture);

        txtBook = findViewById(R.id.txtBook);
        txtChapter = findViewById(R.id.txtChapter);
        txtVerse = findViewById(R.id.txtVerse);
    }


    @Override
    public void onClick(View view)
    {
        int buttonId = view.getId();

        if(buttonId == R.id.btnNext)
        {
            MoveToNextIntent();
        }
        else if(buttonId == R.id.btnLoadScripture)
        {
            LoadScriptures();
        }
    }

    private void LoadScriptures()
    {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        if(preferences.contains(preferenceKey))
        {
            String favoriteScripture = preferences.getString(preferenceKey, "");
            Gson gson = new Gson();
            Scripture scripture = gson.fromJson(favoriteScripture, Scripture.class);

            if(scripture != null)
            {
                txtBook.setText(scripture.getBook());
                txtChapter.setText(String.valueOf(scripture.getChapter()));
                txtVerse.setText(String.valueOf(scripture.getVerse()));

                Toast.makeText(MainActivity.this, getString(R.string.scripture_loaded), 5).show();
            }
        }
    }

    private void MoveToNextIntent(){
        Scripture favoriteScripture = new Scripture();

        favoriteScripture.setBook(txtBook.getText().toString());
        favoriteScripture.setChapter(Integer.valueOf(txtChapter.getText().toString()));
        favoriteScripture.setVerse(Integer.valueOf(txtVerse.getText().toString()));

        Log.i("MainActivity", "Creating the Intent with the favorite scripture: " + favoriteScripture.toString());

        Intent newIntent = new Intent(MainActivity.this, MainActivity2.class);
        newIntent.putExtra("FAVORITE_SCRIPTURE", favoriteScripture);

        startActivity(newIntent);
    }
}