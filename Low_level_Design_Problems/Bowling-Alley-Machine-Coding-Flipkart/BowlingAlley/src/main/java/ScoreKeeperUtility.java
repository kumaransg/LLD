import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class ScoreKeeperUtility {

	//startGame method starts
	private HashMap<Integer,Player> Scores = new HashMap<Integer, Player>();
	public void setScores(HashMap<Integer, Player> scores) {
		Scores = scores;
	}

	public HashMap<Integer, Player> getScores() {
		return Scores;
	}
	public  void startGame(Game game) {

		for(int round=0;round<game.getNo_of_rounds();round++)  //rounds loop
		{
			System.out.println("Round - " + (round + 1));
//			Collection<Round> rounds = new Collection<Round>();
			for (int p = 0; p < game.getNo_of_players(); p++) {
				int first_hit = 0;//number of pins knocked down in the first roll
				int second_hit = 0;//number of pins knocked down in the second roll
				int bonus_points = 0;
				int extra_points = 0;
				//getting the no of pins knocked in the First Roll from User/Controller
				System.out.println("Enter Score for player " + (p + 1) + " Chance 1");
				Scanner in = new Scanner(System.in);
				first_hit = in.nextInt();


				if (first_hit == 10 && (round == (game.getNo_of_rounds() - 1)))//for final round
				{
					//bonus two balls
					bonus_points = 10;
					extra_points  = extraBalls((p+1),2);
					update((p+1), first_hit , second_hit,bonus_points,extra_points);
				} else if (first_hit == 10)//condition for STRIKE
				{
					bonus_points = 10;
					update((p+1), first_hit,second_hit,bonus_points,0);
				} else {
					System.out.println("Enter Score for player " + (p + 1) + " Chance 2");
					second_hit = in.nextInt();
					if((first_hit+second_hit)==10)
						bonus_points=5;
					if(bonus_points==5 && (round == (game.getNo_of_rounds() - 1)))
						extra_points = extraBalls((p+1),3);
					update((p+1), first_hit , second_hit,bonus_points,extra_points);
				}
			}
		}
	}

	public int extraBalls(int player,int chance)
	{
		System.out.println("Hey you got two extra balls !!!!!!");
		System.out.println("Enter Score for player " + (player) + " Chance " + chance);
		Scanner in = new Scanner(System.in);
		int extra_points1 = 0;
		extra_points1=in.nextInt();
		System.out.println("Enter Score for player " + (player) + " Chance "+ (chance+1));
		int extra_points2 =0;
		extra_points2= in.nextInt();
		if(extra_points1==10)
			extra_points1+=10;
		int total_extra_points = extra_points1+extra_points2;
		if(total_extra_points == 10)
			total_extra_points+=5;
		return (total_extra_points);

	}


	public void update(int player,int first_hit,int second_hit,int bonus_points,int extra_points)//Update the score of previous frames as per the score of current frame in case of SPARE/STRIKE
	{
		System.out.println("********************************************************* ");
		System.out.println("Player " + (player) + " Score -  Chance 1 " + first_hit + " Chance2 " + second_hit);
		System.out.println("*********************************************************");
		Player p = Scores.get(player);
		int total_score = first_hit+second_hit+bonus_points+extra_points;
		if(p==null)
		{
			Player newplayer = new Player();
			newplayer.setScore(total_score);
			Scores.put(player,newplayer);

		}
		else
		{
			p.setScore((p.getScore()+total_score));
			Scores.put(player,p);
		}
		printScoreBoard();
	}

	public void printScoreBoard()
	{
		System.out.println("ScoreBoard:");
		for (Integer player: getScores().keySet()){
			Player p = getScores().get(player);
			System.out.println("P" + (player.intValue()) + " " +  (p.getScore()) );
		}
	}

}
