package com.fbytes.radiola.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "RADIOGROUP", uniqueConstraints = {
@UniqueConstraint(columnNames = "NAME")})
public class RadioGroup implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    private String name;
    private Integer version=0;

/*
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="GROUP_ID", referencedColumnName="ID")
    @ElementCollection(targetClass=Radio.class)
*/


    //@JsonIgnore
    @OneToMany(targetEntity=Radio.class,mappedBy = "radioGroup",fetch = FetchType.EAGER,cascade = CascadeType.ALL) //fetch = FetchType.EAGER,
    private Set<Radio> itemsList =new HashSet<Radio>(0);


//    @Lob
//    @Column(length = 104857600, nullable = false)
//    private byte[] radioImg;

    public RadioGroup(){
        this.id=0;
        name="New group";
    }

    public RadioGroup(int id, String name) {
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




/*
    @OneToMany
    @JoinTable
            (
                    name="STREAM",
                    joinColumns={ @JoinColumn(name="ID", referencedColumnName="ID") },
                    inverseJoinColumns={ @JoinColumn(name="RADIO_ID", referencedColumnName="ID", unique=true) }
            )
*/



    public Set<Radio> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(Set<Radio> itemsList) {
        this.itemsList = itemsList;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
