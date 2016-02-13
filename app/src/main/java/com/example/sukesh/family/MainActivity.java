package com.example.sukesh.family;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
    ListView listView;
    //ArrayAdapter<String> a;
    String[] fam={"Bhagat singh", "Dhana Devi","Mukesh","Rakesh","Sukesh"};
    String[] disc={"Father","Mother","Endest Brother","Elder Brother","Me"};

    Integer[] imageIds={
            R.drawable.papa,
            R.drawable.mammi,
            R.drawable.muk,
            R.drawable.ra,
            R.drawable.me
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list_View);
        //fam=getResources().getStringArray(R.array.mem_name);
      //  disc=getResources().getStringArray(R.array.mem_disc);

        FamilyAdapter adapter=new FamilyAdapter(this,fam,disc,imageIds);
       // int i=0;


        //passing each of the data as an object to this class
        /*for(String name:fam)
        {
            FamilyDataProvider dataProvider=new FamilyDataProvider(imageID[i],name,disc[i]);
            adapter.add(dataProvider);
            i++;
        }*/
      //  a=new ArrayAdapter<String>(this,R.layout.row_layouot,fam);
        listView.setAdapter(adapter);



    }
}
