package com.example.Warhammer40k.service;

import com.example.Warhammer40k.model.Faction;
import com.example.Warhammer40k.model.dto.FactionDTO;
import com.example.Warhammer40k.repository.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FactionService {

    @Autowired
    private FactionRepository factionRepositoy;

    public List<FactionDTO> getAllFactions(){
       try{
           List<Faction> listOfFactions = factionRepositoy.findAll();
           List<FactionDTO> listOfFactionsDTO = new ArrayList<>();
           for (Faction faction : listOfFactions){
               FactionDTO f = new FactionDTO(faction);
               listOfFactionsDTO.add(f);
           }
           return listOfFactionsDTO;
       } catch (DataAccessException e) {
           throw new RuntimeException("Data not found");
       } catch (Exception e) {
           throw new RuntimeException("Unexpected error was found");
       }
    }

    public Optional<FactionDTO> getFactionById(Long id) {
        try {
            Optional<Faction> optFaction = factionRepositoy.findById(id);
            return optFaction.map(FactionDTO::new);
        } catch (DataAccessException e) {
            throw new RuntimeException("Data not found");
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error was found");

        }
    }

}
