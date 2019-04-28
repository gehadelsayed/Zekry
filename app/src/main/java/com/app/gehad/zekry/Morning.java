package com.app.gehad.zekry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Morning extends AppCompatActivity implements View.OnClickListener {

    int stringIdList[] = {R.string.first,R.string.second, R.string.third,
            R.string.fourth, R.string.fifth,
            R.string.sixth,R.string.seventh,R.string.eighth,
            R.string.nineth,R.string.tenth,R.string.eleventh,
            R.string.twelve,R.string.thirteen,R.string.fifteen,
            R.string.sixteen,R.string.seventh,R.string.eigteen,
            R.string.ninteen,R.string.twenty, R.string.twentyone,
            R.string.twentytwo,R.string.twentythree,R.string.twentyfour,
            R.string.twentyfive,R.string.twentysix,
            R.string.twentyseven, R.string.twentynine,R.string.thirty,
            R.string.thirtyone,R.string.thirtytwo,R.string.thirtythree};

    String stringNumberList[] = {"مرة واحدة","3 مرات","3 مرات","3 مرات",
            "مرة واحدة","مرة واحدة","3 مرات","4 مرات","مرة واحدة",
            "7 مرات","3 مرات","مرة واحدة","مرة واحدة","3 مرات","3 مرات","3 مرات",
            "مرة واحد","3 مرات","مرة واحد","مرة واحد","3 مرات","10 مرات","3 مرات",
            "3 مرات","3 مرات","3 مرات","مرة واحد","مرة واحد","100 مرة","100 مرة","100 مرة"};

    int counterList[]={1,3,3,3,1,1,3,4,1,7,3,1,1,3,3,3,1,3,1,1,3,10,3,3,3,3,1,1,100,100,100};

    int stringListCounter = 0;
    int intNumberCounter=0;
    int counterzkr=1;


    TextView tv;
    TextView nV;
    Button nButton;
    Button bButton;
    Button counterm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        tv=(TextView)findViewById(R.id.morning_zkr);
        nV=(TextView)findViewById(R.id.m_umbers);
        nButton=(Button)findViewById(R.id.next_btn);
        bButton=(Button)findViewById(R.id.back_btn);
        counterm=(Button)findViewById(R.id.counterbm);
        Button homeButton=(Button)findViewById(R.id.homebtn);

        tv.setText(stringIdList[0]);
        counterm.setText(""+1);
        setTitle("أذكار الصباح");

        nButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        counterm.setOnClickListener(this);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Morning.this,MainActivity.class);
                startActivity(i);
            }
        });

        counterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zkr= counterm.getText().toString();
                Log.v("zkr string","->"+zkr);
                int newzkr=Integer.parseInt(zkr);
                Log.v("the newzkr counter","=>"+newzkr);
                if (newzkr>0) {
                    newzkr--;
                }
                counterm.setText(""+newzkr);
            }
        });



        Log.v("this is 0","-->"+stringIdList[1]);


    }

    public void decrease(){
        int zkr=counterList[stringListCounter];
        Log.v("this is newzkr","-->"+zkr);

        if (counterzkr<counterList[stringListCounter]){
            int newzkr=zkr-1;
            Log.v("this is newzkr","-->"+newzkr);
            counterm.setText(""+newzkr);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.v("this is id","-->"+id);

        if(id == R.id.next_btn && stringListCounter < stringIdList.length - 1) {
            stringListCounter++;
            intNumberCounter++;
            counterm.setText(""+counterList[intNumberCounter]);
            Log.v("this is stringlenth","--->"+stringListCounter);

        }
        else if (id == R.id.back_btn && stringListCounter > 0) {
            stringListCounter--;
            intNumberCounter--;
            counterm.setText(""+counterList[intNumberCounter]);
            Log.v("this is stringlenth","--->"+stringListCounter);
        }
        else if ( stringListCounter == 30)
        {
            Toast.makeText(this,"جزاك الله خيرا",Toast.LENGTH_SHORT).show();
        }


        tv.setText(stringIdList[stringListCounter]);
        nV.setText(stringNumberList[intNumberCounter]);


        if (id==R.id.counterbm){
            Log.v("iam here","->"+counterzkr);
           String zkr= counterm.getText().toString();
           Log.v("zkr string","->"+zkr);
           int newzkr=Integer.parseInt(zkr);
           Log.v("the newzkr counter","=>"+newzkr);
           newzkr--;
           counterm.setText(""+newzkr);

        }


//        if (id == R.id.counterbm){
//
//            int czkr=counterList[stringListCounter];
//            Log.v("this is czkr","-->"+czkr);
//
//            for (int counterzkr=0;counterzkr<czkr;czkr--) {
//
//                Log.v("this is czkr2","-->"+czkr);
//
//                counterm.setText(""+czkr);
//            }
//            Log.v("this is counterzkr","-->"+counterzkr);
//
//
//        }

    }




}
