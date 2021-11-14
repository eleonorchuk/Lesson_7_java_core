import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    //| В городе CITY на дату DATE ожидается WEATHER_TEXT, температура - TEMPERATURE |
    //private String city;

    private String date;
    private JsonNode temperature;
    private JsonNode day;

    public WeatherResponse() {
    }

    public WeatherResponse(String date, JsonNode temperature, JsonNode day) {
        this.date = date;
        this.temperature = temperature;
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JsonNode getTemperature() {
        return temperature;
    }

    public void setTemperature(JsonNode temperature) {
        this.temperature = temperature;
    }

    public JsonNode getDay() {
        return day;
    }

    public void setDay(JsonNode day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "WeatherResponse{\n" +
                "\tcity = " + "Saint-Petersburg" +
                "\n\tdate = " + date +
                ",\n\ttemperature = " + temperature +
                ",\n\ttext = " + day.get("iconphrase").toString() +
                "}\n";
    }
}
