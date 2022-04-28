package com.example.kmart.logs;

import android.content.Context;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;

public class LogsViewHolder extends RecyclerView.ViewHolder {
    public TextView transactionType, transactionValue, transactionTimeStamp;

    public LogsViewHolder(ConstraintLayout layout, Context context) {
        super(layout);

        this.transactionTimeStamp = layout.findViewById(R.id.transaction_timestamp_label);
        this.transactionValue = layout.findViewById(R.id.transaction_value_label);
        this.transactionType = layout.findViewById(R.id.transaction_type_label);
    }
}
