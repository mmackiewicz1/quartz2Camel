package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import javax.inject.Named;

@Named
public class CamelExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("quartz2://myGroup/myTimer?cron=0/5+*+*+*+*+?")
            .routeId("Example route id.")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    System.out.println("Server one: fired");
                }
            });
    }
}
