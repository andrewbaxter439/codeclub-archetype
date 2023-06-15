package $package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class ${app_name}Test
{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void runs() {
        ${app_name} test_app = new ${app_name}();
        Assertions.assertInstanceOf(${app_name}.class, test_app);
    }

    @Test
    public void helpOutput() {
        ${app_name}.main(new String[]{"-h"});
        Assertions.assertTrue(outputStreamCaptor.toString().contains("Usage"));
    }
}
