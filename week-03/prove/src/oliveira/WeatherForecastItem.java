package oliveira;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {

    @SerializedName("main")
    private Map<String, Float> measurements;

    @SerializedName("dt_txt")
    private String date;

    @SerializedName("weather")
    private List<Weather> possibleWeatherConditions;

    private Wind wind;

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<Weather> getPossibleWeatherConditions() {
        return possibleWeatherConditions;
    }

    public void setPossibleWeatherConditions(List<Weather> possibleWeatherConditions) {
        this.possibleWeatherConditions = possibleWeatherConditions;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
