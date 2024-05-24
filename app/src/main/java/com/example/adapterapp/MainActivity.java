package com.example.adapterapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        1. Adapter View: List View
        listView = findViewById(R.id.listView);
//        2. Data Source: String Array
        String[] countries = {"USA","ARGENTINA", "BRAZIL", "PERU", "GERMANY", "SAUDI ARABIA", "FRANCE", "INDONESIA", "MALAYSIA", "SINGAPORE", "RUSSIA", "CHINA", "INDIA", "PORTUGAL", "ITALY", "FRANCE", "JAPAN", "NORTH KOREA", "SOUTH KOREA", "THAILAND", "SCOTLAND", "SPAIN", "MEXICO"};

//        3.Adapter: acts as a bridge between the 'data source' and the 'AdapterView'
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                countries
//        );


        MyCustomAdapter adapter = new MyCustomAdapter(MainActivity.this, countries);

        // Link ListView with the Adapter
        listView.setAdapter(adapter);
    }
}