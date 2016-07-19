package com.example.artur.exp_mobile_android.model.entities;

/**
 * Created by artur on 19.07.16.
 */
public enum ExpOpportunityStatus {
    OPEN,
    IN_PROGRESS,
    MATCHED,
    REALIZED,
    REMOVED;

    public static ExpOpportunityStatus fromString(String stringStatus) {
        stringStatus = stringStatus.toLowerCase();
        if (stringStatus.contains("open")) {
            return ExpOpportunityStatus.OPEN;
        } else if (stringStatus.contains("in_progress")) {
            return ExpOpportunityStatus.IN_PROGRESS;
        } else if (stringStatus.contains("matched")) {
            return ExpOpportunityStatus.MATCHED;
        } else if (stringStatus.contains("realized")) {
            return ExpOpportunityStatus.REALIZED;
        } else if (stringStatus.contains("removed")) {
            return ExpOpportunityStatus.REMOVED;
        } else {
            return null;
        }
    }
}
