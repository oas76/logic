package com.example.raymond.tour.pro.logic;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TourDatabase extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;
 
    // Database Name
    private static final String DATABASE_NAME = "TourDatabase";
 
    // Tour table name
    private static final String TABLE_TOUR = "TourTable";
    
    // Common Collum Definition    
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
   // Tour Table Columns names
    private static final String KEY_TOUR_IMG = "TourImg";
    
    // Golf Tournament table name
    private static final String TABLE_GOLFTOURNAMENT = "GolfTournamentTable";
 
    // Golf Tournament Table Columns names
    private static final String KEY_COURCE_ID = "CourceId";
    private static final String KEY_GOLF_MODE = "GolfMode";
    private static final String KEY_GOLF_GAME = "GolfGame";
    private static final String KEY_HANDICAPED = "Handicaped";
    private static final String KEY_INDIVIDUAL_CLS3 = "IndividualCLS3";
	private static final String KEY_NR_PLAYER = "NumberOfPlayers";
	private static final String KEY_NR_TEAMS  = "NumberOfTeam";
	private static final String KEY_STAKES = "StakesWin";
	private static final String KEY_STAKES_CLOSEST = "StakesWinClosest";
	private static final String KEY_STAKES_LONGEST = "StakesWinLongest";
	private static final String KEY_STAKES_SNAKE = "StakesWinSnake";
	private static final String KEY_STAKES_1PUT = "StakesWin1Put";
	private static final String KEY_TOURNAMENT_IMGURL = "TournamentImageURL";
	private static final String KEY_TOURNAMENT_NRHOLES = "TournamentNrOfHoles";
	private static final String KEY_TOURNAMENT_SPONSOR_PURSE = "TournamentSponsorPurse";
	
    // Golf Tournament player table name
    private static final String TABLE_PLAYER_GOLFTOUR = "GolfPlayerTournamentTable";
    
    // Golf Tournament player Columns names
    private static final String KEY_TOURNAMNET_ID = "GolfTournamentId";
    private static final String KEY_TOURNAMENT_TEAM_ID = "TournamentTeamId"; 
    private static final String KEY_HOLE_1 = "Hole1Score";
    private static final String KEY_HOLE_2 = "Hole2Score";
    private static final String KEY_HOLE_3 = "Hole3Score";
    private static final String KEY_HOLE_4 = "Hole4Score";
    private static final String KEY_HOLE_5 = "Hole5Score";
    private static final String KEY_HOLE_6 = "Hole6Score";
    private static final String KEY_HOLE_7 = "Hole7Score";
    private static final String KEY_HOLE_8 = "Hole8Score";
    private static final String KEY_HOLE_9 = "Hole9Score";
    private static final String KEY_HOLE_10 = "Hole10Score";
    private static final String KEY_HOLE_11 = "Hole11Score";
    private static final String KEY_HOLE_12 = "Hole12Score";
    private static final String KEY_HOLE_13 = "Hole13Score";
    private static final String KEY_HOLE_14 = "Hole14Score";
    private static final String KEY_HOLE_15 = "Hole15Score";
    private static final String KEY_HOLE_16 = "Hole16Score";
    private static final String KEY_HOLE_17 = "Hole17Score";
    private static final String KEY_HOLE_18 = "Hole18Score";
        
    // Golf Cource table name
    private static final String TABLE_GOLFCOURCE = "GolfCourceTable";
    
    // Golf Cource Column names
	private static final String KEY_COURCE_TEE = "GolfCourceTee";
	private static final String KEY_COURCE_SLOPE = "GolfCourceSlope";
	private static final String KEY_COURCE_VALUE = "GolfCourceValue";
	private static final String KEY_COURCE_PAR = "GolfCourcePar";
	private static final String KEY_COURCE_LENGTH = "GolfCourceLength";
	
	// Golf Hole table name
	private static final String TABLE_GOLFHOLE = "GolfHoleTable";
	
	// Golf Hole Column name
	private static final String KEY_HOLE_NR = "GolfHoleNr";
	private static final String KEY_HOLE_PAR = "GolfHolePar";
	private static final String KEY_HOLE_INDEX = "GolfHoleIndex";
	private static final String KEY_HOLE_LENGTH = "GolfHoleLength";
	private static final String KEY_HOLE_NAME = "GolfHoleName";
	

       
    // Golf Player table name
    private static final String TABLE_GOLFPLAYER = "GolfPlayerTable";
 
    // Golf Player Table Columns names
    private static final String KEY_PLAYER_NIC = "PlayerNic";
    private static final String KEY_PLAYER_HC = "PlayerHc";
    private static final String KEY_PLAYER_WINNINGS = "PlayerWinnings";
    private static final String KEY_PLAYER_IMGURL = "PlayerImgUrl"; 
    private static final String KEY_PLAYER_ID = "PlayerId";
	
	public TourDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TOUR_DB = "CREATE TABLE " + TABLE_TOUR + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_TOUR_IMG + " TEXT)";
		String CREATE_PLAYER_DB = "CREATE TABLE " + TABLE_GOLFPLAYER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PLAYER_NIC + " TEXT," + KEY_PLAYER_HC + " REAL," + KEY_PLAYER_IMGURL + " TEXT," + KEY_PLAYER_WINNINGS + " INTEGER)";
		String CREATE_COURCE_DB = "CREATE TABLE " + TABLE_GOLFCOURCE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_COURCE_TEE + " TEXT," + KEY_COURCE_PAR + " INTEGER," + KEY_COURCE_SLOPE + " INTEGER," + KEY_COURCE_VALUE + " REAL," + KEY_COURCE_LENGTH + " INTEGER)";
		String CREATE_HOLE_DB = "CREATE TABLE " + TABLE_GOLFHOLE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COURCE_ID + " INTEGER," + KEY_HOLE_NR + " INTEGER," + KEY_HOLE_PAR + " INTEGER," + KEY_HOLE_INDEX + " INTEGER," + KEY_HOLE_LENGTH + " INTEGER," + KEY_HOLE_NAME + " TEXT)";
		String CREATE_TOURNAMENT_DB = "CREATE TABLE " + TABLE_GOLFTOURNAMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_COURCE_ID + " INTEGER, " + KEY_TOURNAMENT_NRHOLES + " INTEGER," + KEY_GOLF_MODE + " INTEGER," + KEY_GOLF_GAME + " INTEGER," + KEY_HANDICAPED + " INTEGER," + KEY_INDIVIDUAL_CLS3 + " INTEGER," + KEY_NR_PLAYER + " INTEGER," + KEY_NR_TEAMS + " INTEGER," + KEY_STAKES + " INTEGER," + KEY_STAKES_CLOSEST + " INTEGER," + KEY_STAKES_LONGEST + " INTEGER," + KEY_STAKES_SNAKE + " INTEGER," + KEY_STAKES_1PUT + " INTEGER," + KEY_TOURNAMENT_SPONSOR_PURSE + "INTEGER, " + KEY_TOURNAMENT_IMGURL + " TEXT)"; 
		String CREATE_TOURNAMENT_PLAYER_DB = "CREATE TABLE " + TABLE_PLAYER_GOLFTOUR + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PLAYER_ID + " INTEGER," + KEY_TOURNAMNET_ID + " INTEGER," + KEY_TOURNAMENT_TEAM_ID + " INTEGER," + KEY_HOLE_1 + " INTEGER," + KEY_HOLE_2 + " INTEGER," + KEY_HOLE_3 + " INTEGER," + KEY_HOLE_4 + " INTEGER," + KEY_HOLE_5 + " INTEGER," + KEY_HOLE_6 + " INTEGER," + KEY_HOLE_7 + " INTEGER," + KEY_HOLE_8 + " INTEGER," + KEY_HOLE_9 + " INTEGER," + KEY_HOLE_10 + " INTEGER," + KEY_HOLE_11 + " INTEGER," + KEY_HOLE_12 + " INTEGER," + KEY_HOLE_13 + " INTEGER," + KEY_HOLE_14 + " INTEGER," + KEY_HOLE_15 + " INTEGER," + KEY_HOLE_16 + " INTEGER," + KEY_HOLE_17 + " INTEGER," + KEY_HOLE_18 + " INTEGER)";
	
	
		db.execSQL(CREATE_TOUR_DB);
		db.execSQL(CREATE_PLAYER_DB);
		db.execSQL(CREATE_COURCE_DB);
		db.execSQL(CREATE_HOLE_DB);
		db.execSQL(CREATE_TOURNAMENT_DB);
		db.execSQL(CREATE_TOURNAMENT_PLAYER_DB);
	
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		// Will not drop
	}
	
	// Adding new Tour
	public void addTour(Tour tour) {
		  SQLiteDatabase db = this.getWritableDatabase();
		  
		  ContentValues values = new ContentValues();
		  values.put(KEY_NAME, tour.getTourName());
		  values.put(KEY_TOUR_IMG, tour.getImgUrl()); 
		 
		    // Inserting Row
		  db.insert(TABLE_TOUR, null, values);
		  db.close(); // Closing database connection
	}
	
	public void addPlayer(GolfPlayer player)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		  
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, player.getPlayerName());
		values.put(KEY_PLAYER_NIC, player.getNick());
		values.put(KEY_PLAYER_HC, player.getPlayerHC());
		values.put(KEY_PLAYER_IMGURL, player.getImgUrl());
		values.put(KEY_PLAYER_WINNINGS, player.getPlayerWinnings());
		 
		    // Inserting Row
		db.insert(TABLE_GOLFPLAYER, null, values);
		db.close(); // Closing database connection
		
	}
	
	public void addCource(GolfCource cource){
		SQLiteDatabase db = this.getWritableDatabase();
		  
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, cource.getCourceName());
		values.put(KEY_COURCE_TEE, cource.getCourceTee());
		values.put(KEY_COURCE_PAR, cource.getCourcePar());
		values.put(KEY_COURCE_SLOPE, cource.getCourceSlope());
		values.put(KEY_COURCE_VALUE, cource.getCourceValue());
		values.put(KEY_COURCE_LENGTH, cource.getCourceLength());
		 
		    // Inserting Row
		long rowId = db.insert(TABLE_GOLFCOURCE, null, values);
		if(rowId != -1)
		{
			for(int i= 1; i <= 18; i++)
			{
				values = new ContentValues();
				values.put(KEY_COURCE_ID, rowId);
				values.put(KEY_HOLE_NR, i);
				values.put(KEY_HOLE_PAR,cource.getHolePar(i));
				values.put(KEY_HOLE_INDEX, cource.getHoleIndex(i));
				values.put(KEY_HOLE_LENGTH, cource.getHoleLength(i));
				values.put(KEY_HOLE_NAME, cource.getHoleName(i));
				db.insert(TABLE_GOLFHOLE, null, values);
			}
		}
		
		
		db.close(); // Closing database connection
	}
	
	public void addTournament(GolfTournament tournament, GolfCource cource){
		SQLiteDatabase db = this.getWritableDatabase();
		  
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, tournament.getTournamentName());
		values.put(KEY_COURCE_ID, cource.getCourceID());
		values.put(KEY_TOURNAMENT_NRHOLES, tournament.getTournamentNrHoles());
		values.put(KEY_GOLF_MODE, tournament.getTournamentMode());
		values.put(KEY_GOLF_GAME, tournament.getTournamentGame());
		values.put(KEY_HANDICAPED, tournament.getTournamentHandicaped());
		values.put(KEY_INDIVIDUAL_CLS3, tournament.getTournamentIndivdualCLS3());
		values.put(KEY_NR_PLAYER, tournament.getTournamentNrOfPlayers());
		values.put(KEY_NR_TEAMS, tournament.getTournametNrOfTeams());
		values.put(KEY_STAKES, tournament.getTournamentStakes());
		values.put(KEY_STAKES_CLOSEST, tournament.getTournamentClosestStakes());
		values.put(KEY_STAKES_LONGEST, tournament.getTournamentLongestStakes());
		values.put(KEY_STAKES_SNAKE, tournament.getTournamentSnakeStakes());
		values.put(KEY_STAKES_1PUT, tournament.getTournament1PutStakes());
		values.put(KEY_TOURNAMENT_SPONSOR_PURSE, tournament.getTournamentSponsorPurse());
		values.put(KEY_TOURNAMENT_IMGURL, tournament.getTournamentImgUrl()); 
			
	    // Inserting Row
		db.insert(TABLE_GOLFTOURNAMENT, null, values);
		db.close(); // Closing database connection
		
	}
	
	public void addTournamentPlayer(GolfPlayer player, GolfTournament tournament)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		  
		ContentValues values = new ContentValues();
		values.put(KEY_PLAYER_ID, player.getPlayerID());
		values.put(KEY_TOURNAMNET_ID, tournament.getTournamentID());
		values.put(KEY_TOURNAMENT_TEAM_ID, player.getTeamIndex());
		values.put(KEY_HOLE_1, player.getStroke(1));
		values.put(KEY_HOLE_2, player.getStroke(2));
		values.put(KEY_HOLE_3, player.getStroke(3));
		values.put(KEY_HOLE_4, player.getStroke(4));
		values.put(KEY_HOLE_5, player.getStroke(5));
		values.put(KEY_HOLE_6, player.getStroke(6));
		values.put(KEY_HOLE_7, player.getStroke(7));
		values.put(KEY_HOLE_8, player.getStroke(8));
		values.put(KEY_HOLE_9, player.getStroke(9));
		values.put(KEY_HOLE_10, player.getStroke(10));
		values.put(KEY_HOLE_11, player.getStroke(11));
		values.put(KEY_HOLE_12, player.getStroke(12));
		values.put(KEY_HOLE_13, player.getStroke(13));
		values.put(KEY_HOLE_14, player.getStroke(14));
		values.put(KEY_HOLE_15, player.getStroke(15));
		values.put(KEY_HOLE_16, player.getStroke(16));
		values.put(KEY_HOLE_17, player.getStroke(17));
		values.put(KEY_HOLE_18, player.getStroke(18));

		// Inserting Row
		db.insert(TABLE_PLAYER_GOLFTOUR, null, values);
		db.close(); // Closing database connection
		
	}
	 
	// Getting single Tour
	public Tour getTour(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query(TABLE_TOUR, new String[] { KEY_ID,
	            KEY_NAME, KEY_TOUR_IMG }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    Tour tour = new Tour(Integer.parseInt(cursor.getString(0)));
	    tour.setTourName(cursor.getString(1));
	    tour.setImgUrl(cursor.getString(2));
	    // return contact
	    return tour;
	}
	
	public GolfPlayer getGolfPlayer(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query(TABLE_GOLFPLAYER, new String[] { KEY_ID,
	            KEY_NAME, KEY_PLAYER_NIC, KEY_PLAYER_HC, KEY_PLAYER_IMGURL ,KEY_PLAYER_WINNINGS  }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    GolfPlayer golfPlayer = new GolfPlayer(Integer.parseInt(cursor.getString(0)));
	    golfPlayer.setPlayerName(cursor.getString(1));
	    golfPlayer.setPlayerNick(cursor.getString(2));
	    golfPlayer.setPlayerHC(Double.parseDouble(cursor.getString(3)));
	    golfPlayer.setPlayerImg(cursor.getString(4));
	    golfPlayer.setPlayerWinnings(Integer.parseInt(cursor.getString(5)));
	    
	    return golfPlayer;
	}

	public GolfCource getGolfCource(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query(TABLE_GOLFCOURCE, new String[] { KEY_ID, KEY_NAME, KEY_COURCE_TEE, KEY_COURCE_PAR,  KEY_COURCE_SLOPE, KEY_COURCE_VALUE, KEY_COURCE_LENGTH }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    GolfCource golfCource = new GolfCource(Integer.parseInt(cursor.getString(0)));
	    golfCource.setCourceName(cursor.getString(1));
	    golfCource.setCourceTee(cursor.getString(2));
	    golfCource.setCourcePar(Integer.parseInt(cursor.getString(3)));
	    golfCource.setCourceSlope(Integer.parseInt(cursor.getString(4)));
	    golfCource.setCourceValue(Double.parseDouble(cursor.getString(5)));
	    golfCource.setCourceLength(Integer.parseInt(cursor.getString(6)));
	    
	    cursor = db.query(TABLE_GOLFHOLE, new String[] {KEY_ID, KEY_COURCE_ID, KEY_HOLE_NR, KEY_HOLE_PAR, KEY_HOLE_INDEX, KEY_HOLE_LENGTH, KEY_HOLE_NAME }, KEY_COURCE_ID + "=?",
	    		new String[] { String.valueOf(id) },null, null, null, null);
	    if(cursor != null)
	    {
	    	cursor.moveToFirst();
	    	do
	    	{
	    		int hole = Integer.parseInt(cursor.getString(2));
	    		golfCource.setHolePar(hole, Integer.parseInt(cursor.getString(3)));
	    		golfCource.setHoleIndex(hole,Integer.parseInt(cursor.getString(4)));
	    		golfCource.setHoleLength(hole,Integer.parseInt(cursor.getString(5)));
	    		golfCource.setHoleName(hole, cursor.getString(6));
	    	}
	    	while(cursor.moveToNext());

	    }
	    
	    // return contact
	    return golfCource;
	}
	
	public GolfTournament getGolfTournament(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query(TABLE_GOLFTOURNAMENT, new String[] { KEY_ID, KEY_NAME, KEY_COURCE_ID, KEY_TOURNAMENT_NRHOLES, KEY_GOLF_MODE, KEY_GOLF_GAME, KEY_HANDICAPED, KEY_INDIVIDUAL_CLS3, KEY_NR_PLAYER, KEY_NR_TEAMS, KEY_STAKES, KEY_STAKES_CLOSEST, KEY_STAKES_LONGEST, KEY_STAKES_SNAKE, KEY_STAKES_1PUT, KEY_TOURNAMENT_SPONSOR_PURSE, KEY_TOURNAMENT_IMGURL}, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    GolfTournament golfTournament = new GolfTournament(Integer.parseInt(cursor.getString(0)));
	    golfTournament.setTouramentName(cursor.getString(1));
	    golfTournament.setTournamentGolfCourceID(Integer.parseInt(cursor.getString(2)));
	    golfTournament.setTournamentNrOfHoles(Integer.parseInt(cursor.getString(3)));
	    golfTournament.setTournamentMode(Integer.parseInt(cursor.getString(4)));
	    golfTournament.setTournamentGame(Integer.parseInt(cursor.getString(5)));
	    golfTournament.setTournamentHandicapped(Integer.parseInt(cursor.getString(6)));
	    golfTournament.setTournamentIndividualCLS1(Integer.parseInt(cursor.getString(7)));
	    golfTournament.setTournamentNrOfPlayers(Integer.parseInt(cursor.getString(8)));
	    golfTournament.setTournamentNrOfTeams(Integer.parseInt(cursor.getString(9)));
	    golfTournament.setStakes(Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)));
	    golfTournament.setTournamentPurse(Integer.parseInt(cursor.getString(15)));
	    golfTournament.setTournamentImgUrl(cursor.getString(16));
	    
	    return golfTournament;
	}
	
	
	 
	// Getting All Tours
	public List<Tour> getAllTours() {
		List<Tour> tourList = new ArrayList<Tour>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_TOUR;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Tour tour = new Tour(Integer.parseInt(cursor.getString(0)));
	            tour.setTourName(cursor.getString(1));
	            tour.setImgUrl(cursor.getString(2));
	            // Adding contact to list
	            tourList.add(tour);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return tourList;
	}
	
	public List<GolfPlayer> getAllPlayers() {
		
		List<GolfPlayer> playerList = new ArrayList<GolfPlayer>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_GOLFPLAYER;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            GolfPlayer golfPlayer = new GolfPlayer(Integer.parseInt(cursor.getString(0)));
	    	    golfPlayer.setPlayerName(cursor.getString(1));
	    	    golfPlayer.setPlayerNick(cursor.getString(2));
	    	    golfPlayer.setPlayerHC(Double.parseDouble(cursor.getString(3)));
	    	    golfPlayer.setPlayerImg(cursor.getString(4));
	    	    golfPlayer.setPlayerWinnings(Integer.parseInt(cursor.getString(5)));
	    	    playerList.add(golfPlayer);
	            
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return playerList;
	}
	
	public List<GolfCource> getAllCources() {
		
		List<GolfCource> courceList = new ArrayList<GolfCource>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_GOLFCOURCE;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
		 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            GolfCource golfCource = new GolfCource(Integer.parseInt(cursor.getString(0)));
	    	    golfCource.setCourceName(cursor.getString(1));
	    	    golfCource.setCourceTee(cursor.getString(2));
	    	    golfCource.setCourcePar(Integer.parseInt(cursor.getString(3)));
	    	    golfCource.setCourceSlope(Integer.parseInt(cursor.getString(4)));
	    	    golfCource.setCourceValue(Double.parseDouble(cursor.getString(5)));
	    	    golfCource.setCourceLength(Integer.parseInt(cursor.getString(6)));
	    	    
	    	    Cursor cursor2 = db.query(TABLE_GOLFHOLE, new String[] {KEY_ID, KEY_COURCE_ID, KEY_HOLE_NR, KEY_HOLE_PAR, KEY_HOLE_INDEX, KEY_HOLE_LENGTH, KEY_HOLE_NAME }, KEY_COURCE_ID + "=?",
	    	    		new String[] { String.valueOf(Integer.parseInt(cursor.getString(0))) },null, null, null, null);
	    	    if(cursor2 != null)
	    	    {
	    	    	cursor2.moveToFirst();
	    	    	do
	    	    	{
	    	    		int hole = Integer.parseInt(cursor2.getString(2));
	    	    		golfCource.setHolePar(hole, Integer.parseInt(cursor2.getString(3)));
	    	    		golfCource.setHoleIndex(hole,Integer.parseInt(cursor2.getString(4)));
	    	    		golfCource.setHoleLength(hole,Integer.parseInt(cursor2.getString(5)));
	    	    		golfCource.setHoleName(hole, cursor2.getString(6));
	    	    	}
	    	    	while(cursor2.moveToNext());
	    	    }
	    	    courceList.add(golfCource);
 	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return courceList;
	}

	 
	// Getting Tour Count
	public int getTourCount() {
		String countQuery = "SELECT  * FROM " + TABLE_TOUR;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
	}
	
	// Getting Tour Count
	public int getCourceCount() {
		String countQuery = "SELECT  * FROM " + TABLE_GOLFCOURCE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
	}
	
	
	// Updating single Tour
	public int updateTour(Tour tour) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, tour.getTourName());
	    values.put(KEY_TOUR_IMG, tour.getImgUrl());
	 
	    // updating row
	    return db.update(TABLE_TOUR, values, KEY_ID + " = ?",
	            new String[] { String.valueOf(tour.getID()) });
	}
	 
	// Deleting single Tour
	public void deleteTour(Tour tour) {
		SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_TOUR, KEY_ID + " = ?",
	            new String[] { String.valueOf(tour.getID()) });
	    db.close();
	}
	
	
	





}
