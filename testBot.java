package dlt;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class testBot extends Robot {

    public void run() {

        setColors(Color.white, Color.blue, Color.green, Color.blue, Color.green);
        
        while(true) {
            turnRadarRight(15);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        turnTo(getRadarHeading());

        fire(1.5);

        ahead(50);

        scan();
    }

    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(45);
        ahead(250);
    }

    public void turnTo(double radarHeading){
        double heading = getHeading();

        if(radarHeading > heading) {
            turnRight(radarHeading - heading);
        }
        else if(heading > radarHeading) {
            turnLeft(heading - radarHeading);
        }
    }

    public void onHitRobot() {
        back(200);
    }

    public void onHitWall() {
        back(200);
    }

}