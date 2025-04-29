package com.example.listview2_week5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FruitArrayAdapter fruitArrayAdapter;
    private ListView listView;
    private static int colorIndex;

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
        colorIndex = 0;
        listView = (ListView) findViewById(R.id.listView);
        fruitArrayAdapter = new FruitArrayAdapter(this, R.layout.listview_row_layout);
        listView.setAdapter(fruitArrayAdapter);

        List<String[]> fruitList = readData();
        for(String[] fruitData:fruitList ) {
            String fruitImg = fruitData[0];
            String fruitName = fruitData[1];
            String calories = fruitData[2];
            int fruitImgResId = getResources().getIdentifier(fruitImg, "drawable", "com.example.listview2_week5");

            Fruit fruit = new Fruit(fruitImgResId,fruitName,calories);
            fruitArrayAdapter.add(fruit);
        }
    }
    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] fruit7 = new String[3];
        fruit7[0] = "orange";
        fruit7[1] = "Orange";
        fruit7[2] = "47 Calories";
        resultList.add(fruit7);

        String[] fruit1 = new String[3];
        fruit1[0] = "cherry";
        fruit1[1] = "Cherry";
        fruit1[2] = "50 Calories";
        resultList.add(fruit1);


        String[] fruit3 = new String[3];
        fruit3[0] = "banana";
        fruit3[1] = "Banana";
        fruit3[2] = "89 Calories";
        resultList.add(fruit3);

        String[] fruit4 = new String[3];
        fruit4[0] = "apple";
        fruit4[1] = "Apple";
        fruit4[2] = "52 Calories";
        resultList.add(fruit4);

        String[] fruit10 = new String[3];
        fruit10[0] = "kiwi";
        fruit10[1] = "Kiwi";
        fruit10[2] = "61 Calories";
        resultList.add(fruit10);

        String[] fruit5 = new String[3];
        fruit5[0] = "pear";
        fruit5[1] = "Pear";
        fruit5[2] = "57 Calories";
        resultList.add(fruit5);


        return  resultList;
    }
}