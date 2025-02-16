package com.example.Warhammer40k.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "astarte")
public class Astarte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "astarte_id_gen")
    @SequenceGenerator(name = "astarte_id_gen", sequenceName = "astarte_id_seq1", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chapter")
    private String chapter;

    @Column(name = "armortype")
    private String armortype;

    @Column(name = "loyalty")
    private String loyalty;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "faction_id")
    private Faction faction;

    @Column(name = "book")
    private String book;

    public Astarte() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getArmortype() {
        return armortype;
    }

    public void setArmortype(String armortype) {
        this.armortype = armortype;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Astarte(Long id, String name, String chapter, String armortype, String loyalty, String image, Faction faction, String book) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
        this.armortype = armortype;
        this.loyalty = loyalty;
        this.image = image;
        this.faction = faction;
        this.book = book;
    }
}