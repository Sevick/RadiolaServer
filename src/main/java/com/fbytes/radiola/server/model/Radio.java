package com.fbytes.radiola.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by S on 26.05.2016.
 */


@Entity
@Table(name = "RADIO", uniqueConstraints = {
@UniqueConstraint(columnNames = "NAME")})
public class Radio implements Serializable{

    static final String imgBasePath="http://10.0.0.2/rest/";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    private String name;
    private String site;
    private String playlist;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    RadioGroup radioGroup;

    private Integer version;
    /*
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="RADIO_ID", referencedColumnName="ID")
    @ElementCollection(targetClass=RadioStream.class)
    */
    //@ElementCollection(targetClass=RadioStream.class)
    @OneToMany(targetEntity=RadioStream.class,mappedBy = "radio",fetch = FetchType.EAGER,cascade = CascadeType.ALL) //fetch = FetchType.EAGER,
    private Set<RadioStream> streams =new HashSet<RadioStream>(0);


//    @Basic(fetch = FetchType.LAZY)
//    @Lob
//    @Column(length = 104857600, nullable = false)
//    private byte[] radioImg;

    public Radio(){
        this.id=0;
        name="New radio";
        site="http://";
    }

    public Radio(int id, String name) {
        this.id = id;
        this.name = name;
    }


    // ----------------- Getters/Setters ------------------

    public int getId(){ return id;}


    public void setId(int id){
        this.id=id;
    }


    public String getName(){ return name;}

    public void setName(String name){
        this.name=name;
    }

    public void setSite(String site){
        this.site=site;
    }

    public String getSite(){
        return site;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    /*
    @OneToMany
    @JoinTable
            (
                    name="STREAM",
                    joinColumns={ @JoinColumn(name="ID", referencedColumnName="ID") },
                    inverseJoinColumns={ @JoinColumn(name="RADIO_ID", referencedColumnName="ID", unique=true) }
            )
*/



    public Set<RadioStream> getStreams() {
        return this.streams;
    }

    public void setStreams(Set<RadioStream> streams) {
        this.streams = streams;
    }


    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public String getImgPath(){
        return imgBasePath+"getRadioImg?radio_id="+id;
    }
}
