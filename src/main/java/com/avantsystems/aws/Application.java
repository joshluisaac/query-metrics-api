package com.avantsystems.aws;

import dagger.Component;


@Component
interface QueryComponent {

    public QueryMetricsService getQueryMetricsService();
}


public class Application {

    private QueryMetricsService queryMetricsService;


    void execute(){
        //QueryMetricsServiceComponent component =


    }



    public static void main(String[] args) {




    }

}
