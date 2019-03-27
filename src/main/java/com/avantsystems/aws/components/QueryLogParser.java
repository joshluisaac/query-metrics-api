package com.avantsystems.aws.components;

import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class QueryLogParser {

    @Inject
    public QueryLogParser() {
    }

    /**
     * Fetches records which matches the specified predicate.
     *
     * @param inputStream
     * @param predicate
     * @return
     * @throws IOException
     */
    public List<String> fetchMatchedRecords(final InputStream inputStream, Predicate<String> predicate) throws IOException {
        try (BufferedReader bufReader = new BufferedReader(
                new InputStreamReader(inputStream))) {
            String line;
            List<String> list = new ArrayList<>();
            while ((line = bufReader.readLine()) != null) {
                if (predicate.test(line)) list.add(line);
            }
            return list;
        }
    }


}
