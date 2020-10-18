package oliveira;

import com.google.gson.annotations.SerializedName;

import java.net.InterfaceAddress;

public class Wind {

    private int id;

    private Double speed;

    private int degree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
