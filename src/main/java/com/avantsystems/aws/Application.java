package com.avantsystems.aws;

import com.avantsystems.aws.DaggerQueryMetricsServiceComponent;
import com.kollect.etl.util.StringUtils;
import dagger.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.function.Predicate;


@Component
interface QueryMetricsServiceComponent {

    QueryMetricsService getQueryMetricsService();
}


public class Application  {

    private static final String REGEX = "(\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+):(\\d+),(\\d+) DEBUG Query";
    private static final String FILE_NAME = "/home/joshua/Desktop/kollectlogs/ServiceEngine-2018Jun21203756.log";
    private QueryMetricsService queryMetricsService;

    public Application(){
        queryMetricsService = DaggerQueryMetricsServiceComponent.create().getQueryMetricsService();
    }


    void execute() throws Exception{

        Predicate<String> predicate = s -> new StringUtils().hasMatch(s,REGEX);
        queryMetricsService.processStream(new FileInputStream(new File(FILE_NAME)),predicate);
    }



    public static void main(String[] args) throws Exception {
        new Application().execute();
    }

}
