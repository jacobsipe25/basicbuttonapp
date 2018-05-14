package com.example.jacob.tryagain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    int starter=0;
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

    }

}
