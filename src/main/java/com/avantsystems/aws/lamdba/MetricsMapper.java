package com.avantsystems.aws.lamdba;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MetricsMapper {

    private static String mapTimestamp(String[] columns){
        return columns[0] +" "+columns[1].split("\\,")[0] +"."+columns[1].split("\\,")[1];
    }

    public QueryMetrics buildMetrics(String[] columns){
        return new MetricsMapperBuilder()
                .dateTime(Timestamp.valueOf(mapTimestamp(columns)))
                .queryName(columns[4])
                .runningTime(Long.parseLong(columns[5]))
                .mode(columns[8])
                .eventName(columns[9])
                .create();
    }


    public List<QueryMetrics> map (List<String> list){
        List<QueryMetrics> qm = new ArrayList<>();
        for (String s: list) {
         String[] columns = s.split("\\s+");
            qm.add(buildMetrics(columns));
        }
        return qm;
    }

}
