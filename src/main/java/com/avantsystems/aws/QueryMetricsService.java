package com.avantsystems.aws;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.*;
import java.util.List;
import java.util.function.Predicate;

public class QueryMetricsService {

    public QueryLog queryLog;

    @Inject
    public QueryMetricsService(QueryLog queryLog){
        this.queryLog = queryLog;
    }

    private static final Logger LOG = LoggerFactory.getLogger(QueryMetrics.class);



    public List<String>  processStream(final InputStream inputStream, Predicate<String> predicate) throws IOException {
        return queryLog.fetchMatchedRecords(inputStream,predicate);
    }





    public static void main(String[] args) throws Exception {
        //List<String> lines = QueryMetricsService.readFile(new File(FILE_NAME),s -> new StringUtils().hasMatch(s, REGEX));
        //System.out.println(lines.size());
        //System.out.println(new MetricsMapper().map(lines).get(9).toString());
        Runtime runtime = Runtime.getRuntime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        LOG.info("Total memory used: {} MB",(memoryAfter/1000f)/1000f);
    }

}
