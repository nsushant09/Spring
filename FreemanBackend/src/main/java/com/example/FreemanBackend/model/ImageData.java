package com.example.FreemanBackend.model;


import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = Constants.IMAGE_DATA_TABLE)
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private Blob image;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
