package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View returned");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() throws ValueNotFoundException {
        assertThrows(ValueNotFoundException.class, () -> controller.oupsHandler());
        //assertTrue("asdf".equals(controller.oupsHandler()), () -> "This is some expensive" + "Message to build" + "For my test");
    }

    @Test
    void testTImeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Im taking too long!");
        });
    }

    @Test
    void testTImeoutPrempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Im taking too long!");
        });
    }

    @Test
    void testAssumptionTrue(){
        assumeTrue("TEST".equalsIgnoreCase(System.getenv("TEST_ENV")));
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows(){
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJRE8(){
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jdari")
    @Test
    void testIfUser(){}
}