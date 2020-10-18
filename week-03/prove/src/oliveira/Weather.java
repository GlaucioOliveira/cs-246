package oliveira;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Weather {

    private int id;

    @SerializedName("main")
    private String measurement;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
