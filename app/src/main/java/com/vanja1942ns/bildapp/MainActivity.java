package com.vanja1942ns.bildapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> stBook;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        stBook = new ArrayList<>();
        stBook.add(new Book("The Sun","", "Hey Sunshine ", R.drawable.one));
        stBook.add(new Book("Wait for me", "", "Wait for me sunshine", R.drawable.two));
        stBook.add(new Book("The Beach", "", "Sandy beaches and ocean", R.drawable.three));
        stBook.add(new Book("Together", "", "Walking together", R.drawable.four));
        stBook.add(new Book("Mountain", "", "Mountain walk ", R.drawable.six));

        RecyclerView myrv = findViewById(R.id.recycleview_id);
        RecycleViewAdapter myAdapter = new RecycleViewAdapter(this, stBook);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);


    }
}