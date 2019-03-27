package com.avantsystems.aws.services;

import com.avantsystems.aws.components.QueryLogParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.*;
import java.util.List;
import java.util.function.Predicate;

public class QueryMetricsService implements IQueryMetricsService {

    private static final Logger LOG = LoggerFactory.getLogger(QueryMetricsService.class);

    public QueryLogParser queryLogParser;

    @Inject
    public QueryMetricsService(QueryLogParser queryLogParser){
        this.queryLogParser = queryLogParser;
    }

    public List<String> processStream(final InputStream inputStream, Predicate<String> predicate) throws IOException {
        return queryLogParser.fetchMatchedRecords(inputStream,predicate);
    }





    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        LOG.info("Total memory used: {} MB",(memoryAfter/1000f)/1000f);
    }

}
