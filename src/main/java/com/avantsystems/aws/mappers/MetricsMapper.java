package com.avantsystems.aws.mappers;

import com.avantsystems.aws.entities.MetricsMapperBuilder;
import com.avantsystems.aws.entities.QueryMetrics;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * Maps/transforms the various log line tokens into {@link QueryMetrics}
 */
public class MetricsMapper {

    /**
     * Parses the timestamp section of the log lines into valid JDBC {@link Timestamp}
     * @param columns
     * @return
     */
    private static String mapTimestamp(String[] columns){
        return columns[0] +" "+columns[1].split("\\,")[0] +"."+columns[1].split("\\,")[1];
    }

    /**
     * Transforms log lines into tokens.
     *
     * @param columns
     * @return {@link QueryMetrics}
     */
    public QueryMetrics buildMetrics(String[] columns){
        return new MetricsMapperBuilder()
                .dateTime(Timestamp.valueOf(mapTimestamp(columns)))
                .queryName(columns[4])
                .runningTime(Long.parseLong(columns[5]))
                .mode(columns[8])
                .eventName(columns[9])
                .create();
    }

    /**
     * Collates a list of already transformed {@link QueryMetrics}
     *
     * @param list log lines
     * @return a {@link List} of {@link QueryMetrics}
     */
    public List<QueryMetrics> map (List<String> list){
        List<QueryMetrics> qm = new ArrayList<>();
        for (String s: list) {
         String[] columns = s.split("\\s+");
            qm.add(buildMetrics(columns));
        }
        return qm;
    }

}
