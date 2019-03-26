package com.avantsystems.aws.entities;

import java.sql.Timestamp;


public class QueryMetrics {

    Timestamp dateTime;
    String queryName;
    long runningTime;
    String mode;
    String eventName;

    public QueryMetrics(){}

    public QueryMetrics(Timestamp dateTime, String queryName, long runningTime, String mode, String eventName) {
        this.dateTime = dateTime;
        this.queryName = queryName;
        this.runningTime = runningTime;
        this.mode = mode;
        this.eventName = eventName;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(long runningTime) {
        this.runningTime = runningTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    @Override
    public String toString() {
        return "QueryMetrics{" +
                "dateTime=" + dateTime +
                ", queryName='" + queryName + '\'' +
                ", runningTime=" + runningTime +
                ", mode='" + mode + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
