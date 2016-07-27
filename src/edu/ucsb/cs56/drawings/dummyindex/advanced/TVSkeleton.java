package edu.ucsb.cs56.drawings.dummyindex.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;


/**
   A bilibili TV Skeleton
   @author DummyIndex
   @version for CS56, M16, UCSB

 */
public class TVSkeleton extends GeneralPathWrapper implements Shape
{   
    
    /**
     * return a square general path. input upper left coordinate
     */
    private GeneralPath draw_square(double x , double y , double width, double height){
	GeneralPath TV_square = new GeneralPath();
	TV_square.moveTo( x, y );
	TV_square.lineTo( x + width , y );
	TV_square.lineTo( x + width , y + height );
	TV_square.lineTo( x , y + height );
	TV_square.lineTo( x , y );	
	TV_square.moveTo( x + width, y + height );
	return TV_square;
    }


    /**
     * Constructor for objects of class TVSkeleton
     */
    public TVSkeleton(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* coffee cup
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
        
	final double BIGGER_X = 110;
	final double BIGGER_Y = 110;
	final double SIDE_HEIGHT = 300;
	final double SIDE_WIDTH = 500;	
	
        GeneralPath bigger_square =draw_square( BIGGER_X, BIGGER_Y, SIDE_WIDTH, SIDE_HEIGHT);
	////////////////////////////////////////
	// prepare for smaller sqquare
	final double SCALE = 0.8;
	final double SMALLER_WIDTH = SCALE * SIDE_WIDTH;
	final double SMALLER_HEIGHT = SCALE * SIDE_HEIGHT;
	final double SMALLER_X = BIGGER_X + ( SIDE_WIDTH - SMALLER_WIDTH) / 2;
	final double SMALLER_Y = BIGGER_Y + ( SIDE_HEIGHT - SMALLER_HEIGHT) / 2;
	//////////////////////////////////////////////////
	//prepare for 2 antenna
	final double ANT_X = BIGGER_X + (SIDE_WIDTH ) / 2 ;
	final double ANT_Y = BIGGER_Y ;
	final double ANT_OFFSET_X = 150;
	final double ANT_OFFSET_Y = -150;

	//THE DIFFERENCE BETWEEN 2 ANTENNA
	final double DIFF_Y = 40;
	final double DIFF_X = 40;
	
	final double X_INTERVAL = 50;
	final double LEFT_X = ANT_X - X_INTERVAL;
	final double RIGHT_X = ANT_X + X_INTERVAL;
	GeneralPath Ants = new GeneralPath();
	
	//RIGHTSIDE
	Ants.moveTo( RIGHT_X, ANT_Y );
	Ants.lineTo( RIGHT_X + ANT_OFFSET_X - DIFF_X , ANT_Y + ANT_OFFSET_Y - DIFF_Y );

	//LEFT SIDE SHOULD
	Ants.moveTo( LEFT_X, ANT_Y );
	Ants.lineTo( LEFT_X - ANT_OFFSET_X - DIFF_X , ANT_Y + ANT_OFFSET_Y + DIFF_Y );
	
	//////////////////////////////////////////////////
	GeneralPath smaller_square = draw_square( SMALLER_X, SMALLER_Y, SMALLER_WIDTH, SMALLER_HEIGHT );
	
	GeneralPath wholeSkeleton = new GeneralPath();
	wholeSkeleton.append( bigger_square, false);
	wholeSkeleton.append( smaller_square, false);	
	wholeSkeleton.append( Ants, false);	
	tv_skeleton = wholeSkeleton;

        Shape s = ShapeTransforms.translatedCopyOf(wholeSkeleton, -ORIG_ULX + x, -ORIG_ULY + y);
	
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	//this.set( wholeSkeleton );
	this.set(new GeneralPath(s));
        
    }
    protected GeneralPath tv_skeleton;
}
