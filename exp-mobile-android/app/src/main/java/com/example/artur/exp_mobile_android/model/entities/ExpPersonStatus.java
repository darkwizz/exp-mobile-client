package com.example.artur.exp_mobile_android.model.entities;

/**
 * Created by artur on 19.07.16.
 */
public enum ExpPersonStatus {
    OPEN,
    APPLIED,
    ACCEPTED,
    REALIZED;

    public static ExpPersonStatus fromString(String stringStatus) {
        stringStatus = stringStatus.toLowerCase();
        if (stringStatus.contains("open")) {
            return ExpPersonStatus.OPEN;
        } else if (stringStatus.contains("applied")) {
            return ExpPersonStatus.APPLIED;
        } else if (stringStatus.contains("accepted")) {
            return ExpPersonStatus.ACCEPTED;
        } else if (stringStatus.contains("realized")) {
            return ExpPersonStatus.REALIZED;
        } else {
            return null;
        }
    }
}
