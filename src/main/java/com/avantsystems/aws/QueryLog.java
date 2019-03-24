package com.avantsystems.aws;

import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class QueryLog {

    @Inject
    public QueryLog() {
    }

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
