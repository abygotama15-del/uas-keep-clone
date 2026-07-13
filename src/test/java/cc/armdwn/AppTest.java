package cc.armdwn;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testAppMenu() {
        InputStream originalIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream("99\n5\n".getBytes()));
            App.main(new String[]{});
        } finally {
            System.setIn(originalIn);
        }
    }
}