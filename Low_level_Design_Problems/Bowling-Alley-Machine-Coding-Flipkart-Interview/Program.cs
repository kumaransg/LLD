using System;
using System.Collections.Generic;

namespace Bowling_Alley
{
    class Program
    {
        static void Main(string[] args)
        {

            string playerName;
            List<Player> gamePlayer = new List<Player>();

            Console.WriteLine($"Enter Number of Player");

            int numberOfPlayer = Convert.ToInt32(Console.ReadLine());

            for(int i = 0; i < numberOfPlayer; i++)
            {
                Console.WriteLine($"Enter Name of Player {i+1}");
                playerName = Console.ReadLine();
                Player player = new Player(playerName);
                gamePlayer.Add(player);
            }

            Console.WriteLine($"Enter Number of Round");

            int Rounds = Convert.ToInt32(Console.ReadLine());
            GameRule rule = new BowlingAlleyStagegy(gamePlayer, Rounds);

            GameFactory gameFactory = new GameFactory();

            Game BowlingAlley = gameFactory.getNewGame(gamePlayer, rule);

            BowlingAlley.Start();

        }
    }
}
