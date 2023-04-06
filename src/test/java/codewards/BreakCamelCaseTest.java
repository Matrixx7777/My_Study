package codewards;

import my.task.codewards.BreakCamelCase;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreakCamelCaseTest {
    @Test
    public void tests() {
        assertEquals( "Incorrect", "camel Casing", BreakCamelCase.camelCase("camelCasing"));
        assertEquals( "Incorrect", "camel Casing Test", BreakCamelCase.camelCase("camelCasingTest"));
        assertEquals( "Incorrect", "camelcasingtest", BreakCamelCase.camelCase("camelcasingtest"));
    }
}