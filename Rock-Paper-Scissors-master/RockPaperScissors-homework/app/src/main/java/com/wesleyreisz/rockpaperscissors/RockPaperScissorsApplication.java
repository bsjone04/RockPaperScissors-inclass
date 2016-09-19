package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by wesleyreisz on 9/27/15.
 */
public class RockPaperScissorsApplication extends Application {
    private int wins = 0;
    private int loses = 0;
    private int totalGames = 0;

    public void addWin() {
        this.wins++;
        this.totalGames++;
    }

    public void addTies() {
        this.totalGames++;
    }

    public void addLose(){
        this.loses++;
        this.totalGames++;
    }

    public int getTotalGames() {
        return this.totalGames;
    }
    public int getLoses() {
        return this.loses;
    }
    public int getWins() {
        return this.wins;
    }
}
