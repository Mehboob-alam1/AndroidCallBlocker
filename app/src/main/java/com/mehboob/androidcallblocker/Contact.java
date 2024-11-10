package com.mehboob.androidcallblocker;

public class Contact {
    private String id; // Unique ID in the contacts database
    private String name;
    private String phoneNumber;

        public Contact(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters for id, name, and phoneNumber
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
