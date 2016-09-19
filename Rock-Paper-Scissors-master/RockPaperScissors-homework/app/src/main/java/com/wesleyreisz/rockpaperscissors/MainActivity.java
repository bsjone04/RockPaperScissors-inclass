package com.wesleyreisz.rockpaperscissors;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Rock Paper Scissors Lizard Spock";
    public static final String PLAYER_CHOICE = "com.wesleyreisz.rock_paper_scissors.player_choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton rock = (ImageButton)findViewById(R.id.btnRock);
        rock.setOnClickListener(this);
        ImageButton paper = (ImageButton)findViewById(R.id.btnPaper);
        paper.setOnClickListener(this);
        ImageButton scissors = (ImageButton)findViewById(R.id.btnScissors);
        scissors.setOnClickListener(this);

        //added these images
        ImageButton lizard = (ImageButton)findViewById(R.id.btnLizard);
        lizard.setOnClickListener(this);
        ImageButton spock = (ImageButton)findViewById(R.id.btnSpock);
        spock.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            //create a new explict activity here.
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.action_help_dialog){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            ImageView img = (ImageView) new ImageView(this); // <--- img is not visible through dialog..
            img.setImageResource(R.drawable.rules);
            alert.setView(img);
            alert.show();
        }else if (id == R.id.action_stats){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            TextView statsView = new TextView(this);

            RockPaperScissorsApplication app = ((RockPaperScissorsApplication)this.getApplication());
            statsView.setText("You have won: " + app.getWins() + " of " + app.getTotalGames() + " games.");
            statsView.setPadding(20, 20, 20, 50);
            statsView.setGravity(Gravity.CENTER);
            alert.setTitle("Game Statistics");
            alert.setView(statsView);
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //adds animation to the click
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(animAlpha);

        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra(PLAYER_CHOICE, v.getId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RockPaperScissorsApplication app = ((RockPaperScissorsApplication)this.getApplication());
        String msg = "Welcome!";
        if(app.getTotalGames()>0) {
           msg = "You've won: " + app.getWins() + " of " + app.getTotalGames();
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
