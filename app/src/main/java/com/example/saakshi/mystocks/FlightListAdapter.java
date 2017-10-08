package com.example.saakshi.mystocks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by navendu on 8/10/17.
 */

public class FlightListAdapter   extends ArrayAdapter<flight> {




    ArrayList<flight> FlightArrayList;
    Context context;

//    Boolean x = true;

    public FlightListAdapter(Context context, ArrayList<flight> FlightArrayList) {
        super(context, 0);
        this.context = context;
        this.FlightArrayList = FlightArrayList;
    }

    public int getCount() {
        return FlightArrayList.size();
    }

    static class FlightViewHolder {


        TextView fid;
        TextView source;

        TextView destination;

        TextView stime;

        TextView dtime;


        FlightViewHolder(TextView fid, TextView source, TextView destination,TextView stime,TextView dtime){

            this.fid = fid;

            this.source = source;

            this.destination = destination;

            this.stime= stime;

            this.dtime= dtime;


        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem3, null);
            TextView fid= (TextView) convertView.findViewById(R.id.fid);
            TextView source = (TextView) convertView.findViewById(R.id.source);
            TextView destination = (TextView) convertView.findViewById(R.id.destination);
            TextView stime = (TextView) convertView.findViewById(R.id.stime);


            TextView dtime = (TextView) convertView.findViewById(R.id.dtime);


            FlightListAdapter.FlightViewHolder FlightViewHolder = new FlightListAdapter.FlightViewHolder(fid,source,destination,stime,dtime);

            convertView.setTag(FlightViewHolder);

        }
        flight e = FlightArrayList.get(position);
        FlightListAdapter.FlightViewHolder FlightViewHolder = (FlightListAdapter.FlightViewHolder) convertView.getTag();
        //expenseViewHolder.created.setText(e.Created);
        //expenseViewHolder.language.setText(e.Language);
        FlightViewHolder.fid.setText(e.fid);
        FlightViewHolder.source.setText(e.source);
        FlightViewHolder.destination.setText(e.destination);
        FlightViewHolder.stime.setText(e.stime);
        FlightViewHolder.dtime.setText(e.dtime);



        return convertView;
    }

}
