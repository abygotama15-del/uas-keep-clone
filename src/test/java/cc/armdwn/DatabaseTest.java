package cc.armdwn;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DatabaseTest {
    @Test
    public void testConnection() throws Exception {
        try (Connection conn = Database.connect()) {
            assertNotNull(conn);
        }
    }
}