import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseWrapper {
    private ArrayList<WeatherResponse> DailyForecasts;

    public WeatherResponseWrapper() {
    }

    public WeatherResponseWrapper(ArrayList<WeatherResponse> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }

    public ArrayList<WeatherResponse> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(ArrayList<WeatherResponse> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }

    @Override
    public String toString() {
        return "WeatherResponseWrapper{" +
                "DailyForecasts=" + DailyForecasts +
                '}';
    }
}
