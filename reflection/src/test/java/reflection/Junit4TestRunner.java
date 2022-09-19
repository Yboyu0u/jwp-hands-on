package reflection;

import static reflection.Junit3TestRunner.invoke;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;
        Junit4Test instance = clazz.getConstructor().newInstance();
        Stream.of(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(MyTest.class))
                .forEach(method -> invoke(instance, method));
    }
}
