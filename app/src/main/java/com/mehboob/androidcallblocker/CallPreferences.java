package com.mehboob.androidcallblocker;



import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class CallPreferences {

    private static final String PREFS_NAME = "CallHandlerPrefs";
    private static final String KEY_PREFIXES = "prefix_list";
    private static final String KEY_WHITELIST = "white_list";

    private SharedPreferences prefs;

    public CallPreferences(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public Set<String> getPrefixes() {
        return prefs.getStringSet(KEY_PREFIXES, new HashSet<>());
    }

    public Set<String> getWhiteList() {
        return prefs.getStringSet(KEY_WHITELIST, new HashSet<>());
    }

    public void addPrefix(String prefix) {
        Set<String> prefixes = getPrefixes();
        prefixes.add(prefix);
        prefs.edit().putStringSet(KEY_PREFIXES, prefixes).apply();
    }

    public void addWhiteListNumber(String number) {
        Set<String> whiteList = getWhiteList();
        whiteList.add(number);
        prefs.edit().putStringSet(KEY_WHITELIST, whiteList).apply();
    }

    public boolean isInWhiteList(String incomingNumber) {
        return getWhiteList().contains(incomingNumber);
    }

    public boolean hasValidPrefix(String incomingNumber) {
        for (String prefix : getPrefixes()) {
            if (incomingNumber.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
