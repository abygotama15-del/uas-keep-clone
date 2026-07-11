package cc.armdwn;

import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Connection conn = Database.connect(); Scanner scanner = new Scanner(System.in)) {
            NoteDAO dao = new NoteDAO(conn);
            dao.createTable();
            
            while (true) {
                System.out.println("\n=== Google Keep CLI ===");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Lihat Catatan");
                System.out.println("3. Edit Catatan");
                System.out.println("4. Hapus Catatan");
                System.out.println("5. Keluar");
                System.out.print("Pilihan: ");
                
                String choice = scanner.nextLine();
                
                try {
                    if (choice.equals("1")) {
                        System.out.print("Judul: "); String title = scanner.nextLine();
                        System.out.print("Isi: "); String content = scanner.nextLine();
                        dao.addNote(title, content);
                        System.out.println("Catatan disimpan!");
                        
                    } else if (choice.equals("2")) {
                        System.out.println("\n--- Daftar Catatan ---");
                        dao.showNotes();
                        System.out.println("----------------------");
                        
                    } else if (choice.equals("3")) {
                        System.out.print("Masukkan ID Catatan yang akan diedit: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Judul Baru: "); String title = scanner.nextLine();
                        System.out.print("Isi Baru: "); String content = scanner.nextLine();
                        dao.updateNote(id, title, content);
                        
                    } else if (choice.equals("4")) {
                        System.out.print("Masukkan ID Catatan yang akan dihapus: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        dao.deleteNote(id);
                        
                    } else if (choice.equals("5")) {
                        System.out.println("Menutup aplikasi...");
                        break;
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Pastikan Anda memasukkan ANGKA untuk ID!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}