package com.fbytes.radiola.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by S on 26.05.2016.
 */


@Entity
@Table(name = "RADIO")
public class RadioImg implements Serializable{

    private Integer id;

    @Lob
    private Blob radioImg;


    public RadioImg(){
        this.id=0;
    }

    public RadioImg(int id, String name) {
        this.id = id;
    }


    // ----------------- Getters/Setters ------------------
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public int getId(){ return id;}


    public void setId(int id){
        this.id=id;
    }


    public Blob getRadioImg(){ return radioImg;}

    public void setRadioImg(Blob radioImg){
        this.radioImg=radioImg;
    }


}
