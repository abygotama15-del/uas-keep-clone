package cc.armdwn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NoteDAOTest {

    @Test
    public void testCreateTable() throws SQLException {
        Connection mockConn = mock(Connection.class);
        Statement mockStmt = mock(Statement.class);
        when(mockConn.createStatement()).thenReturn(mockStmt);

        NoteDAO dao = new NoteDAO(mockConn);
        dao.createTable();

        verify(mockStmt).execute(anyString());
    }

    @Test
    public void testAddNote() throws SQLException {
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockStmt = mock(PreparedStatement.class);
        when(mockConn.prepareStatement(anyString())).thenReturn(mockStmt);

        NoteDAO dao = new NoteDAO(mockConn);
        dao.addNote("Judul", "Isi");

        verify(mockStmt).setString(1, "Judul");
        verify(mockStmt).setString(2, "Isi");
        verify(mockStmt).executeUpdate();
    }

    @Test
    public void testShowNotes() throws SQLException {
        Connection mockConn = mock(Connection.class);
        Statement mockStmt = mock(Statement.class);
        ResultSet mockRs = mock(ResultSet.class);
        
        when(mockConn.createStatement()).thenReturn(mockStmt);
        when(mockStmt.executeQuery(anyString())).thenReturn(mockRs);
        when(mockRs.next()).thenReturn(true, false);
        when(mockRs.getInt("id")).thenReturn(1);
        when(mockRs.getString("title")).thenReturn("Judul");
        when(mockRs.getString("content")).thenReturn("Isi");

        NoteDAO dao = new NoteDAO(mockConn);
        dao.showNotes();

        verify(mockRs, times(2)).next();
    }

    @Test
    public void testUpdateNote() throws SQLException {
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockStmt = mock(PreparedStatement.class);
        when(mockConn.prepareStatement(anyString())).thenReturn(mockStmt);
        when(mockStmt.executeUpdate()).thenReturn(1);

        NoteDAO dao = new NoteDAO(mockConn);
        dao.updateNote(1, "Judul Baru", "Isi Baru");

        verify(mockStmt).setString(1, "Judul Baru");
        verify(mockStmt).setString(2, "Isi Baru");
        verify(mockStmt).setInt(3, 1);
        verify(mockStmt).executeUpdate();
    }

    @Test
    public void testDeleteNote() throws SQLException {
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockStmt = mock(PreparedStatement.class);
        when(mockConn.prepareStatement(anyString())).thenReturn(mockStmt);
        when(mockStmt.executeUpdate()).thenReturn(1);

        NoteDAO dao = new NoteDAO(mockConn);
        dao.deleteNote(1);

        verify(mockStmt).setInt(1, 1);
        verify(mockStmt).executeUpdate();
    }
}