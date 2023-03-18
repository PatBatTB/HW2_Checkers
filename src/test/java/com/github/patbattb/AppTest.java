package com.github.patbattb;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AppTest {
    @Test
    void helloTest() {
        Assertions.assertThat(2 + 2).isEqualTo(4);
    }

//    @Test
//    void otherStrTest() {
//        String a = sayHello();
//        Assertions.assertThat(a)
//                .startsWith("Hell")
//                .contains("llo, ")
//                .endsWith("!");
//    }

    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 2 out of bounds for length 2");
    }

    @RepeatedTest(5)
    void repeatedTest() {
        System.out.println("You will see this message five times");
    }
}
