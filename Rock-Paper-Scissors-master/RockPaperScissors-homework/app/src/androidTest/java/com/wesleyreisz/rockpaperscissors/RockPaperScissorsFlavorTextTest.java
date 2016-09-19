package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.wesleyreisz.rockpaperscissors.Game.GameUtils;

import junit.framework.Assert;

/**
 * Created by wesleyreisz on 9/27/15.
 */
public class RockPaperScissorsFlavorTextTest extends ApplicationTestCase<Application> {
    public RockPaperScissorsFlavorTextTest() {
        super(Application.class);
    }

    public void testScissors(){
        Integer player = R.id.btnScissors;

        Assert.assertEquals(GameUtils.CUTS, GameUtils.evaluateWinner(player, R.id.btnPaper).getTextResult());
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player, R.id.btnScissors).getTextResult());
        Assert.assertEquals(GameUtils.CRUSHES,GameUtils.evaluateWinner(player,R.id.btnRock).getTextResult());
        Assert.assertEquals(GameUtils.SMASHES,GameUtils.evaluateWinner(player,R.id.btnSpock).getTextResult());
        Assert.assertEquals(GameUtils.DECAPITATES, GameUtils.evaluateWinner(player, R.id.btnLizard).getTextResult());
    }

    public void testPaper(){
        Integer player = R.id.btnPaper;

        Assert.assertEquals(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnPaper).getTextResult());
        Assert.assertEquals(GameUtils.CUTS,GameUtils.evaluateWinner(player, R.id.btnScissors).getTextResult());
        Assert.assertEquals(GameUtils.COVERS,GameUtils.evaluateWinner(player,R.id.btnRock).getTextResult());
        Assert.assertEquals(GameUtils.DISPROVES,GameUtils.evaluateWinner(player,R.id.btnSpock).getTextResult());
        Assert.assertEquals(GameUtils.EATS, GameUtils.evaluateWinner(player, R.id.btnLizard).getTextResult());
    }

    public void testRock(){
        Integer player = R.id.btnRock;

        Assert.assertEquals(GameUtils.COVERS, GameUtils.evaluateWinner(player, R.id.btnPaper).getTextResult());
        Assert.assertEquals(GameUtils.CRUSHES,GameUtils.evaluateWinner(player, R.id.btnScissors).getTextResult());
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player,R.id.btnRock).getTextResult());
        Assert.assertEquals(GameUtils.VAPORIZES,GameUtils.evaluateWinner(player,R.id.btnSpock).getTextResult());
        Assert.assertEquals(GameUtils.CRUSHES, GameUtils.evaluateWinner(player, R.id.btnLizard).getTextResult());
    }

    public void testSpock(){
        Integer player = R.id.btnSpock;

        Assert.assertEquals(GameUtils.DISPROVES, GameUtils.evaluateWinner(player, R.id.btnPaper).getTextResult());
        Assert.assertEquals(GameUtils.SMASHES,GameUtils.evaluateWinner(player, R.id.btnScissors).getTextResult());
        Assert.assertEquals(GameUtils.VAPORIZES,GameUtils.evaluateWinner(player,R.id.btnRock).getTextResult());
        Assert.assertEquals(GameUtils.TIES,GameUtils.evaluateWinner(player,R.id.btnSpock).getTextResult());
        Assert.assertEquals(GameUtils.POISONS, GameUtils.evaluateWinner(player, R.id.btnLizard).getTextResult());
    }


    public void testLizard(){
        Integer player = R.id.btnLizard;

        Assert.assertEquals(GameUtils.EATS, GameUtils.evaluateWinner(player, R.id.btnPaper).getTextResult());
        Assert.assertEquals(GameUtils.DECAPITATES,GameUtils.evaluateWinner(player, R.id.btnScissors).getTextResult());
        Assert.assertEquals(GameUtils.CRUSHES,GameUtils.evaluateWinner(player,R.id.btnRock).getTextResult());
        Assert.assertEquals(GameUtils.POISONS,GameUtils.evaluateWinner(player,R.id.btnSpock).getTextResult());
        Assert.assertEquals(GameUtils.TIES, GameUtils.evaluateWinner(player, R.id.btnLizard).getTextResult());
    }
}
