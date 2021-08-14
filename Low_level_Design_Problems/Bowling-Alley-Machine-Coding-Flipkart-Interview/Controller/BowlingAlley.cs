using System;
using System.Collections.Generic;
using System.Text;

namespace Bowling_Alley.Controller
{
    struct Score
    {
        public int score;
        public int actualScore;
        public string obtained;
    }
    class BowlingAlley : Game
    {
        private List<Player> gamePlayer;
        private GameRule rule;
        Queue<Player> turn;
        Dictionary<Player, List<Score>> scoreCard;
        Dictionary<Player, int> LeaderBoard;
        Dictionary<Player, int> finalScore;
        public BowlingAlley(List<Player> gamePlayer, GameRule rule)
        {
            this.gamePlayer = gamePlayer;
            this.rule = rule;
            turn = new Queue<Player>();
            this.scoreCard = new Dictionary<Player, List<Score>>();
            this.LeaderBoard = new Dictionary<Player, int>();
            this.finalScore = new Dictionary<Player, int>();
        }

        public override void Start()
        {
            Player currentPlayer;

            for (int round = 1; round <= rule.getRound(); round++)
            { 
                for (int playerturn = 0; playerturn < gamePlayer.Count; playerturn++)
                {
                    currentPlayer = gamePlayer[playerturn];

                    int score = 0;
                    int actualScore = 0;
                    int chanceCount = 0;
                    int finalscore = 0;
                    int preScore = 0;
                    bool triggerBonusBall = false;
                    for (int i = 1; i <= rule.getChange(); i++)
                    {
                        Console.WriteLine($"Enter Score for {currentPlayer.getName()} - Chance{i}:");

                        score = Convert.ToInt32(Console.ReadLine());

                        actualScore = rule.getScore(score, preScore);
                        Score playerScore = new Score();
                        playerScore.score = score;

                        playerScore.actualScore = actualScore;
                        playerScore.obtained = "";

                        if (score == 10)
                            playerScore.obtained = "strike";
                        else if (score+preScore == 10)
                            playerScore.obtained = "spare";

                        if (!scoreCard.ContainsKey(currentPlayer))
                        {
                            scoreCard[currentPlayer] = new List<Score>();
                        }
                        scoreCard[currentPlayer].Add(playerScore);
                        finalscore += actualScore;
                        if (score == 10 || (score + preScore == 10))
                            triggerBonusBall = true;
                        if (score == 10) break;
                        chanceCount++;
                        preScore = score;
                    }
                    if (round == rule.getRound() && triggerBonusBall)
                    {
                        Console.Write($"You have got 2 new balls:");
                        score = 0;
                        preScore = 0;
                        int bonusScore = 0;
                        for (int i = 1; i <= 2; i++)
                        {
                            Console.Write($"Enter Score for {currentPlayer.getName()} - Chance{i}:");

                            score = Convert.ToInt32(Console.ReadLine());

                            bonusScore = rule.getScore(score, preScore);
                            Score playerScore = new Score();
                            playerScore.score = score;

                            playerScore.actualScore = bonusScore;
                            playerScore.obtained = "";
                            if (score == 10)
                                playerScore.obtained = "strike";
                            if (score+preScore == 5)
                                playerScore.obtained = "spare";

                            if (!scoreCard.ContainsKey(currentPlayer))
                            {
                                scoreCard[currentPlayer] = new List<Score>();
                            }
                            scoreCard[currentPlayer].Add(playerScore);
                            finalscore += bonusScore;
                            chanceCount++;
                            preScore = score;
                        }
                    }
                    if (!finalScore.ContainsKey(currentPlayer))
                        finalScore.Add(currentPlayer,0);
                    finalScore[currentPlayer] += finalscore;
                    turn.Enqueue(currentPlayer);
                }

                ShowLeaderBoard();
            }
            ShowFinalBoard();
        }

        private void ShowFinalBoard()
        {
            SortedDictionary<int, List<Player>> score = new SortedDictionary<int, List<Player>>();

            foreach(var item in finalScore)
            {
                if (!score.ContainsKey(item.Value)) score[item.Value] = new List<Player>();
                score[item.Value].Add(item.Key);
            }

            foreach(var items in score)
            {
                foreach (Player player in items.Value)
                {
                    Console.Write($" {player.getName() } Score : {items.Key}");
                }
            }
        }

        private void ShowLeaderBoard()
        {
            Console.WriteLine($"------------------------------------------------");
            foreach (var item in scoreCard)
            {
                Console.WriteLine($"Player {item.Key.getName()}");

                foreach (Score score in item.Value)
                    Console.WriteLine($"Score {score.score}, (bonus+score) {score.actualScore} ,  {score.obtained} ");
                
            }

            Console.WriteLine($"------------------------------------------------");
        }
    }
}
