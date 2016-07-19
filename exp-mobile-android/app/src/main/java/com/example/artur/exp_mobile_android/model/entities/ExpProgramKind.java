package com.example.artur.exp_mobile_android.model.entities;

/**
 * Created by artur on 19.07.16.
 */
public enum ExpProgramKind {
    GCDP,
    GIP,
    GT, // these last two kinds can be recognized with extra fields in data
    GE;

    public static ExpProgramKind fromString(String stringKind) {
        stringKind = stringKind.toUpperCase();
        if (stringKind.contains("GCDP") || stringKind.contains("GC")) {
            return ExpProgramKind.GCDP;
        } else if (stringKind.contains("GIP") || stringKind.contains("GT")) {
            return ExpProgramKind.GIP;
        } else {
            return null;
        }
    }
}
