package ru.parhomych.weatherparhomych;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.parhomych.weatherparhomych.city.City;

public class MainActivity extends AppCompatActivity {

    static int CHOOSE_CITY_REQUEST_CODE = 1;
    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_choose_city:
                Intent intent = new Intent(this, ChooseCityActivity.class);
                startActivityForResult(intent, CHOOSE_CITY_REQUEST_CODE);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CHOOSE_CITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                data.getSerializableExtra("city");
            } else {
                // city didn't changed, error
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}