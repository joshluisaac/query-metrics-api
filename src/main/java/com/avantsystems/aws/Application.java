package com.avantsystems.aws;


import com.avantsystems.aws.components.DaggerQueryMetricsServiceComponent;
import com.kollect.etl.util.FileUtils;
import com.kollect.etl.util.JsonUtils;
import com.kollect.etl.util.StringUtils;

import java.io.*;
import java.util.List;
import java.util.function.Predicate;





public class Application  {

    private static final String REGEX = "(\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+):(\\d+),(\\d+) DEBUG Query";
    private static final String FILE_NAME = "/home/joshua/Desktop/kollectlogs/ServiceEngine-2018Jun21203756.log";
    private QueryMetricsService queryMetricsService;

    public Application(){
        queryMetricsService = DaggerQueryMetricsServiceComponent.create().getQueryMetricsService();
    }

    List<String> execute(InputStream inputStream) throws Exception{
        Predicate<String> predicate = s -> new StringUtils().hasMatch(s,REGEX);
        return queryMetricsService.processStream(inputStream,predicate);
    }



    public static void main(String[] args) throws Exception {
        List<String> lines = new Application().execute(new FileInputStream(new File(FILE_NAME)));
        System.out.println(lines.size());
        String jsonText = new JsonUtils().toJson(new MetricsMapper().map(lines));

        FileUtils.writeToDataStore(new File("log.json"),jsonText);

    }

}
