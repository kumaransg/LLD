package models;

public class PlayerData {
    int score;
    int wicketsTaken;
    int numberOfSix;
    int numberOfFour;
    int numberOfBallsFaced;

    public PlayerData() {
        this.score = 0;
        this.wicketsTaken = 0;
        this.numberOfSix = 0;
        this.numberOfFour = 0;
        this.numberOfBallsFaced = 0;
    }

    public int getScore() {
        return score;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public int getNumberOfSix() {
        return numberOfSix;
    }

    public int getNumberOfFour() {
        return numberOfFour;
    }

    public int getNumberOfBallsFaced() {
        return numberOfBallsFaced;
    }

    private void updateScore(int score) {
        this.score += score;
    }

    private void updateNumberOfSix() {
        this.numberOfSix += 1;
    }

    private void updateNumberOfFour() {
        this.numberOfFour += 1;
    }

    private void updateNumberOfBallsFaced() {
        this.numberOfBallsFaced += 1;
    }

    public void updatePlayerScore(int score) {
        updateScore(score);
        updateNumberOfBallsFaced();
        switch (score) {
        case 4:
            updateNumberOfFour();
            break;
        case 6:
            updateNumberOfSix();
        }
    }

}
