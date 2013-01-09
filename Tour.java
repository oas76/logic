package com.example.raymond.tour.pro.logic;

public class Tour {
	
	private String tName;
	private String tImgUrl = "";
	private int tID;
	
	public Tour(int ID, String name, String imgurl)
	{
		tID = ID;
		tName = name;
		tImgUrl = imgurl;
	}
	
	public Tour(int id)
	{
		tID = id;
	}
	
	
	public String getTourName(){
		return tName;
	}
	
	public String getImgUrl(){
		return tImgUrl;
	}
	
	public int getID(){
		return tID;
	}
	
	public void setTourID(int ID)
	{
		tID = ID;
	}
	
	public void setTourName(String name)
	{
		tName = name;
	}
	
	public void setImgUrl(String url)
	{
		tImgUrl = url;
	}
	
	
	
	
	
}
