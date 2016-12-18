package com.example.admin.palletechnologylearningproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    //step 5 : declare all variables for your activity
    ListView listView; //DESTINATION
    ArrayList<Videos> myVideos; //SOURCE
    MyAdapter myAdapter; //BRIDGE
    private String[] csharp_freshers_demo_videos = {
            "C# program compilation/ltgDdukzQ7I/18:47",
            "C# data types/L_gFuuSp4V0/17:53",
            "C# class/l1C4FZGCab0/10:48",
            "C# class as virtual entity/HSdIq3k51bg/9:15",
            "Objects in c#/SM_QqUdMXY0/22:14",
            "Debugging in visual studio/8hXH5HxQfFU/10:41",
            "C# Arrays/CLnA6OAlNPk/24:50",
            "Declaring and Modifying data in c# arrays/O2QI3YFupxM/9:06",
            "Arrays Assignment/Zt85ireWQWw/7:49",
            "Loops/u_k75WcEpHM/5:51",
    };
    List<String>videotutorial=new ArrayList<String>(Arrays.asList(csharp_freshers_demo_videos));

    //step 4 : create inner class for custom adapter
    //step 8 : implement life cycle methods of custom adapter
    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return myVideos.size();
        }

        @Override
        public Object getItem(int i) {
            //return element at positon i from your source
            return myVideos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //a. load data from your source based on position "i"
            Videos temp = myVideos.get(i);
            //b. load row.xml and load all views available in row.xml
            View v = getLayoutInflater().inflate(R.layout.row, null);
            TextView textView1 = (TextView) v.findViewById(R.id.textView1);
            TextView textView2 = (TextView) v.findViewById(R.id.textView2);
            TextView textView3 = (TextView) v.findViewById(R.id.textView3);
            Button button1 = (Button) v.findViewById(R.id.button1);
                button1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view){

            //code... get position
                     int pos = listView.getPositionForView(view);
                      Toast.makeText(Main2Activity.this, "POSTION.." + pos,
                              Toast.LENGTH_LONG).show();
                      Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                      if (pos == 0) {
                         intent.putExtra("video_id", "ltgDdukzQ7I");
                      }
                      if (pos == 1) {
                         intent.putExtra("video_id", "L_gFuuSp4V0");
                      }
                       if (pos == 2) {
                          intent.putExtra("video_id", "l1C4FZGCab0");
                      }
                      if (pos == 3) {
                          intent.putExtra("video_id", "HSdIq3k51bg");
                      }
                     if (pos == 4) {
                          intent.putExtra("video_id", "SM_QqUdMXY0");
                     }
                     if (pos == 5) {
                         intent.putExtra("video_id", "8hXH5HxQfFU");
                     }
                     if (pos == 6) {
                         intent.putExtra("video_id", "CLnA6OAlNPk");
                     }
                     if (pos == 7) {
                         intent.putExtra("video_id", "O2QI3YFupxM");
                     }
                     if (pos == 8) {
                         intent.putExtra("video_id", "Zt85ireWQWw");
                     }
                     if (pos == 9) {
                         intent.putExtra("video_id", "u_k75WcEpHM");
                     }


                      startActivity(intent);



                  }
                  });

            //c. fill data onto all above views
            textView1.setText(temp.getSno());
            textView2.setText(temp.getVname());
            textView3.setText("duration " + temp.getVduration());
            //d. return row.xml
            return v;
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        //STEP 6 : INITIALIZE ALL VARIABLES
        listView = (ListView) findViewById(R.id.listview1);
        myVideos = new ArrayList<Videos>();
        //we will insert video object (details) into arraylist
        Videos v1 = new Videos("1", "C# program\ncompilation", "18:47");
        Videos v2 = new Videos("2", "C# datatypes", "17:53");
        Videos v3 = new Videos("3", "C# class", "10:48");
        Videos v4 = new Videos("4", "C# class as\nvirtual entity", "9:15");
        Videos v5 = new Videos("5", "Objects in C#", "22:14");
        Videos v6 = new Videos("6", "Debugging in\nvisual studio", "22:14");
        Videos v7 = new Videos("7", "C# Arrays", "10:41");
        Videos v8 = new Videos("8", "Declaring and Modifying data in c# arrays", "24:50");
        Videos v9 = new Videos("9", "Arrays Assignment", "9:06");
        Videos v10 = new Videos("10", "Loops", "7:49");
        //now add all objects to arraylist
        myVideos.add(v1);
        myVideos.add(v2);
        myVideos.add(v3);
        myVideos.add(v4);
        myVideos.add(v5);
        myVideos.add(v6);
        myVideos.add(v7);
        myVideos.add(v8);
        myVideos.add(v9);
        myVideos.add(v10);

        myAdapter = new MyAdapter();
        //step 7 : establish link between adapter to listview
        listView.setAdapter(myAdapter);



    }
}



