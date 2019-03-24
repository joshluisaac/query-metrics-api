package com.avantsystems.aws;

import java.sql.Timestamp;

public class MetricsMapperBuilder {


    private QueryMetrics metrics;
    private Timestamp dateTime;
    private String queryName;
    private long runningTime;
    private String mode;
    private String eventName;


    public MetricsMapperBuilder dateTime(Timestamp dateTime){
        this.dateTime = dateTime;
        return this;
    }

    public MetricsMapperBuilder queryName(String queryName){
        this.queryName = queryName;
        return this;
    }

    public MetricsMapperBuilder runningTime(long runningTime){
        this.runningTime = runningTime;
        return this;
    }

    public MetricsMapperBuilder mode(String mode){
        this.mode = mode;
        return this;
    }


    public MetricsMapperBuilder eventName(String eventName){
        this.eventName = eventName;
        return this;
    }

    public QueryMetrics create(){
        this.metrics = new QueryMetrics(dateTime,queryName,runningTime,mode,eventName);
        return this.metrics;
    }



}
