package com.murach.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jugld on 5/15/2018.
 */

public class TipLayout extends RelativeLayout implements View.OnClickListener {

    private TextView billDateTextView;
    private TextView billAmountTextView;
    private TextView tipPercenteTextView;
    private Button deleteButton;

    private Context context;
    private TipDB db;
    private Tip tip;

    public TipLayout(Context context, Tip tip) {
        super(context);

        db = new TipDB(context);

        //inflate the layou
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_tip, this, true);

        //get widgets refs
        billDateTextView = (TextView) findViewById(R.id.billDateTextView);
        billAmountTextView = (TextView) findViewById(R.id.billAmountTextView);
        tipPercenteTextView = (TextView) findViewById(R.id.tipPercentTextView);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(this);

        //set task data on widget
        setTip(tip);

    }

    public void setTip(Tip tip) {
        this.tip = tip;

        billDateTextView.setText(tip.getDateStringFormatted());
        billAmountTextView.setText(tip.getBillAmountFormatted());
        tipPercenteTextView.setText(tip.getTipPercentFormatted());
    }

    @Override
    public void onClick(View view) {
        db.deleteTip(tip.getId());
        context.startActivity(new Intent(context, TipHistoryActivity.class));
    }

}
