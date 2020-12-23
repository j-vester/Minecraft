package minecraft.squidsquad;
import org.bukkit.util.Vector;

public class Windspeed extends Vector {
    public Windspeed(){
        x = 1;
        y = 1;
        z = 0;
    }

    public Windspeed(double x, double y){
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vector applyWindToProjectile(Vector initialVelocity){
        Vector newVelocity = (initialVelocity.clone()).add(this);
        return newVelocity;
    }

    @Override
    public Vector setZ(double Z){
        return this;
    }

    @Override
    public Vector setZ(int Z){
        return this;
    }

    @Override
    public Vector setZ(float Z){
        return this;
    }

    
}
