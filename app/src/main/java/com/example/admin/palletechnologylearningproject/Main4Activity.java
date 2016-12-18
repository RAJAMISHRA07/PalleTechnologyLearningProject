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

public class Main4Activity extends AppCompatActivity {
    //step 5 : declare all variables for your activity
    ListView listView; //DESTINATION
    ArrayList<Videos> myVideos; //SOURCE
    MyAdapter myAdapter; //BRIDGE

    private String[] csharp_exp_demo_videos = {
            "C# program compilation/ltgDdukzQ7I/18:47",
            "Debugging in visual studio/8hXH5HxQfFU/10:41",
            "Inheritence/TOBLe0qoA_o/9:24",
            "Inheritence Part 2/T7G8NFXDXFE/24:07",
            "base keyword/WaAbIMz2dqg/22:08",
            "Overriding Intro/w6ldKhR4YUs/23:31",
            "overriding an override method/fdPslUmRqm0/12:52",
            "Static Variables/zvk_hS4vEOw/9:27",
            "what is the use of properties in c#/UdiU6sp68Tc/16:16",
            "c# properties/5nHmt5Zi7l8/15:03",
    };
    List<String> videotutorial=new ArrayList<String>(Arrays.asList(csharp_exp_demo_videos));

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
                public void onClick(View view) {
                    //code... get position
                    int pos = listView.getPositionForView(view);
                    Toast.makeText(Main4Activity.this, "POSTION.."+pos,
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Main4Activity.this,Main3Activity.class);
                    if(pos==0){
                        intent.putExtra("video_id","ltgDdukzQ7I");
                    }
                    if(pos==1){
                        intent.putExtra("video_id","8hXH5HxQfFU");
                    }
                    if(pos==2){
                        intent.putExtra("video_id","TOBLe0qoA_o");
                    }
                    if(pos==3){
                        intent.putExtra("video_id","T7G8NFXDXFE");
                    }
                    if(pos==4){
                        intent.putExtra("video_id","WaAbIMz2dqg");
                    }
                    if(pos==5){
                        intent.putExtra("video_id","w6ldKhR4YUs");
                    }
                    if(pos==6){
                        intent.putExtra("video_id","fdPslUmRqm0");
                    }
                    if(pos==7){
                        intent.putExtra("video_id","zvk_hS4vEOw");
                    }
                    if(pos==8){
                        intent.putExtra("video_id","UdiU6sp68Tc");
                    }
                    if(pos==9){
                        intent.putExtra("video_id","5nHmt5Zi7l8");
                    }

                    // intent.putExtra("position",pos);
                    startActivity(intent);
                }
            });
            //c. fill data onto all above views
            textView1.setText(temp.getSno());
            textView2.setText(temp.getVname());
            textView3.setText("duration "+temp.getVduration());
            //d. return row.xml
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent=getIntent();
        //STEP 6 : INITIALIZE ALL VARIABLES
        listView = (ListView) findViewById(R.id.listview2);
        myVideos = new ArrayList<Videos>();
        //we will insert video object (details) into arraylist
        Videos v1 = new Videos("1", "C# program compilation", "18:47");
        Videos v2 = new Videos("2", "Debugging in visual studio", "10:41");
        Videos v3 = new Videos("3", "Inheritence", "9:24");
        Videos v4 = new Videos("4", "Inheritence Part 2", "24.07");
        Videos v5 = new Videos("5", "base keyword", "22:08");
        Videos v6 = new Videos("6", "Overriding Intro", "23:31");
        Videos v7 = new Videos("7", "overriding an override method", "12:52");
        Videos v8 = new Videos("8", "Static Variables", "9:27");
        Videos v9 = new Videos("9", "what is the use of properties in c#", "16:16");
        Videos v10 = new Videos("10", "c# properties", "15:03");
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



