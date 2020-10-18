package oliveira;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast {

    public List<WeatherForecastItem> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<WeatherForecastItem> forecastList) {
        this.forecastList = forecastList;
    }

    @SerializedName("list")
    private List<WeatherForecastItem> forecastList;
}
