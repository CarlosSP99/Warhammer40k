package com.example.Warhammer40k.model.dto;

import com.example.Warhammer40k.model.Astarte;

public class AstarteDTO {
    private Long id;
    private String name;
    private String chapter;
    private String armortype;
    private String loyalty;
    private String image;
    private String faction;
    private String subFaction;
    private String book;

    public AstarteDTO(Astarte astarte) {
        id = astarte.getId();
        name = astarte.getName();
        chapter = astarte.getChapter();
        armortype = astarte.getArmortype();
        loyalty = astarte.getLoyalty();
        image = astarte.getImage();
        if (astarte.getFaction()!= null){
            faction = astarte.getFaction().getFaction();
            subFaction = astarte.getFaction().getSubfaction();
        }
        book = astarte.getBook();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getSubFaction() {
        return subFaction;
    }

    public void setSubFaction(String subFaction) {
        this.subFaction = subFaction;
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


    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
