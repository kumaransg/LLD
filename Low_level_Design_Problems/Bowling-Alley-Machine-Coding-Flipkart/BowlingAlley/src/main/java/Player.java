import java.util.Collection;

public class Player {

    private Collection<Round> rounds = null;

    public Collection<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Collection<Round> rounds) {
        this.rounds = rounds;
    }

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int chance1 = 0;

    public int getChance1() {
        return chance1;
    }

    public void setChance1(int chance1) {
        this.chance1 = chance1;
    }

    private int chance2=0;

    public int getChance2() {
        return chance2;
    }

    public void setChance2(int chance2) {
        this.chance2 = chance2;
    }
}
