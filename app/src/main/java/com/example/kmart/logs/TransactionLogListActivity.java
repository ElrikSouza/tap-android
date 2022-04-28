package com.example.kmart.logs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kmart.R;

public class TransactionLogListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_log_list);

        LogsAdapter adapter = new LogsAdapter(this);
        RecyclerView logList = findViewById(R.id.log_list);
        logList.setAdapter(adapter);
        logList.setLayoutManager(new LinearLayoutManager(this));
    }
}