package com.fbytes.radiola.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by S on 13.06.2016.
 */


@Entity
@Table(name = "STREAM")
public class RadioStream implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    private String  url;
    private Integer quality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RADIO_ID", nullable = false)
    private Radio radio;

    public RadioStream(){
        id=0;
    }

    public RadioStream(Integer id,String url,Integer quality){
        this.id=id;
        this.url=url;
        this.quality=quality;
    }

    // ----------------- Getters/Setters ------------------

    public int getId(){ return id;}

    public void setId(int id){
        this.id=id;
    }


    public void setUrl(String url){
        this.url=url;
    }

    public String getUrl(){
        return url;
    }

    public void setQuality(Integer quality){
        this.quality=quality;
    }

    public Integer getQuality(){
        return quality;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "radio_id", nullable = false)
    @JsonBackReference
    public Radio getRadio(){
        return radio;
    }


    public void setRadio(Radio radio){
        this.radio=radio;
    }*/
}
