package com.example.raymond.tour.pro.logic;

import java.util.ArrayList;

public class GolfTournament {
	
	// Fundamenta scoring mode
	static final int STROKE_TOUR = 1;
	static final int POINTS_TOUR = 2;
	static final int STROKE_TOUR_MATCH = 3;
	static final int POINTS_TOUR_MATCH = 4;
	
	// Game mode
	static final int INDIVIDUAL = 1;
	static final int BEST_BALL  = 2;
	static final int FOUR_SOME  = 3;
	static final int GREEN_SOME = 4;
	static final int BLOOD_SOME = 5;
	static final int SCRAMBLE	= 6;
	static final int KOBENHAGEN = 7;
	
	
	
	private int gID = 0;
	private int gCourceId;
	private int gNrOfPlayers = 0;
	private int gNrOfTeams = 0;
	private boolean gIndividualCLS3 = false;
	private boolean gHandicaped = true;
	private int gTourMode = STROKE_TOUR;
	private int gTourGame = INDIVIDUAL;
	private String gTournamentName = "";
	private int gNrOfHoles = 18;
	
	private int gStakesWinn = 0;
	private int gStakesClosest = 0;
	private int gStakesLongest = 0;
	private int gStakesOnePut = 0;
	private int gStakesSnake = 0;
	private int gPurse = 0;
	private String gImgUrl;
	
	
	private ArrayList<GolfPlayer> gTournamentPlayers = null;
			
	public GolfTournament(int id)
	{
		gID = id;
		gTournamentPlayers = new ArrayList<GolfPlayer>();
	}
	
	public int getTournamentID(){
		return gID;
	}
	
	public void setPlayer(GolfPlayer player)
	{
		gTournamentPlayers.add(player);
	}	
	
	public void setInividualCLS3(boolean bool)
	{
		gIndividualCLS3 = bool;
	}
	
	public void setStakes(int win, int closest, int longest, int snake, int onePut)
	{
		gStakesWinn = win;
		gStakesClosest = closest;
		gStakesLongest = longest;
		gStakesOnePut = onePut;
		gStakesSnake = snake;
	}
	
	public void setTouramentName(String name)
	{
		gTournamentName = name;
	}
	
	public void setTournamentGame(int game)
	{
		gTourGame = game;
	}
	
	public void setTournamentMode(int mode)
	{
		gTourMode = mode;
	}

	public String getTournamentName() 
	{
		return gTournamentName;
	}

	public int getTournamentNrHoles() 
	{
		return gNrOfHoles;
	}

	public int getTournamentMode() 
	{
		return gTourMode;
	}

	public int getTournamentGame()
	{
		return gTourGame;	
	}

	public boolean getTournamentHandicaped() 
	{
		return gHandicaped;
	}

	public boolean getTournamentIndivdualCLS3() 
	{
		return gIndividualCLS3;
	}

	public int getTournamentNrOfPlayers() 
	{
		return gNrOfPlayers;
	}

	public int getTournametNrOfTeams()
	{
		return gNrOfTeams;
	}

	public int getTournamentStakes() 
	{
		return gStakesWinn;
	}

	public int getTournamentClosestStakes() 
	{
		return gStakesClosest;
	}

	public int getTournamentLongestStakes() 
	{
		return gStakesLongest;
	}

	public int getTournamentSnakeStakes() 
	{
		return gStakesSnake;
	}

	public int getTournament1PutStakes()
	{
		return gStakesOnePut;
	}

	public int getTournamentSponsorPurse() 
	{
		return gPurse;
	}

	public String getTournamentImgUrl() 
	{
		return gImgUrl;
	}

	public void setTournamentGolfCourceID(int courceid) 
	{
		gCourceId = courceid;
	}

	public void setTournamentNrOfHoles(int nrOfHoles) 
	{
		gNrOfHoles = nrOfHoles;
	}

	public void setTournamentHandicapped(int handicaped) 
	{
		gHandicaped = (handicaped == 1);
	}

	public void setTournamentIndividualCLS1(int indCLS1) 
	{
		gIndividualCLS3 = (indCLS1 == 1);
	}

	public void setTournamentNrOfPlayers(int players) 
	{
		gNrOfPlayers = players;
	}

	public void setTournamentNrOfTeams(int teams) 
	{
		gNrOfTeams = teams;
		
	}

	public void setTournamentPurse(int purse) 
	{
		gPurse = purse;
	}

	public void setTournamentImgUrl(String imgUrl) 
	{
		gImgUrl = imgUrl;
	}
	
	
	
	
	
	
	
}
