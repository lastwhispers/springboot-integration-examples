package cn.cunchang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("http://localhost:8080/db1?id=1");
        System.out.println("http://localhost:8080/db2?id=1");
    }

}
