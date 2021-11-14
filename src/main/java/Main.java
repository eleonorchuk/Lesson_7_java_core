import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //
        OkHttpClient client = new OkHttpClient();

        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=pjllXlSxW8ER3AM9vGq31S3DfGCblEkN")
                .build();
        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        // Тело сообщения возвращается методом body объекта Response
        String body = response.body().string();
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        JsonNode jsonNode = objectMapper.readTree(body);
        JsonNode dailyForecastJn = jsonNode.get("DailyForecasts");
        String dailyForecast = dailyForecastJn.toString();
        List<WeatherResponse> weatherResponseList = objectMapper.readValue(dailyForecast.toLowerCase(), new TypeReference<List<WeatherResponse>>(){});
        System.out.println(weatherResponseList);

    }

}
