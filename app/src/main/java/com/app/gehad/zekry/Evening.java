package com.app.gehad.zekry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Evening extends AppCompatActivity implements View.OnClickListener {


    int stringIdList[]={R.string.eve1,R.string.eve2,R.string.eve3,
            R.string.eve4,R.string.eve5,R.string.eve6,R.string.eve7,
            R.string.eve8,R.string.eve9,R.string.eve10,R.string.eve11,
            R.string.eve12,R.string.eve13,R.string.eve14,R.string.eve15,
            R.string.eve16,R.string.eve17,R.string.eve18,R.string.eve19,
            R.string.eve20,R.string.eve21,R.string.eve22,R.string.eve23,
            R.string.eve24,R.string.eve25,R.string.eve26,R.string.eve27,
            R.string.eve28,R.string.eve29,R.string.eve30};



    String stringNumberList[] = {"مرة واحدة","مرة واحدة","ثلاث مرات","ثلاث مرات","ثلاث مرات","مرة واحدة",
            "مرة واحدة","ثلاث مرات","اربع مرات","مرة واحدة","سبع مرات","ثلاث مرات","مرة واحدة","مرة واحدة","ثلاث مرات",
            "ثلاث مرات","ثلاث مرات","مرة واحدة","ثلاث مرات","مرة واحدة","مرة واحدة","ثلاث مرات"," عشر مرات","ثلاث مرات",
            "ثلاث مرات","ثلاث مرات","ثلاث مرات"," 100 مرة","مرة واحدة","100 مرة"};

    int counterList[]={1,1,3,3,3,1,1,3,4,1,7,3,1,1,3,3,3,1,3,1,1,3,10,3,3,3,3,100,1,100};

    TextView eTv;
    TextView nTv;
    Button eNButton;
    Button ePButton;
    Button counterButton;
    int stringListCounter = 0;
    int intNumberCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
        eTv=(TextView)findViewById(R.id.evening_zkr);
        eNButton=(Button)findViewById(R.id.next_ebtn);
        ePButton=(Button)findViewById(R.id.back_ebtn);
        counterButton=(Button)findViewById(R.id.counterbe);
        Button homeButtonE=(Button)findViewById(R.id.homebtne);
        nTv=(TextView)findViewById(R.id.e_numbers);
        eTv.setText(stringIdList[0]);
        nTv.setText("مرة واحدة");
        setTitle("أذكار المساء");


        eNButton.setOnClickListener(this);
        ePButton.setOnClickListener(this);

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zkr= counterButton.getText().toString();
                Log.v("zkr string","->"+zkr);
                int newzkr=Integer.parseInt(zkr);
                Log.v("the newzkr counter","=>"+newzkr);
                if (newzkr>0) {
                    newzkr--;
                }
                counterButton.setText(""+newzkr);
            }
        });

        homeButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Evening.this,MainActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.v("this is id","-->"+id);
        if(id == R.id.next_ebtn && stringListCounter < stringIdList.length - 1) {
            stringListCounter++;
            intNumberCounter++;
            counterButton.setText(""+counterList[intNumberCounter]);
            Log.v("this is stringlenth","--->"+stringListCounter);

        } else if (id == R.id.back_ebtn && stringListCounter > 0) {
            stringListCounter--;
            intNumberCounter++;
            counterButton.setText(""+counterList[intNumberCounter]);
            Log.v("this is stringlenth","--->"+stringListCounter);
        }
        else if ( intNumberCounter==29)
        {
            Toast.makeText(this,"جزاك الله خيرا",Toast.LENGTH_SHORT).show();
        }

        eTv.setText(stringIdList[stringListCounter]);
        nTv.setText(stringNumberList[intNumberCounter]);

    }
}
