package minecraft.squidsquad;
import org.bukkit.util.Vector;

public class Windspeed extends Vector {
    public Windspeed(){
        x = 1;
        y = 0;
        z = 1;
    }

    public Windspeed(int x, int z){
        this.x = x;
        this.y = 0;
        this.z = z;
    }

    public Vector applyWindToProjectile(Vector initialVelocity){
        Vector newVelocity = (initialVelocity.clone()).add(this);
        return newVelocity;
    }

    public void changeWindSpeed(int x, int z){
        this.x = x;
        this.z = z;
    }

    @Override
    public Vector setY(double y){
        return this;
    }

    @Override
    public Vector setY(int y){
        return this;
    }

    @Override
    public Vector setY(float y){
        return this;
    }

    
}
