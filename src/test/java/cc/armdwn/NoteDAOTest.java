package cc.armdwn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NoteDAOTest {
    @Test
    public void testAddNoteMocking() throws SQLException {
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockStmt = mock(PreparedStatement.class);
        when(mockConn.prepareStatement(anyString())).thenReturn(mockStmt);

        NoteDAO dao = new NoteDAO(mockConn);
        dao.addNote("Judul Mock", "Isi Mock");

        verify(mockStmt).setString(1, "Judul Mock");
        verify(mockStmt).setString(2, "Isi Mock");
        verify(mockStmt).executeUpdate();
    }
}