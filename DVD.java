package dlt;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * DVD - a robot by Dylan Tompkins
 */
public class DVD extends AdvancedRobot
{
	int colorIndex = 0;
	int backTime = 0;

	/**
	 * run: DVD's default behavior
	 */
	public void run() {

		setAdjustGunForRobotTurn(true);
		
		// Robot main loop
		while(true) {
			if(backTime <= 0) {
				setAhead(40000);
			}
			setTurnGunLeft(20);
			execute();
			backTime--;
		}
	}

	/**
	 * onScannedRobot: shoot 'em
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		setFire(2);
	}

	/**
	 * onHitByBullet: run away
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		setTurnRight(90);
	}
	
	/**
	 * onHitWall: bounce off the wall like the thingy
	 */
	public void onHitWall(HitWallEvent e) {
		cycleRobotColor();
		setBack(150);
		setTurnLeft(180);
		backTime = 25;
	}

	public void onHitRobot(HitRobotEvent e) {
		setBack(300);
		execute();
		setTurnLeft(180);
	}

	// make the robot look like the dvd screensaver
	public void cycleRobotColor() {
		if(colorIndex >= 13) {
			colorIndex = 0;
		}

		switch(colorIndex) {
			case 0:
				setAllColors(Color.black);
				break;
			case 1:
				setAllColors(Color.blue);
				break;
			case 2:
				setAllColors(Color.cyan);
				break;
			case 3:
				setAllColors(Color.darkGray);
				break;
			case 4:
				setAllColors(Color.gray);
				break;
			case 5:
				setAllColors(Color.green);
				break;
			case 6:
				setAllColors(Color.lightGray);
				break;
			case 7:
				setAllColors(Color.magenta);
				break;
			case 8:
				setAllColors(Color.orange);
				break;
			case 9:
				setAllColors(Color.pink);
				break;
			case 10:
				setAllColors(Color.red);
				break;
			case 11:
				setAllColors(Color.white);
				break;
			case 12:
				setAllColors(Color.yellow);
				break;
		}

		colorIndex++;
	}
}
