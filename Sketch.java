import java.util.Random;

import processing.core.PApplet;

public class Sketch extends PApplet {
  // Make random int and run stroke method
  Random myRandom = new Random();
  int intRandomNum = myRandom.nextInt(100);
  boolean randomResult = strokeMethod(intRandomNum);
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255, 68, 255);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // Loop that creates grid of smiley faces
    for (int circleY = 100; circleY < 750; circleY += (200)) {
      for (int circleX = 200; circleX <= 600; circleX += (200)) {
        drawSmileyFace(circleX, circleY, 0);
      }
     }
    
   // Loop that creates grid of bullseyes
    for (int circleY = 200; circleY < 800; circleY += (200)) {
      for (int circleX = 300; circleX <= 500; circleX += (200)) {
        // Check if true or false
        if (randomResult == true) {
         drawBullseye(circleX, circleY, 0);
        }
        else {
          drawBullseye(circleX, circleY, 255);
        }
      }
     }

  }

  /**
   * Draws smiley face
   * 
   * @param circleX X coordinate for smiley face
   * @param circleY Y coordinate for smiley face
   * @param colourFace Int value for the colour of face
   * @author: A. Wong
   */

  private void drawSmileyFace(int circleX, int circleY, int colourFace) {
    // Draw circle face
    stroke(0,0,0);
    fill(colourFace);
    circle((float)(circleX), (float)(circleY), (float)(150));

    // Draw circle eyes
    stroke(255);
    noFill();
    circle((float)(circleX - 20), (float)(circleY - 20), (float)(40));
    circle((float)(circleX + 20), (float)(circleY - 20), (float)(40));

    // Draw mouth
    stroke(255);
    noFill();
    arc((float)(circleX), (float)(circleY), (float)(100), (float)(100), (float)(0), (float)(3.14));

  }

  /**
   * Draws bullseye 
   * 
   * @param circleX X coordinate for bullseye
   * @param circleY Y coordinate for bullseye
   * @param strokeColour Int value for stroke colour
   * @author: A. Wong
   */

  private void drawBullseye(int circleX, int circleY, int strokeColour) {
    // Draw bigger red circle
    stroke(strokeColour);
    fill(255, 0, 0);
    circle((float)(circleX), (float)(circleY), (float)(50));
    
    // Draw inside white circle
    fill(255);
    circle((float)(circleX), (float)(circleY), (float)(25));

  }

  /**
   * Computes true or false if variable is greater or equal to fifty
   * 
   * @param intRandom Random integer
   * @return Returns boolean value
   * @author: A. Wong
   */

  private boolean strokeMethod(int intRandom) {
    // Return true or false
    return intRandom >= 50;

  }

  
  
}