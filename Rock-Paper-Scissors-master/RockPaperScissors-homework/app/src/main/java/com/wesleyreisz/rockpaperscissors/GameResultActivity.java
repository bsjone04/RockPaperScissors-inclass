package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wesleyreisz.rockpaperscissors.Game.GameResult;
import com.wesleyreisz.rockpaperscissors.Game.GameUtils;

public class GameResultActivity extends AppCompatActivity {

    private static final String TAG = "Result Page";
    private static final int TEXT_SIZE = 28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.resultLayout);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        Integer playerSelectedChoice = (Integer) intent.getIntExtra(MainActivity.PLAYER_CHOICE, 1);
        Integer computerSelectedChoice = GameUtils.getComputerChoice();
        GameResult result = GameUtils.evaluateWinner(playerSelectedChoice, computerSelectedChoice);

        ImageView winner = (ImageView) findViewById(R.id.btnWinner);
        winner.setImageResource(GameUtils.convertButtonToImage(result.getWinner()));

        TextView resultText = (TextView) findViewById(R.id.txtResult);
        resultText.setText(result.getTextResult());
        resultText.setTextSize(TEXT_SIZE - 8);
        resultText.setTextColor(GameUtils.defineTextColor(result.getStatus()));

        TextView messageText = (TextView) findViewById(R.id.txtMessage);
        messageText.setText(result.getStatus());
        messageText.setTextSize(TEXT_SIZE);
        messageText.setTextColor(Color.WHITE);
        messageText.setBackgroundColor(GameUtils.defineTextColor(result.getStatus()));

        ImageView loser = (ImageView) findViewById(R.id.btnLoser);
        loser.setImageResource(GameUtils.convertButtonToImage(result.getLoser()));

        RockPaperScissorsApplication app = ((RockPaperScissorsApplication)this.getApplication());
        runStats(result, app);
    }

    private void runStats(GameResult result, RockPaperScissorsApplication app) {
        //statistics
        if(GameUtils.WINS==result.getStatus()){
            app.addWin();
        }else if(GameUtils.LOSES==result.getStatus()){
            app.addLose();;
        }else{
            app.addTies();
        }
    }
}
