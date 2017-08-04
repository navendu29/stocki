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
 * Created by saakshi on 14/7/17.
 */

public class TickersListAdapter extends ArrayAdapter<Tickers> {

    ArrayList<Tickers> tickersArrayList;
    Context context;

//    Boolean x = true;

    public TickersListAdapter(Context context, ArrayList<Tickers> tickersArrayList) {
        super(context, 0);
        this.context = context;
        this.tickersArrayList = tickersArrayList;
    }

    public int getCount() {
        return tickersArrayList.size();
    }

    static class TickerViewHolder {


        TextView symbol;
        TextView name;


        TickerViewHolder(TextView symbol, TextView name) {

            this.name = name;

            this.symbol = symbol;


        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem2, null);
            TextView name = (TextView) convertView.findViewById(R.id.names);


            TextView symbol = (TextView) convertView.findViewById(R.id.symbols);


            TickerViewHolder tickerViewHolder = new TickerViewHolder(name, symbol);

            convertView.setTag(tickerViewHolder);

        }
        Tickers e = tickersArrayList.get(position);
        TickerViewHolder tickerViewHolder = (TickerViewHolder) convertView.getTag();
        //expenseViewHolder.created.setText(e.Created);
        //expenseViewHolder.language.setText(e.Language);
        tickerViewHolder.name.setText(e.companyName);


        tickerViewHolder.symbol.setText(e.tinkerName);


        return convertView;
    }

}


