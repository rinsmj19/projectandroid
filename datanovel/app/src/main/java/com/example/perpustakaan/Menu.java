package com.example.perpustakaan;

public class Menu {
    private String nama;
    private String harga;
    private String gambar;
    private String detail;

    public Menu(String datanama, String dataharga, String datagambar, String datadetail) {
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        detail = datadetail;
    }
        public String getNama () {
            return nama;
        }

        public String getHarga () {
            return harga;
        }

        public String getGambar () {
            return gambar;
        }

        public String getDetail () {
            return detail;
        }
    }