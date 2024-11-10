package com.mehboob.androidcallblocker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contactList;
    private List<Contact> contactListFull;
    private final OnContactActionListener actionListener;
    public ContactAdapter(List<Contact> contactList, OnContactActionListener actionListener) {
        this.contactList = contactList;
        this.contactListFull = new ArrayList<>(contactList);
        this.actionListener = actionListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameTextView.setText(contact.getName());
        holder.phoneTextView.setText(contact.getPhoneNumber());

        // Set up click listeners for edit and delete buttons
        holder.editButton.setOnClickListener(v -> actionListener.onEdit(contact));
        holder.deleteButton.setOnClickListener(v -> actionListener.onDelete(contact));
    }

    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
        this.contactListFull = new ArrayList<>(contactList); // Update full list for filtering
        notifyDataSetChanged();
    }

    public List<Contact> getContactList() {
        return new ArrayList<>(contactList); // Return a copy to prevent external modification
    }

    public void filter(String text) {
        if (text.isEmpty()) {
            contactList.clear();
            contactList.addAll(contactListFull);
        } else {
            String filterPattern = text.toLowerCase().trim();
            List<Contact> filteredList = new ArrayList<>();
            for (Contact item : contactListFull) {
                if (item.getName().toLowerCase().contains(filterPattern)) {
                    filteredList.add(item);
                }
            }
            contactList.clear();
            contactList.addAll(filteredList);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView phoneTextView;
        ImageButton editButton;
        ImageButton deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
    public interface OnContactActionListener {
        void onEdit(Contact contact);
        void onDelete(Contact contact);
    }

}
