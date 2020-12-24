package cn.lastwhisper;

import cn.lastwhisper.properties.Dog;
import cn.lastwhisper.properties.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
class ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    Dog dog;

    @Test
    void testPerson() {
        System.out.println(person);
    }

    @Test
    void testDog() {
        System.out.println(dog);
    }


}
