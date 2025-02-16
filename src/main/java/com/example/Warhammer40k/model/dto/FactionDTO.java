package com.example.Warhammer40k.model.dto;

import com.example.Warhammer40k.model.Faction;

public class FactionDTO {
    public Long id;
    public String faction;
    public String subfaction;

    public FactionDTO(Faction faction) {
        id = faction.getId();
        this.faction = faction.getFaction();
        subfaction = faction.getSubfaction();
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

    public String getSubfaction() {
        return subfaction;
    }

    public void setSubfaction(String subfaction) {
        this.subfaction = subfaction;
    }
}
