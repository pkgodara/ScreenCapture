/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screencapture;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;


/**
 *
 * @author pradeep kumar
 */
public class ScreenCapture {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many screenshots you want to take?");
        long n = sc.nextLong();
        System.out.println("Enter time-interval (milli-seconds) :");
        long t = sc.nextLong();
        
        capture(n,t);
        
        System.out.println("\nDone");
    }
    
    
    private static void capture(long n , long t)
    {
        long N = n ;
        
        while( n > 0 )
        {
            try
            {
                Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                
                //awt robot
                Robot robot = new Robot();
                
                //capture screenshot
                BufferedImage img = robot.createScreenCapture(new Rectangle(size));
                
                File output = new File("screenshot-"+(N-n+1));
                
                ImageIO.write(img , "JPG" , output );
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            try
            {
                Thread.sleep(t);
            }
            catch(Exception e)
            {
                System.out.println("Time-interval not working.");
            }
            
            n--;
        }
    }
    
}
