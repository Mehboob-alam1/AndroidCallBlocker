package com.mehboob.androidcallblocker.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mehboob.androidcallblocker.entitites.BlockedNumber;

import java.util.List;

@Dao

public interface BlockedNumberDao {

    @Insert
    void insertBlockedNumber(BlockedNumber blockedNumber);

    @Query("SELECT * FROM blocked_numbers")
    List<BlockedNumber> getAllBlockedNumbers();
}
