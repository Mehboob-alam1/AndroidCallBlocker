package com.mehboob.androidcallblocker.entitites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "blocked_numbers")
public class BlockedNumber {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="phoneNumber")

    public String phoneNumber;
    @ColumnInfo(name="blockedTime")

    public long blockedTime;  // Time of the blocked call in milliseconds

    public BlockedNumber(String phoneNumber, long blockedTime) {
        this.phoneNumber = phoneNumber;
        this.blockedTime = blockedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(long blockedTime) {
        this.blockedTime = blockedTime;
    }

    @Override
    public String toString() {
        return "BlockedNumber{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", blockedTime=" + blockedTime +
                '}';
    }
}
