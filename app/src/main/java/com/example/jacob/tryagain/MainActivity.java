package com.example.jacob.tryagain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    int starter=0;
    public int numberloops(){
        Spinner mine=(Spinner) findViewById(R.id.spinner);
        String stuff=mine.getSelectedItem().toString();
        if (stuff=="One"){
            return 1;
        }
        else{
            return 2;
        }

    }
    public int Numberclicked(){
        ImageView im=(ImageView)findViewById(R.id.hiddenimage);

        int count=starter+1;
        if (count%2==0){
            im.setVisibility(View.VISIBLE);
        }
        else{
            im.setVisibility(View.INVISIBLE);
        }
        if (count<=10){
            starter = count;
            return count;
        }
        else{
            starter=0;
        }
        return 0;
    }
//this class is public and can be accessed everywhere

    public void clicked(View view){
        int something=Numberclicked();
        Log.i("Button Clicked","Button clicked" +something + "times");
        TextView tv=(TextView) findViewById(R.id.thesetter);
        String text="The button has been clicked "+String.valueOf(something)+" times";
        tv.setText(text);
    }
    @Override //lets add some code to this method void doesn't return anything
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner mine=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter <String> myAdapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.patterns));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //specify the dropdown ish
        mine.setAdapter(myAdapter);

//        if you don't specify the adapter you get no data
        mine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {

                Toast.makeText(parent.getContext(),
                        "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


}
