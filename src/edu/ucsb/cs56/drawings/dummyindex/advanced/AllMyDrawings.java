package edu.ucsb.cs56.drawings.dummyindex.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phil Conrad and DummyIndex
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few BILIBILI ICONS
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
        TVSkeleton h1 = new TVSkeleton(100,250,75,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two houses with Windows
	
	BilibiliTV hw1 = new BilibiliTV(50,350,250,250);
	BilibiliTV hw2 = new BilibiliTV(200,350,100,100);
	
	//g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("BILIBILI FACES BY DUMMYINDEX", 20,20);
    }
    
    
    /** Draw a picture with a few BILIBILI TV
     */
    public static void drawPicture2(Graphics2D g2) {
	
	
	BilibiliTV large = new BilibiliTV(100,50,225,150);
	BilibiliTV smallCC = new BilibiliTV(20,50,40,30);
	BilibiliTV tallSkinny = new BilibiliTV(20,150,20,40);
	BilibiliTV shortFat = new BilibiliTV(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	BilibiliTV h1 = new BilibiliTV(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
        
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	
	BilibiliTV hw1 = new BilibiliTV(50,350,40,75);
	BilibiliTV hw2 = new BilibiliTV(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of BILIBILITV by DUMMYINDEX", 20,20);
    }
    
    /** Draw a different picture with a few BILIBILI TV FACES
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of BILIBILITV by DUMMYINDEX", 20,20);
	
	
	// Draw some coffee cups.
	
	BilibiliTV large = new BilibiliTV(100,50,225,150);
	BilibiliTV smallCC = new BilibiliTV(100,200,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
