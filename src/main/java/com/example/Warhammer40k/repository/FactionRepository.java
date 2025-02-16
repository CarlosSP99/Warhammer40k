package com.example.Warhammer40k.repository;

import com.example.Warhammer40k.model.Faction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FactionRepository extends JpaRepository<Faction, Long> {

}
