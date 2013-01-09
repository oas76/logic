package com.example.raymond.tour.pro.logic;

import java.util.Arrays;
import java.util.ArrayList;

public class GolfTeam {
	private final static int STROKE=0;
	private final static int SCORE=1;
	

	public GolfTeam()
	{

	}
	
	
	public int getTeamHandicap(ArrayList<GolfPlayer> golfPlayers)
	{
		
		int[] boostedHandicap = new int[golfPlayers.size()];
		double tempHC = 0;
		double restHC = 0;
		int counter = 0;
		
		for (GolfPlayer player : golfPlayers) {
			boostedHandicap[counter] = player.getPlayerBoostedHandicap();
			counter++;
		}
			
		Arrays.sort(boostedHandicap);
		
		if(boostedHandicap.length > 1)
		{
			tempHC = ((double)boostedHandicap[0])*0.75;
			for(int y = 1; y < boostedHandicap.length;y++)
			{
				restHC += boostedHandicap[y];
			}
			restHC = (restHC/((double)(boostedHandicap.length-1)))*0.25;
			tempHC += restHC;
			
		}
		else if(boostedHandicap.length == 1)
			tempHC = boostedHandicap[0];
		
		return (int)(tempHC + 0.5);
		
	}
	
	

	public int getTeamStroke(int hole, ArrayList<GolfPlayer> players, GolfCource cource)
	{

		int lowScore = 100;
		for(GolfPlayer golfPlayer : players){
			lowScore = Math.min(lowScore, golfPlayer.getStroke(hole));
		}
		return lowScore;

	}
	
	public int getTeamHCScore(int hole, ArrayList<GolfPlayer> players, GolfCource cource)
	{
		int tempHC = this.getTeamHandicap(players);
		int lowScore = 100;
		for(GolfPlayer golfPlayer : players){
			golfPlayer.setTeamScore(hole, golfPlayer.getStroke(hole), cource, tempHC);
			lowScore = Math.min(lowScore, golfPlayer.getTeamScore(hole));
		}
		return lowScore;

	}
	
	public int getTeamHCPoints(int hole, ArrayList<GolfPlayer> players, GolfCource cource)
	{
		int tempHC = getTeamHandicap(players);
		int highPoint = 0;
		
		for(GolfPlayer golfPlayer : players){
			golfPlayer.setTeamPoints(hole, golfPlayer.getStroke(hole), cource, tempHC);
			highPoint = Math.max(highPoint, golfPlayer.getTeamPoints(hole));
		}
		return highPoint;
		

	}
	
	
	
	

}
