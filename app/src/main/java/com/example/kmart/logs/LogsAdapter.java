package com.example.kmart.logs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;

import java.util.ArrayList;
import java.util.Locale;

public class LogsAdapter extends RecyclerView.Adapter<LogsViewHolder> {
   private TransactionLogRepository transactionLogRepository;
   private ArrayList<TransactionLog> logs;
   private Context context;

   public LogsAdapter(Context context) {
      this.transactionLogRepository = new TransactionLogRepository(context);
      this.context = context;
      this.refreshDataSet();
   }

   public void refreshDataSet() {
      this.logs = this.transactionLogRepository.getAllLogs();
      this.notifyDataSetChanged();
   }


   @NonNull
   @Override
   public LogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.log_entry_layout, parent, false);

      return  new LogsViewHolder(layout, context);
   }

   @Override
   public void onBindViewHolder(@NonNull LogsViewHolder holder, int position) {
      TransactionLog log = logs.get(position);

      String transactionType = "";

      if (log.getTransactionType() == 0) {
         transactionType = "Compra";
      } else {
         transactionType = "Venda";
      }

      holder.transactionType.setText(transactionType);
      holder.transactionTimeStamp.setText(log.getTransactionDate().toString());
      holder.transactionValue.setText(String.format(Locale.getDefault(), "Valor: R$ %.2f", log.getTransactionValue()));
   }

   @Override
   public int getItemCount() {
      return this.logs.size();
   }
}
