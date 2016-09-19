package com.wesleyreisz.rockpaperscissors.GameTypes;

import com.wesleyreisz.rockpaperscissors.Game.GameResult;
import com.wesleyreisz.rockpaperscissors.Game.GameUtils;
import com.wesleyreisz.rockpaperscissors.R;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class RockGameTypeImpl implements GameType {
    @Override
    public GameResult eval(Integer opponentChoice) {
        GameResult result = new GameResult();
        if (opponentChoice== R.id.btnScissors){
            result.setWinner(R.id.btnRock);
            result.setTextResult(GameUtils.CRUSHES);
            result.setLoser(R.id.btnScissors);
            result.setStatus(GameUtils.WINS);
        }else if (opponentChoice==R.id.btnPaper){
            result.setWinner(R.id.btnPaper);
            result.setTextResult(GameUtils.COVERS);
            result.setLoser(R.id.btnRock);
            result.setStatus(GameUtils.LOSES);
        }else if (opponentChoice==R.id.btnLizard){
            result.setWinner(R.id.btnRock);
            result.setTextResult(GameUtils.CRUSHES);
            result.setLoser(R.id.btnLizard);
            result.setStatus(GameUtils.WINS);
        }else if (opponentChoice==R.id.btnSpock){
            result.setWinner(R.id.btnSpock);
            result.setTextResult(GameUtils.VAPORIZES);
            result.setLoser(R.id.btnRock);
            result.setStatus(GameUtils.LOSES);
        }
        else{
            result.setWinner(R.id.btnRock);
            result.setTextResult(GameUtils.TIES);
            result.setLoser(R.id.btnRock);
            result.setStatus(GameUtils.PUSH);
        }
        return result;
    }
}
