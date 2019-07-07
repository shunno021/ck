package com.example.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    TextView textView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    //call when the user clicks the button
    public void onClickFindBeer(View view) {

        //get a reference to the textView And spinner
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        //get the selected item in the spinner
        String beerType = String.valueOf(spinner.getSelectedItem());

        //Display the selected item
        //textView.setText(beerType);

        //Get recommendation from the BeerExpert class
        List<String> brandList = expert.getBrands(beerType);

        StringBuilder brandsFormatted = new StringBuilder();

        for(String brand : brandList) {
            brandsFormatted.append(brand).append("\n");
        }

        //Display the beers
        textView.setText(brandsFormatted);
    }
}
