package com.example.artur.exp_mobile_android.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by artur on 19.07.16.
 */
public class ExpOpportunity {
    private String expId;
    private String title;
    private int durationMinimal;
    private int durationMaximal;
    private Date earliestStartDate;
    private ExpProgramKind programKind;
    private ExpOpportunityStatus status;
    private List<ExpPerson> managers;

    public ExpOpportunity(String id) {
        expId = id;
        managers = new ArrayList<>();
    }

    public String getExpId() {
        return expId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMinimal() {
        return durationMinimal;
    }

    public void setDurationMinimal(int durationMinimal) {
        this.durationMinimal = durationMinimal;
    }

    public int getDurationMaximal() {
        return durationMaximal;
    }

    public void setDurationMaximal(int durationMaximal) {
        this.durationMaximal = durationMaximal;
    }

    public Date getEarliestStartDate() {
        return earliestStartDate;
    }

    public void setEarliestStartDate(Date earliestStartDate) {
        this.earliestStartDate = earliestStartDate;
    }

    public ExpProgramKind getProgramKind() {
        return programKind;
    }

    public void setProgramKind(ExpProgramKind programKind) {
        this.programKind = programKind;
    }

    public ExpOpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(ExpOpportunityStatus status) {
        this.status = status;
    }

    public List<ExpPerson> getManagers() {
        return managers;
    }
}
