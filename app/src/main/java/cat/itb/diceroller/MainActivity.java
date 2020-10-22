package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button rollButton;
    ImageView resultImageView;
    ImageView resultImageViewDau2;
    Button restartButton;
    static final int[] diceImages={
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton= findViewById(R.id.roll_button);
        resultImageView=findViewById(R.id.result_imageview);
        resultImageViewDau2=findViewById(R.id.result_imageviewsegondau);
        restartButton=findViewById(R.id.restart_button);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultImageView.setImageResource(R.drawable.empty_dice);
                resultImageViewDau2.setImageResource(R.drawable.empty_dice);
                rollButton.setText(R.string.roll_dice);
            }
        });
        resultImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nombrealeatori= (int) Math.floor(Math.random()*6);
                resultImageView.setImageResource(diceImages[nombrealeatori]);
            }
        });
        resultImageViewDau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nombrealeatori2=(int) Math.floor(Math.random()*6);
                resultImageViewDau2.setImageResource(diceImages[nombrealeatori2]);
            }
        });
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast missatgeTirat=Toast.makeText(MainActivity.this,"Has tirat els daus",Toast.LENGTH_LONG);
                missatgeTirat.show();
                rollButton.setText(R.string.rolled_button);
                int nombrealeatori= (int) Math.floor(Math.random()*6);
                int nombrealeatori2=(int) Math.floor(Math.random()*6);
                resultImageView.setImageResource(diceImages[nombrealeatori]);
                resultImageViewDau2.setImageResource(diceImages[nombrealeatori2]);
                if(nombrealeatori==6&&nombrealeatori2==6){
                    Toast missatgejackpot=Toast.makeText(MainActivity.this,"JACKPOT!",Toast.LENGTH_LONG);
                    missatgejackpot.setGravity(Gravity.TOP,0,250);
                    missatgejackpot.show();
                }
            }
        });


    }
}