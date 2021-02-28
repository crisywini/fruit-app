package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private ImageView playerImageView;
    private TextView scoreTextView;
    private MediaPlayer mp;

    private int randomImage = (int) Math.floor(Math.random()*10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureView();
    }
    private void configureView(){
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        playerImageView = (ImageView)  findViewById(R.id.player_image);
        scoreTextView = (TextView) findViewById(R.id.score_text_view);

        getSupportActionBar().setDisplayShowHomeEnabled(true); // Configuring the image
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);
        configureImage();
        configureAudio();
    }

    private void configureImage(){
        int id = 0;
        if((0 | 10) == randomImage){
            id = getResources().getIdentifier("morty", "drawable", getPackageName());
            playerImageView.setImageResource(id);
        }else if((1| 9) == randomImage){
            id = getResources().getIdentifier("rick", "drawable", getPackageName());
            playerImageView.setImageResource(id);
        }else if((2 | 8) == randomImage){
            id = getResources().getIdentifier("pickels", "drawable", getPackageName());
            playerImageView.setImageResource(id);
        }else if((3 | 7) == randomImage){
            id = getResources().getIdentifier("mango", "drawable", getPackageName());
            playerImageView.setImageResource(id);
        }else if((4 | 5 | 6) == randomImage){
            id = getResources().getIdentifier("manzana", "drawable", getPackageName());
            playerImageView.setImageResource(id);
        }
    }

    private void configureAudio(){
        mp = MediaPlayer.create(this, R.raw.alphabet_song);
        mp.start();
        mp.setLooping(true);
    }
    private boolean isInputValid(){
        boolean valid = false;
        String errorMessage = "";
        String name = nameEditText.getText().toString();
        if(name.isEmpty()){
            errorMessage += "Debes ingresar el nombre\n";
        }
        if(errorMessage.isEmpty()){
            valid = true;
        }else{
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
        return valid;
    }
    public void playOnClick(View view){
        if(isInputValid()){
            //Ir a la otra actiivity
        }
    }
}