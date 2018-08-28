package com.android.alucard.listviewmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements CountryInterface {

    ListView listView;
    String[] countries = {"china", "india", "USA", "japan", "nepal", "United Kingdom",
            "Germany", "France", "Romania"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_map, R.id.tvCountry, countries);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                bundle.putString("country", item);
                // set Fragmentclass Arguments
                CountryFragment cFrag = new CountryFragment();
                cFrag.setArguments(bundle);

                getFragmentManager().beginTransaction().add(R.id.mainLayout, cFrag, "country").commit();

            }
        });
    }

    @Override
    public void getCountry(String country) {

    }
}
