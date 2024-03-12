package com.zavadimka.config;

import org.aeonbits.owner.ConfigFactory;

public class DriverConfig {
    private final String destination;
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public DriverConfig(String destination) {
        this.destination = destination;
    }

    public String remoteUrl= webDriverConfig.getDriverRemoteUrl();
    public String baseUrl= webDriverConfig.getBaseUrl();
    public String browserName = webDriverConfig.getBrowserName();
    public String browserVersion = webDriverConfig.getBrowserVersion();
    public String browserSize = webDriverConfig.getBrowserSize();

    public void printDriverConfig(){
        System.out.println("The test is run with the following parameters:");
        System.out.printf("Destination: %s\n" +
                        "Remote URL: %s\n" +
                        "Base URL: %s\n" +
                        "Browser: %s\n" +
                        "Version: %s\n" +
                        "Window size: %s%n",
                destination, remoteUrl, baseUrl, browserName, browserVersion, browserSize);
    }
}
