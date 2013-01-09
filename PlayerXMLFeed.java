package com.example.raymond.tour.pro.logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class PlayerXMLFeed {
	private static final String ns = null;
	private static XmlPullParser parser;
	private static ArrayList<GolfPlayer> entries;
	
	
	public static ArrayList<GolfPlayer> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser(); 
	        entries = new ArrayList<GolfPlayer>();
            
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readPlayerFeed();
        } finally {
            in.close();
        }
	}
        
     private static ArrayList<GolfPlayer> readPlayerFeed() throws XmlPullParserException, IOException{
    	 parser.require(XmlPullParser.START_TAG, ns, "playerfeed");
    	 while(!(parser.getEventType() == XmlPullParser.END_TAG && parser.getName().equals("playerfeed"))){
	        switch (parser.next()){
	        	case XmlPullParser.END_TAG:
	        		break;
	        	case XmlPullParser.START_TAG:
	        		if(parser.getName().equals("player")){
	        			entries.add(readPlayer());
	        		} 	
	        		        	
	        	}
	        }

	        
	        return entries;
	 }
    	 
   
     private static GolfPlayer readPlayer() throws XmlPullParserException, IOException {
 		parser.require(XmlPullParser.START_TAG, ns, "player");
        
 		
 		GolfPlayer player = new GolfPlayer(0);
 		 	    
 	    int iAttr = parser.getAttributeCount();
 	    for(int i = 0; i < iAttr;i++){
 	    	if(parser.getAttributeName(i).equals("name"))
 	    		player.setPlayerName(parser.getAttributeValue(i));
 	    	else if(parser.getAttributeName(i).equals("nick"))
 	    		player.setPlayerNick(parser.getAttributeValue(i));
 	    	else if(parser.getAttributeName(i).equals("totalWinnings"))
 	    		player.setPlayerWinnings(Integer.parseInt(parser.getAttributeValue(i)));
 	    	else if(parser.getAttributeName(i).equals("handicap"))
 	    		player.setPlayerHC(Double.parseDouble(parser.getAttributeValue(i)));
 	    	else if(parser.getAttributeName(i).equals("imgurl"))
 	    		player.setPlayerImg(parser.getAttributeValue(i));
 	    	else
 	    		continue;
 	    }
 	    
 	   return player;
 	}






}







