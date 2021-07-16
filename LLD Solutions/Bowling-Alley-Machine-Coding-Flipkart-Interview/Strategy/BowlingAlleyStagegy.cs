using System.Collections.Generic;

namespace Bowling_Alley
{
    internal class BowlingAlleyStagegy : GameRule
    {
        private int rounds;
        public BowlingAlleyStagegy(List<Player> gamePlayer, int rounds)
        {
            this.rounds = rounds;
        }
        public override int getChange()
        {
            return 2;
        }

        public override int getRound()
        {
            return this.rounds;
        }

        public override int getScore(int score, int prescore)
        {
            if (score == 10 ) return score + 10;

            if (score+prescore == 10) return score + 5;

            return score;
        }

        public override bool IsWinner(Player currentPlayer, int round, int score, int chanceCount)
        {

            if(round == this.rounds)
            {
                if(score == 10 && chanceCount == chanceCount )
                {

                }

            }

            return false;
        }
    }
}