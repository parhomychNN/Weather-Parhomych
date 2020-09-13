package ru.parhomych.weatherparhomych.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.parhomych.weatherparhomych.city.City;

public interface WeatherService {

    @GET("locations/v1/cities/autocomplete")
    Call<List<City>> findCitiesAutoComplete
            (@Query("apikey") String apikey,
             @Query("q") String stringForRequest,
             @Query("language") String language);

}
