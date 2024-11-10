package com.mehboob.androidcallblocker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mehboob.androidcallblocker.database.BlockedNumberDatabase;
import com.mehboob.androidcallblocker.entitites.BlockedNumber;

import java.util.ArrayList;
import java.util.List;

public class BlockedCallsActivity extends AppCompatActivity {
    private CallPreferences callPreferences;
    private BlockedNumberAdapter adapter;
    private LinearLayout emptyLayout;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_calls);
         Toolbar toolbar = findViewById(R.id.toolBarBLocked);
        setSupportActionBar(toolbar);
        emptyLayout=findViewById(R.id.emptyLayout);
        callPreferences = new CallPreferences(this);
         recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BlockedNumberAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);



        BlockedNumberDatabase db = BlockedNumberDatabase.getDatabase(this);

        db.blockedNumberDao().getAllBlockedNumbers().observe(this, new Observer<List<BlockedNumber>>() {
            @Override
            public void onChanged(List<BlockedNumber> blockedNumbers) {
                if (blockedNumbers.isEmpty() || blockedNumbers==null){
                         recyclerView.setVisibility(View.GONE);
                         emptyLayout.setVisibility(View.VISIBLE);
                }else {
                    recyclerView.setVisibility(View.VISIBLE);
                    emptyLayout.setVisibility(View.GONE);

                    adapter.setBlockedNumbers(blockedNumbers);
                }
            }
        });
    }
}