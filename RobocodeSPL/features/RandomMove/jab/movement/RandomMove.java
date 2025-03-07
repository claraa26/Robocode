package jab.movement;

import robocode.HitWallEvent;
import robocode.Event;
import jab.module.Module;
import jab.module.Movement;
import java.util.Random;

public class RandomMove extends Movement {
    private Random random;
    private int moveDirection;

    public RandomMove(Module bot) {
        super(bot); 
        this.random = new java.util.Random(); 
        this.moveDirection = 1;
    }

    public void move() {
        bot.setMaxVelocity(3 + random.nextInt(6));
        int moveDistance = 50 + random.nextInt(150);
        bot.setAhead(moveDistance * moveDirection);
        int turnAngle = random.nextInt(91) - 45;
        bot.setTurnRight(turnAngle);
    }

    public void listen(Event e) {
        if (e instanceof HitWallEvent) {
            moveDirection *= -1;
            bot.setBack(100);
        }
    }
}