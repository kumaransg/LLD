namespace Bowling_Alley
{
    internal class PlayerScoreCard
    {
        private int score = 0;
        public PlayerScoreCard()
        {
            this.score = 0;
        }

        public void AddScore(int score)
        {
            this.score += score;
        }

        public int getScore()
        {
            return score;
        }
    }
}