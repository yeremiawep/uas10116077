//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1

package com.example.infoTourism.Model;

public class Category {

    private String  Nama;
    private String Image;
    private String Description;
    private String Fasilitas;
    private String Spesifikasi;
    private String LinkWeb;


    public Category() {

    }


    public Category(String nama, String image, String decription ,String fasilitas ,String spesifikasi ,String linkweb) {

        Nama = nama;
        Image = image;
        Description = decription;
        Fasilitas = fasilitas;
        Spesifikasi = spesifikasi;
        LinkWeb = linkweb;

    }

    public String getNama() {
        return Nama;

    }
    public void setNama (String nama) {

        Nama = nama;


    }
    public String getImage() {

        return Image;

    }

    public void setImage(String image)

    {
        Image = image;

    }


    public String getDescription() {

        return Description;

    }

    public void setDescription(String description)

    {
        Description = description;

    }
    public String getFasilitas() {

        return Fasilitas;

    }

    public void setFasilitas(String fasilitas)

    {
        Fasilitas = fasilitas;

    }
    public String getSpesifikasi() {

        return Spesifikasi;

    }

    public void setSpesifikasi(String spesifikasi)

    {
       Spesifikasi = spesifikasi;

    }
    public String getLinkWeb() {

        return LinkWeb;

    }

    public void setLinkWeb(String linkweb)

    {
        LinkWeb = linkweb;

    }









}

