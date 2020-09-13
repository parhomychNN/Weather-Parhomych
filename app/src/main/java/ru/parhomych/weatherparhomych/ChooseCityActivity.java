package ru.parhomych.weatherparhomych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.parhomych.weatherparhomych.city.City;
import ru.parhomych.weatherparhomych.retrofit.ApiKeys;
import ru.parhomych.weatherparhomych.retrofit.RetrofitAccuWeather;
import ru.parhomych.weatherparhomych.retrofit.WeatherService;

public class ChooseCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

        final EditText editTextCityToFind = findViewById(R.id.editTextCityToFind);

        final Button findCityButton = findViewById(R.id.find_city_button);
        findCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherService weatherService = RetrofitAccuWeather.getInstance().create(WeatherService.class);
                Call<List<City>> citiesForAutoComplete = weatherService.findCitiesAutoComplete(
                        ApiKeys.ACCU_WEATHER_KEY,
                        editTextCityToFind.getText().toString(),
                        editTextCityToFind.getTextLocale().getLanguage()
                );
                citiesForAutoComplete.enqueue(new Callback<List<City>>() {
                    @Override
                    public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                        TextView infoTextView = findViewById(R.id.infoCitiesTextView);

                        String collect = response.body().stream().map(City::getLocalizedName).collect(Collectors.joining(", "));

                        infoTextView.setText(collect);

                    }

                    @Override
                    public void onFailure(Call<List<City>> call, Throwable t) {

                    }
                });
            }
        });

    }



}