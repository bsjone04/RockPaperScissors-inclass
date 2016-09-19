package com.wesleyreisz.rockpaperscissors.Game;

/**
 * Created by wesleyreisz on 9/27/15.
 */
public class GameResult {
    private Integer winner;
    private Integer loser;
    private String textResult;
    private String status;

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Integer getLoser() {
        return loser;
    }

    public void setLoser(Integer loser) {
        this.loser = loser;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameResult that = (GameResult) o;

        if (!winner.equals(that.winner)) return false;
        if (!loser.equals(that.loser)) return false;
        return textResult.equals(that.textResult);

    }

    @Override
    public int hashCode() {
        int result = winner.hashCode();
        result = 31 * result + loser.hashCode();
        result = 31 * result + textResult.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "winner=" + winner +
                ", loser=" + loser +
                ", textResult='" + textResult + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
