package com.avantsystems.aws.lamdba;

public interface IQueryMetricsService {

    public List<String> readFile(final File f, Predicate<String> predicate) throws IOException;
}
