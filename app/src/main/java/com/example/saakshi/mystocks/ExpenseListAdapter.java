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
 * Created by saakshi on 10/7/17.
 */

public class ExpenseListAdapter extends ArrayAdapter<Stocks>{

    ArrayList<Stocks> expenseArrayList;
    Context context;

//    Boolean x = true;

    public ExpenseListAdapter(Context context, ArrayList<Stocks> expenseArrayList) {
        super(context, 0);
        this.context = context;
        this.expenseArrayList = expenseArrayList;
    }

    @Override
    public int getCount() {
        return expenseArrayList.size();
    }

    static class ExpenseViewHolder {

        TextView created;
        TextView language;
        TextView symbol;
        TextView yearlow;
        TextView yearhigh;


        ExpenseViewHolder(TextView created,  TextView language, TextView symbol, TextView yearlow,TextView yearhigh) {

            this.created = created;
            this.language = language;
            this.symbol = symbol;
            this.yearlow = yearlow;
            this.yearhigh= yearhigh;


        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem, null);
            TextView created = (TextView) convertView.findViewById(R.id.t1);

            TextView langauge = (TextView) convertView.findViewById(R.id.t2);

            TextView symbol = (TextView) convertView.findViewById(R.id.t3);
            TextView yearlow = (TextView) convertView.findViewById(R.id.t4);
            TextView yearhigh = (TextView) convertView.findViewById(R.id.t5);


            ExpenseViewHolder expenseViewHolder = new ExpenseViewHolder(created, langauge, symbol, yearlow,yearhigh);

            convertView.setTag(expenseViewHolder);

        }
        Stocks e = expenseArrayList.get(position);
        ExpenseViewHolder expenseViewHolder = (ExpenseViewHolder) convertView.getTag();
       //expenseViewHolder.created.setText(e.Created);
        //expenseViewHolder.language.setText(e.Language);
        expenseViewHolder.created.setText(e.Created);
        expenseViewHolder.language.setText(e.getLanguage());

        expenseViewHolder.symbol.setText(e.Symbol);
        expenseViewHolder.yearlow.setText(e.YearLow);
        expenseViewHolder.yearhigh.setText(e.YearHigh);



        return convertView;
    }


}
