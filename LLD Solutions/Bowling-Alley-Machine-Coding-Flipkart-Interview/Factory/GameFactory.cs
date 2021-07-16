using Bowling_Alley.Controller;
using System;
using System.Collections.Generic;

namespace Bowling_Alley
{
    internal class GameFactory
    {
        private List<Player> gamePlayer;
        private GameRule rule;

        public GameFactory()
        {
        }

        internal Game getNewGame(List<Player> gamePlayer, GameRule rule)
        {
            return new BowlingAlley(gamePlayer, rule);
        }
    }
}