package com.example.raymond.tour.pro.logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class CourceXMLFeed  {
	
	
	 private static final String ns = null;
	 private static XmlPullParser parser;
	 private static ArrayList<GolfCource> entries;
	 private static int[] holeindex = new int[18];
	 private static int[] holepar   = new int[18];
	 private static int[] holelength = new int[18];
	 private static ArrayList<String> holename = null;
	 
	 
	 public static ArrayList<GolfCource> parse(InputStream in) throws XmlPullParserException, IOException {
	        try {
	            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	            factory.setNamespaceAware(true);
	            parser = factory.newPullParser(); 
		        entries = new ArrayList<GolfCource>();
		        holename = new ArrayList<String>();
	            
	            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            parser.setInput(in, null);
	            parser.nextTag();
	            return readCourceFeed();
	        } finally {
	            in.close();
	        }
	 }
	 
	 private static ArrayList<GolfCource> readCourceFeed() throws XmlPullParserException, IOException {
	        parser.require(XmlPullParser.START_TAG, ns, "courcefeed");

	        
	        while(!(parser.getEventType() == XmlPullParser.END_TAG && parser.getName().equals("courcefeed"))){
	        	switch (parser.next())
	        	{
	        	case XmlPullParser.END_TAG:
	        		if(parser.getName().equals("cource"))
	        		{
	        	        entries.get(entries.size()-1).setCourceHoleIndex(holeindex);
	        	        entries.get(entries.size()-1).setCourceHoleLength(holelength);
	        	        entries.get(entries.size()-1).setCourceHolePar(holepar);
	        	        entries.get(entries.size()-1).setCourceHoleNames(holename);
	        		}
	        		break;
	        	case XmlPullParser.START_TAG:
	        		if(parser.getName().equals("cource"))
	        		{
	        			entries.add(readCource());
	        		} 	
	        		else if(parser.getName().equals("hole"))
	        		{
	        			readHoles();
	        		}
	        	
	        	}
	        }

	        
	        return entries;
	 }

	 // Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
	// to their respective "read" methods for processing. Otherwise, skips the tag.
	private static GolfCource readCource() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "cource");
          
	    GolfCource cource = new GolfCource(0);
	    

	    
	    int iAttr = parser.getAttributeCount();
	    for(int i = 0; i < iAttr;i++){
	    	if(parser.getAttributeName(i).equals("name"))
	    		cource.setCourceName(parser.getAttributeValue(i));
	    	else if(parser.getAttributeName(i).equals("tee"))
	    		cource.setCourceTee(parser.getAttributeValue(i));
	    	else if(parser.getAttributeName(i).equals("par"))
	    		cource.setCourcePar(Integer.parseInt(parser.getAttributeValue(i)));
	    	else if(parser.getAttributeName(i).equals("slope"))
	    		cource.setCourceSlope(Integer.parseInt(parser.getAttributeValue(i)));
	    	else if(parser.getAttributeName(i).equals("holes"))
	    		cource.setNrOfHoles(Integer.parseInt(parser.getAttributeValue(i)));
	    	else if(parser.getAttributeName(i).equals("value"))
	    		cource.setCourceValue(Double.parseDouble(parser.getAttributeValue(i)));
	    	else if(parser.getAttributeName(i).equals("length"))
	    		cource.setCourceLength(Integer.parseInt(parser.getAttributeValue(i)));
	    	else
	    		continue;
	    }
	    

	    return cource;    
	    
	    
	}
	
	private static void readHoles() throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "hole");
	    int holenumber = Integer.parseInt(parser.getAttributeValue(null, "nr"));
        if(holenumber > 0 && holenumber <= 18){
        	holeindex[holenumber-1] = Integer.parseInt(parser.getAttributeValue(null, "index"));
        	holepar[holenumber-1] = Integer.parseInt(parser.getAttributeValue(null, "par"));
        	holelength[holenumber-1] = Integer.parseInt(parser.getAttributeValue(null, "length"));
        	holename.add(parser.getAttributeValue(null, "name"));
        }
       
	}
		
}
