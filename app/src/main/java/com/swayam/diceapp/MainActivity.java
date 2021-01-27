package com.swayam.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    Button btnRoll;
    ImageView imgDice1,imgDice2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = findViewById(R.id.btnRoll);
        imgDice1 = findViewById(R.id.imgDice1);
        imgDice2 = findViewById(R.id.imgDice2);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        final int[] diceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        btnRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //if already playing then stop and play
                if (mp.isPlaying()) {
                    mp.stop();
                    try { mp.prepare(); } catch (IOException e) { }
                }
                mp.start();
                Random random = new Random();
                final int myRandomNumber1 = random.nextInt(6);
                final int myRandomNumber2 = random.nextInt(6);
                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));
                imgDice1.setImageResource(diceImages[myRandomNumber1]);
                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));
                imgDice2.setImageResource(diceImages[myRandomNumber2]);


            }
        });
    }
}