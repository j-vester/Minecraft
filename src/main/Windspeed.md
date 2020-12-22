Developer: Sabine Glotzbach

Dependencies: 

Intended Function: This class should produce a Windspeed vector with malleable direction and speed, which can be multiplied with the vectors of flying objects (arrows, TNT) to simulate the effect of wind on their path.

How To Use:

To Do: Test and write the class, find a way to apply it to flying minecraft entities.
    --> entities have a boolean isOnGround(), which can  hopefully be used to select for flying objects, and also a vector getVelocity() and setVelocity(), which may be useful for determining the flight path by adding
    the vectors