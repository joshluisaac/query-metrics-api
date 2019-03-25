package com.avantsystems.aws.components;

import com.avantsystems.aws.QueryMetricsService;
import dagger.Component;

@Component
public interface QueryMetricsServiceComponent {

    QueryMetricsService getQueryMetricsService();



}
