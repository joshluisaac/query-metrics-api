package com.avantsystems.aws.lamdba;


import com.kollect.etl.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class QueryMetricsService {

    private static final Logger LOG = LoggerFactory.getLogger(QueryMetrics.class);
    private static final String REGEX = "(\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+):(\\d+),(\\d+) DEBUG Query";
    private static final String FILE_NAME = "/home/joshua/Desktop/kollectlogs/ServiceEngine-2018Jun21203756.log";


    public static List<String> readFile(final File f, Predicate<String> predicate) throws IOException {
        try (BufferedReader bufReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(f)));) {
            String line;
            List<String> list = new ArrayList<>();
            while ((line = bufReader.readLine()) != null) {
                if (predicate.test(line)) list.add(line);
            }
            return list;
        }
    }



    public static void main(String[] args) throws Exception {
        List<String> lines = QueryMetricsService.readFile(new File(FILE_NAME),s -> new StringUtils().hasMatch(s, REGEX));
        System.out.println(lines.size());
        System.out.println(new MetricsMapper().map(lines).get(9).toString());;

        Runtime runtime = Runtime.getRuntime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        LOG.info("Total memory used: {} MB",(memoryAfter/1000f)/1000f);


    }

}
