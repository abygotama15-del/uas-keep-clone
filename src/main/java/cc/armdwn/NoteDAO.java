package cc.armdwn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NoteDAO {
    private Connection conn;

    public NoteDAO(Connection conn) {
        this.conn = conn;
    }

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS notes (id SERIAL PRIMARY KEY, title VARCHAR(255), content TEXT)";
        try (Statement stmt = conn.createStatement()) { stmt.execute(sql); }
    }

    public void addNote(String title, String content) throws SQLException {
        String sql = "INSERT INTO notes (title, content) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
        }
    }

    public void showNotes() throws SQLException {
        String sql = "SELECT * FROM notes ORDER BY id ASC";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.println("[" + rs.getInt("id") + "] " + rs.getString("title") + " - " + rs.getString("content"));
            }
            if (!hasData) {
                System.out.println("Belum ada catatan.");
            }
        }
    }

    public void updateNote(int id, String newTitle, String newContent) throws SQLException {
        String sql = "UPDATE notes SET title = ?, content = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newContent);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Catatan berhasil diperbarui!");
            } else {
                System.out.println("Gagal: Catatan dengan ID [" + id + "] tidak ditemukan.");
            }
        }
    }
    
    public void deleteNote(int id) throws SQLException {
        String sql = "DELETE FROM notes WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Catatan berhasil dihapus!");
            } else {
                System.out.println("Gagal: Catatan dengan ID [" + id + "] tidak ditemukan.");
            }
        }
    }
}