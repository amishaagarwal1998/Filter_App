
package com.example.listviewdropdownspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    Spinner mySpinner;
    ArrayAdapter<CosmicBody> adapter;
    String[] categories = {"All", "Planets", "stars", "galaxies"};

    private void initializeViews() {
        mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));
        myListView = findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCosmicBodies()));

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {

                if (position >= 0 && position < categories.length) {
                    getSelectedCategoryData(position);
                } else {

                    Toast.makeText(MainActivity.this,"Selected Category does not exist!",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private ArrayList<CosmicBody> getCosmicBodies()

    {
        ArrayList<CosmicBody> data = new ArrayList<>();
        data.clear();
        data.add(new CosmicBody("Mercury", 1));
        data.add(new CosmicBody("Mars", 1));
        data.add(new CosmicBody("Venus", 1));
        data.add(new CosmicBody("Milky Way", 3));
        data.add(new CosmicBody("Sun", 2));
        data.add(new CosmicBody("Sombrero", 3));
        data.add(new CosmicBody("Malin 1", 3));
        data.add(new CosmicBody("Rigel", 2));
        data.add(new CosmicBody("Sirius", 2));
        data.add(new CosmicBody("Canopus", 2));
        data.add(new CosmicBody("Andromeda", 3));
        data.add(new CosmicBody("Messeir 82", 3));
        data.add(new CosmicBody("Black Eye", 3));
        data.add(new CosmicBody("Virgo Stellar Stream", 3));
        data.add(new CosmicBody("Tadpole", 3));
        data.add(new CosmicBody("Pinwheel", 3));
        data.add(new CosmicBody("Deneb", 2));
        data.add(new CosmicBody("Altair", 2));
        data.add(new CosmicBody("Algol", 2));

        return data;

    }

    private void getSelectedCategoryData(int categoryID) {

        ArrayList<CosmicBody> cosmicBodies = new ArrayList<>();
        if (categoryID == 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCosmicBodies());
        } else {
            for (CosmicBody cosmicBody : getCosmicBodies()){
                if (cosmicBody.getCategoryID() == categoryID) {

                    cosmicBodies.add(cosmicBody);
                }
        }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cosmicBodies);
    }
    myListView.setAdapter(adapter);
    }

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }


}
    class CosmicBody{
    private String name;
    private int categoryID;

    public String getName(){
        return name;
    }

    public int getCategoryID(){

        return categoryID;
    }

    public CosmicBody(String name,int categoryID)
    {
        this.name = name;
        this.categoryID = categoryID;

    }

    @Override
        public String toString(){
            return name;
    }

    }

