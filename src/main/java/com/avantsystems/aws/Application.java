package com.avantsystems.aws;


import com.avantsystems.aws.components.DaggerQueryMetricsServiceComponent;
import com.avantsystems.aws.configs.Constants;
import com.avantsystems.aws.mappers.MetricsMapper;
import com.avantsystems.aws.services.IQueryMetricsService;
import com.avantsystems.util.FileUtils;
import com.avantsystems.util.JsonUtils;
import com.avantsystems.util.StringUtils;

import java.io.*;
import java.util.List;
import java.util.function.Predicate;


public class Application  {

    private IQueryMetricsService queryMetricsService;

    public Application(){
        queryMetricsService = DaggerQueryMetricsServiceComponent.create().getQueryMetricsService();
    }

    List<String> execute(InputStream inputStream) throws Exception{
        Predicate<String> predicate = s -> new StringUtils().hasMatch(s, Constants.REGEX);
        return queryMetricsService.processStream(inputStream,predicate);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new Application().execute(new FileInputStream(new File(Constants.FILE_NAME)));
        System.out.println(lines.size());
        String jsonText = new JsonUtils().toJson(new MetricsMapper().map(lines));
        FileUtils.writeToDataStore(new File("log.json"),jsonText);
    }
}
