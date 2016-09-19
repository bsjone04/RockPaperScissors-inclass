package com.wesleyreisz.rockpaperscissors;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.wesleyreisz.rockpaperscissors.Game.GameUtils;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testScissors(){
        Integer player = R.id.btnScissors;

        Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnPaper).getStatus());
        Assert.assertEquals(GameUtils.PUSH,GameUtils.evaluateWinner(player, R.id.btnScissors).getStatus());
        Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player,R.id.btnRock).getStatus());

        //TODO: Uncomment these two tests and get to correctly work
        //Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player,R.id.btnSpock).getStatus());
        //Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnLizard).getStatus());

        Assert.assertNotSame(GameUtils.PUSH, GameUtils.evaluateWinner(player, R.id.btnPaper).getStatus());
    }


    public void testRock(){
        Integer player = R.id.btnRock;

        Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player,R.id.btnPaper).getStatus());
        Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player, R.id.btnScissors).getStatus());
        Assert.assertEquals(GameUtils.PUSH,GameUtils.evaluateWinner(player,R.id.btnRock).getStatus());

        //TODO: Uncomment these two tests and get to correctly work
        //Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player,R.id.btnSpock).getStatus());
        //Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnLizard).getStatus());

        Assert.assertNotSame(GameUtils.PUSH,GameUtils.evaluateWinner(player,R.id.btnPaper).getStatus());
    }

    public void testPaper(){
        Integer player = R.id.btnPaper;

        Assert.assertEquals(GameUtils.PUSH,GameUtils.evaluateWinner(player,R.id.btnPaper).getStatus());
        Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player, R.id.btnScissors).getStatus());
        Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnRock).getStatus());

        //TODO: Uncomment these two tests and get to correctly work
        //Assert.assertEquals(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnSpock).getStatus());
        //Assert.assertEquals(GameUtils.LOSES,GameUtils.evaluateWinner(player,R.id.btnLizard).getStatus());

        Assert.assertNotSame(GameUtils.WINS,GameUtils.evaluateWinner(player,R.id.btnPaper).getStatus());
    }

    public void testSpock(){
        //TODO: Implement test cases to validate the logic of spock works... :)
    }


    public void testLizard(){
        //TODO: Implement test cases to validate the logic of lizard works
    }

}