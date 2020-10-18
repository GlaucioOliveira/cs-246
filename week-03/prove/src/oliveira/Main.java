package oliveira;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

    private static final String endpointWeatherAPI = "https://api.openweathermap.org/data/2.5/weather";
    private static final String endpointForecastAPI = "https://api.openweathermap.org/data/2.5/forecast";

    private static final String keySecret = "805f7c242a73ec3f0f07b67db7323ef8";
    private static final String units = "metric"; //degree in Celsius
    private static String city = "Rexburg";
    private static final String charset = "UTF-8";

    public static void main(String[] args) throws UnsupportedEncodingException {
        Gson gson = new Gson();
        String response = "";

        System.out.println("WeatherApp\n\n");

        city = PromptCityName();

        response = getAPIResponse(endpointWeatherAPI, city);
        WeatherConditions weatherConditions = gson.fromJson(response, WeatherConditions.class);

        response = getAPIResponse(endpointForecastAPI, city);
        WeatherForecast weatherForecast = gson.fromJson(response, WeatherForecast.class);

        if(weatherForecast != null)
        {
            OutputWeatherForecast(weatherForecast);
        }
    }

    private static String PromptCityName() throws UnsupportedEncodingException {
        System.out.println("Please type the name of a city: ");
        Scanner scanner = new Scanner(System.in);

        return URLEncoder.encode(scanner.nextLine(), charset);
    }

    public static String getAPIResponse (String endPoint, String city)
    {
        String response = HttpRequest.get(endPoint, true, "q", city, "apiKey", keySecret, "units", units)
                .accept("application/json")
                .acceptCharset(charset)
                .body();

        return response;
    }

    private static void OutputWeatherForecast(WeatherForecast weatherForecast)
    {
        System.out.println("Forecast: \n");

        for(WeatherForecastItem forecast : weatherForecast.getForecastList())
        {
            System.out.println ("Time: " + forecast.getDate() + "\n" +
                    "Temperature: " + forecast.getMeasurements().get("temp") + "\n" +
                    "Weather Condition: " + forecast.getPossibleWeatherConditions().get(0).getDescription() + "\n"  +
                    "Wind Speed: " + forecast.getWind().getSpeed() + "\n\n");
        }
    }
}
