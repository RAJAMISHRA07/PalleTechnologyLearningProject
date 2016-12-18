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

public class Main5Activity extends AppCompatActivity {
    //step 5 : declare all variables for your activity
    ListView listView; //DESTINATION
    ArrayList<Videos> myVideos; //SOURCE
    MyAdapter myAdapter; //BRIDGE

    private String[] sql_server_freshers_demo_videos = {
            "SQLServer Overview/Kdc84lpF4GM/16:25",
            "Normalization/7Dc7_I48ZTg/14:30",
            "Orderby clause/quuwLXzZl3g/6:59",
            "Delete drop and truncate statements/yZNyUzSMsT8/6:58",
            "Aggregate Functions/2IYykxAXaB8/13:54",
            "Group by clause/qx0j5iWajqg/20:22",
            "Joins and Inner Join with simple explanation/i0vwTFFHTU8/33:02",
            "stored procedure/jmZsXlAYe7Y/17:11",
            "User defined functions in sql/8cJFtDESxiQ/9:01",
            "Indexes/hrVpqW_Bh2o/21:09"
    };
    List<String> videotutorial=new ArrayList<String>(Arrays.asList(sql_server_freshers_demo_videos));

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
                    Toast.makeText(Main5Activity.this, "POSTION.."+pos,
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Main5Activity.this,Main3Activity.class);
                    if(pos==0){
                        intent.putExtra("video_id","Kdc84lpF4GM");
                    }
                    if(pos==1){
                        intent.putExtra("video_id","7Dc7_I48ZTg");
                    }
                    if(pos==2){
                        intent.putExtra("video_id","quuwLXzZl3g");
                    }
                    if(pos==3){
                        intent.putExtra("video_id","yZNyUzSMsT8");
                    }
                    if(pos==4){
                        intent.putExtra("video_id","2IYykxAXaB8");
                    }
                    if(pos==5){
                        intent.putExtra("video_id","qx0j5iWajqg");
                    }
                    if(pos==6){
                        intent.putExtra("video_id","i0vwTFFHTU8");
                    }
                    if(pos==7){
                        intent.putExtra("video_id","jmZsXlAYe7Y");
                    }
                    if(pos==8){
                        intent.putExtra("video_id","8cJFtDESxiQ");
                    }
                    if(pos==9){
                        intent.putExtra("video_id","hrVpqW_Bh2o");
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
        setContentView(R.layout.activity_main5);
        Intent intent=getIntent();
        //STEP 6 : INITIALIZE ALL VARIABLES
        listView = (ListView) findViewById(R.id.listview3);
        myVideos = new ArrayList<Videos>();
        //we will insert video object (details) into arraylist
        Videos v1 = new Videos("1", "SQLServer Overview", "16:25");
        Videos v2 = new Videos("2", "Normalization", "14:30");
        Videos v3 = new Videos("3", "Orderby clause", "6:59");
        Videos v4 = new Videos("4", "Delete drop and truncate statements", "6:58");
        Videos v5 = new Videos("5", "Aggregate Functions", "13:54");
        Videos v6 = new Videos("6", "Group by clause", "20:22");
        Videos v7 = new Videos("7", "Joins and Inner Join with simple explanation", "33:02");
        Videos v8 = new Videos("8", "stored procedure", "17:11");
        Videos v9 = new Videos("9", "User defined functions in sql", "9:01");
        Videos v10 = new Videos("10", "Indexes", "21:09");
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



