package cc.armdwn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NoteTest {
    @Test
    public void testNotePOJO() {
        Note note = new Note(1, "Judul", "Isi");
        assertEquals(1, note.id);
        assertEquals("Judul", note.title);
        assertEquals("Isi", note.content);
    }
}