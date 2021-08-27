package com.erengulbahar.landmarkbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.erengulbahar.landmarkbook.databinding.ActivityDetailsBinding;
import com.erengulbahar.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        ArrayList<LandMark> landMarkArrayList;
        landMarkArrayList=new ArrayList<>();

        //Data

        LandMark pisa=new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark eiffel=new LandMark("Eiffel","France",R.drawable.eyfel);
        LandMark colosseum=new LandMark("Colosseum","Italy",R.drawable.colosseum);
        LandMark londonBridge=new LandMark("London Bridge","UK",R.drawable.london);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);
        landMarkArrayList.add(londonBridge);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landMarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

        /*
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,landMarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,landMarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landMarkArrayList.get(position));
                startActivity(intent);
            }
        });

         */
    }
}