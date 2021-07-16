using System;

namespace Bowling_Alley
{
    internal class Player
    {
        private string name;
        private bool isWinner;
        private int round;
        private PlayerScoreCard playerScoreCard;
        public Player(string name)
        {
            this.name = name;
            playerScoreCard = new PlayerScoreCard();
        }

        public bool IsWinner()
        {
            return isWinner;
        }

        public string getName()
        {
            return name;
        }

        public void setRound(int round)
        {
            this.round = round;
        }
        public int getRound()
        {
            return this.round;
        }

    }
}