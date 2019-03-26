package com.avantsystems.aws.services;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Predicate;

public interface IQueryMetricsService {

    public List<String> processStream(final InputStream inputStream, Predicate<String> predicate) throws IOException;
}
