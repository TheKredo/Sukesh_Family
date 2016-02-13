package com.example.sukesh.family;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sukesh on 14-02-2016.
 */
    public class FamilyAdapter extends ArrayAdapter<String>{
       Context context;
         String[] disc;
         String[] fam;
        Integer[] imageIds;
         LayoutInflater inflater;

    public FamilyAdapter(Context context, String[] fam,String[] disc, Integer[] imageIds)
        {
            super(context, R.layout.row_layouot, fam);
            this.context = context;
            this.disc=disc;
            this.fam = fam;
            this.imageIds = imageIds;
        }

        public  class ViewContainer {
           ImageView imageView;
            TextView txtTitle;
           TextView txtDescription;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
           final ViewContainer viewContainer;
            //View rowView = view;

            //---print the index of the row to examine---
           // Log.d("CustomArrayAdapter",String.valueOf(position));

            //---if the row is displayed for the first time---
            if (view == null) {

                // Log.d("CustomArrayAdapter", "New");
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.row_layouot, null);
            }
                //---create a view container object---
                viewContainer = new ViewContainer();

                //---get the references to all the views in the row--- .... INITIALIZING VIEWS
                viewContainer.txtTitle = (TextView) view.findViewById(R.id.textView2);
                viewContainer.txtDescription = (TextView) view.findViewById(R.id.textView3);
                viewContainer.imageView = (ImageView) view.findViewById(R.id.imageView);

                //---assign the view container to the rowView---
                //rowView.setTag(viewContainer);
          /*  else {

                //---view was previously created; can recycle---
                Log.d("CustomArrayAdapter", "Recycling");
                //---retrieve the previously assigned tag to get
                // a reference to all the views; bypass the findViewByID() process,
                // which is computationally expensive---
                viewContainer = (ViewContainer) rowView.getTag();
            }*/

            //---customize the content of each row based on position---ASSIGNING DATA
            viewContainer.imageView.setImageResource(imageIds[position]);
            viewContainer.txtTitle.setText(fam[position]);
            viewContainer.txtDescription.setText(disc[position]);

            return super.getView(position, view, parent);
        }
    }