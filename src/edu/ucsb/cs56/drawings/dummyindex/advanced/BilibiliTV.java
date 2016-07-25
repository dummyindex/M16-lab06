package edu.ucsb.cs56.drawings.dummyindex.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;

/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class BilibiliTV extends TVSkeleton implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public BilibiliTV(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
        
	final double BIGGER_X = 110;
	final double BIGGER_Y = 110;
	final double SIDE_HEIGHT = 300;
	final double SIDE_WIDTH = 500;	
	
	final double SCALE = 0.8;
	final double SMALLER_WIDTH = SCALE * SIDE_WIDTH;
	final double SMALLER_HEIGHT = SCALE * SIDE_HEIGHT;
	final double SMALLER_X = BIGGER_X + ( SIDE_WIDTH - SMALLER_WIDTH) / 2;
	final double SMALLER_Y = BIGGER_Y + ( SIDE_HEIGHT - SMALLER_HEIGHT) / 2;
	//////////////////////////////////////////////////
	final double leftEye_X = BIGGER_X + SIDE_WIDTH / 32 * 11;
	final double leftEye_Y = SMALLER_Y + 30;
	final double rightEye_X = BIGGER_X + SIDE_WIDTH / 32 * 21;
	final double rightEye_Y = leftEye_Y;
	final double leftEye_OFFSET_X = -80;
	final double leftEye_OFFSET_Y = 70;
	final double rightEye_OFFSET_X = -leftEye_OFFSET_X;
	final double rightEye_OFFSET_Y = leftEye_OFFSET_Y;
	
	GeneralPath leftEye = new GeneralPath();
	leftEye.moveTo( leftEye_X, leftEye_Y );
	leftEye.lineTo( leftEye_X + leftEye_OFFSET_X ,
			leftEye_Y + leftEye_OFFSET_Y );
	
	GeneralPath rightEye = new GeneralPath();
	rightEye.moveTo( rightEye_X, rightEye_Y );
	rightEye.lineTo( rightEye_X + rightEye_OFFSET_X ,
			 rightEye_Y + rightEye_OFFSET_Y );
	
	    
	GeneralPath wholeTV = new GeneralPath();
        GeneralPath expression = new GeneralPath();
	expression.append( leftEye, false);
	expression.append( rightEye, false );
	wholeTV.append(tv_skeleton, false);
	wholeTV.append( expression , false );
	//Shape s = ShapeTransforms.translatedCopyOf(expression, 0, 0);
        Shape s = ShapeTransforms.translatedCopyOf(wholeTV, -ORIG_ULX + x, -ORIG_ULY + y);
	
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;

	this.set( new GeneralPath(s) );
	
    }    
}
