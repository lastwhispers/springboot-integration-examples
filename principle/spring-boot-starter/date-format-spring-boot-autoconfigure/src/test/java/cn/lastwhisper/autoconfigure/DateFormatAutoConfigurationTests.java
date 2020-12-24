package cn.lastwhisper.autoconfigure;


import org.junit.After;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class DateFormatAutoConfigurationTests {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

}
