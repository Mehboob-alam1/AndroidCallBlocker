package com.mehboob.androidcallblocker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehboob.androidcallblocker.entitites.BlockedNumber;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class BlockedNumberAdapter extends RecyclerView.Adapter<BlockedNumberAdapter.ViewHolder> {

    private List<BlockedNumber> blockedNumbers;

    public BlockedNumberAdapter(List<BlockedNumber> blockedNumbers) {
        this.blockedNumbers = blockedNumbers;
    }

    public void setBlockedNumbers(List<BlockedNumber> blockedNumbers) {
        this.blockedNumbers = blockedNumbers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blocked_number, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BlockedNumber blockedNumber = blockedNumbers.get(position);
        holder.phoneNumberTextView.setText(blockedNumber.phoneNumber);

        // Format the timestamp to display the date/time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDate = dateFormat.format(blockedNumber.blockedTime);
        holder.blockedTimeTextView.setText(formattedDate);
    }

    @Override
    public int getItemCount() {
        return blockedNumbers == null ? 0 : blockedNumbers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView phoneNumberTextView;
        TextView blockedTimeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNumberTextView = itemView.findViewById(R.id.phoneNumberTextView);
            blockedTimeTextView = itemView.findViewById(R.id.blockedTimeTextView);
        }
    }
}
