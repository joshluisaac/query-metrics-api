package com.avantsystems.aws;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface IQueryMetricsService {

    public List<String> readFile(final File f, Predicate<String> predicate) throws IOException;
}
