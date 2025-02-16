package com.example.Warhammer40k.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "faction")
public class Faction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faction_id_gen")
    @SequenceGenerator(name = "faction_id_gen", sequenceName = "faction_id_seq1", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "faction")
    private String faction;

    @Column(name = "subfaction")
    private String subfaction;

    @OneToMany(mappedBy = "faction")
    private Set<Astarte> astartes = new LinkedHashSet<>();

    public Faction() {

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

    public Set<Astarte> getAstartes() {
        return astartes;
    }

    public void setAstartes(Set<Astarte> astartes) {
        this.astartes = astartes;
    }

    public Faction(Long id, String faction, String subfaction, Set<Astarte> astartes) {
        this.id = id;
        this.faction = faction;
        this.subfaction = subfaction;
        this.astartes = astartes;
    }
}