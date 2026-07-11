# Dokumentasi Testing - UAS Google Keep Clone (CLI)

## 1. Lingkungan Pengujian
- **Bahasa Pemrograman:** Java 24
- **Framework Testing:** JUnit Jupiter (JUnit 5)
- **Framework Mocking:** Mockito 5
- **Tool Coverage:** JaCoCo 0.8.12

## 2. Struktur Pengujian & Mocking
Pengujian dilakukan pada class `NoteDAO` menggunakan metode **Mocking**. Koneksi ke database (`java.sql.Connection`) dan eksekusi query diisolasi menggunakan Mockito agar pengetesan tidak mengubah isi database asli.

### Kasus Uji yang Dijalankan:
- `AppTest.java`: Memastikan runtime pengujian JUnit berjalan.
- `NoteDAOTest.java`:
  - `testCreateTable()`: Memastikan eksekusi query pembuatan tabel.
  - `testAddNote()`: Memastikan query `INSERT` dengan parameter judul dan isi.
  - `testShowNotes()`: Memastikan query `SELECT` dan iterasi data dari `ResultSet`.
  - `testUpdateNote()`: Memastikan query `UPDATE` dengan parameter ID, judul baru, dan isi baru.
  - `testDeleteNote()`: Memastikan query `DELETE` dieksekusi berdasarkan ID.

## 3. Hasil Pengujian
Aplikasi berhasil melewati seluruh tahapan kompilasi dan pengujian dengan status:
- **Total Tests Run:** 6
- **Failures:** 0
- **Errors:** 0
- **Skipped:** 0
- **Build Status:** SUCCESS

## 4. Cara Menjalankan Uji Mandiri
```bash
mvn clean test