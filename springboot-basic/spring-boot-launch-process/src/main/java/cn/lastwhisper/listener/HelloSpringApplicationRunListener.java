package cn.lastwhisper.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    /**
     * 必须有的构造器
     *
     * Exception in thread "main" java.lang.IllegalArgumentException: Cannot instantiate interface org.springframework.boot.SpringApplicationRunListener : cn.lastwhisper.listener.HelloSpringApplicationRunListener
     * 	at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:445)
     * 	at org.springframework.boot.SpringApplication.getSpringFactoriesInstances(SpringApplication.java:427)
     * 	at org.springframework.boot.SpringApplication.getRunListeners(SpringApplication.java:416)
     * 	at org.springframework.boot.SpringApplication.run(SpringApplication.java:304)
     * 	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237)
     * 	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226)
     * 	at cn.lastwhisper.LaunchProcessApplication.main(LaunchProcessApplication.java:10)
     * Caused by: java.lang.NoSuchMethodException: cn.lastwhisper.listener.HelloSpringApplicationRunListener.<init>(org.springframework.boot.SpringApplication, [Ljava.lang.String;)
     * 	at java.lang.Class.getConstructor0(Class.java:3082)
     * 	at java.lang.Class.getDeclaredConstructor(Class.java:2178)
     * 	at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:440)
     *
     * @param application application
     * @param args args
     */
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){

    }


    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener...starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared.."+o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...started...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener...context...");
    }
}
