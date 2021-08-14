using System;

namespace Bowling_Alley
{
    abstract class GameRule
    {
        public abstract int getChange();

        public abstract int getScore(int score, int prescore);
        public abstract bool IsWinner(Player currentPlayer, int round, int score, int chanceCount);

        public abstract int getRound();
    }
}