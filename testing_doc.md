# Dokumentasi Testing - UAS Google Keep Clone (CLI)

## 1. Lingkungan Pengujian
- **Bahasa Pemrograman:** Java 24
- **Framework Testing:** JUnit Jupiter (JUnit 5)
- **Framework Mocking:** Mockito 5
- **Tool Coverage:** JaCoCo 0.8.12

## 2. Struktur Pengujian & Mocking
Pengujian dilakukan pada class `NoteDAO` menggunakan metode **Mocking**. Koneksi ke database (`java.sql.Connection`) dan penyusunan query (`java.sql.PreparedStatement`) diisolasi menggunakan Mockito agar pengetesan tidak mengotori database PostgreSQL utama.

### Kasus Uji yang Dijalankan:
- `AppTest.java`: Memastikan runtime pengujian JUnit berjalan dengan baik.
- `NoteDAOTest.java`: Memastikan metode `addNote()` berhasil menyusun parameter query SQL `INSERT` dan mengeksekusi perintah database dengan benar melalui verifikasi mock object.

## 3. Hasil Pengujian
Aplikasi berhasil melewati seluruh tahapan kompilasi dan pengujian dengan status:
- **Total Tests Run:** 2
- **Failures:** 0 
- **Errors:** 0
- **Skipped:** 0
- **Build Status:** SUCCESS

## 4. Cara Menjalankan Uji Mandiri
```bash
mvn clean test