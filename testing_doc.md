# Dokumentasi Testing - UAS Google Keep Clone (CLI)

## 1. Lingkungan Pengujian
- **Bahasa Pemrograman:** Java 21
- **Framework Testing:** JUnit Jupiter (JUnit 5)
- **Framework Mocking:** Mockito 5
- **Tool Coverage:** JaCoCo 0.8.12

## 2. Struktur Pengujian & Mocking
Pengujian dilakukan secara menyeluruh pada komponen aplikasi, dengan fokus utama pada isolasi interaksi database menggunakan Mockito.
- `NoteDAOTest.java`: Pengujian operasi CRUD (Create, Read, Update, Delete) dengan Mocking untuk mencegah manipulasi data asli.
- `AppTest.java`: Pengujian alur input/output (I/O) pada menu utama CLI.
- `NoteTest.java`: Pengujian validasi struktur data objek (POJO).
- `DatabaseTest.java`: Pengujian inisiasi koneksi database.

### Kasus Uji yang Dijalankan:
- `AppTest.java` (Menguji menu CLI):
    -`testAppMenu()`: Memasukkan simulasi input keyboard (angka sembarang lalu angka 5 untuk keluar) untuk memastikan aplikasi tidak crash saat menerima input.
- `NoteDAOTest.java`(Menguji interaksi database dengan Mocking):
    - `testCreateTable()`: Memastikan perintah SQL `CREATE TABLE` dikirim ke database.
    - `testAddNote()`: Memastikan input judul dan isi diteruskan ke perintah SQL `INSERT`.
    - `testShowNotes()`: Memastikan perintah SQL `SELECT` dieksekusi dan membaca baris hasil.
    - `testUpdateNote()`: Memastikan input judul baru, isi baru, dan ID diteruskan ke perintah SQL `UPDATE`.
    - `testDeleteNote()`: Memastikan input ID diteruskan ke perintah SQL `DELETE`.
- `NoteTest.java` (Menguji objek data):
    - `testNotePOJO()`: Memastikan wadah objek Note berhasil menyimpan dan mengembalikan nilai ID, judul, dan isi secara akurat.
- `DatabaseTest.java` (Menguji koneksi):
    - `testConnection()`: Memastikan fungsi pembuka koneksi ke PostgreSQL berjalan dan tidak mengembalikan nilai kosong (null).

## 3. Hasil Pengujian
Aplikasi berhasil melewati seluruh tahapan kompilasi dan pengujian dengan status:
- **Total Tests Run:** 8
- **Failures:** 0
- **Errors:** 0
- **Skipped:** 0
- **Build Status:** SUCCESS

## 4. Cara Menjalankan Uji Mandiri
```bash
mvn clean test