package com.example.Warhammer40k.service;

import com.example.Warhammer40k.model.Astarte;
import com.example.Warhammer40k.model.dto.AstarteDTO;
import com.example.Warhammer40k.repository.AstarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AstarteService {

    @Autowired
    private AstarteRepository astarteRepository;

    public Optional<AstarteDTO> getAstarteById (Long id){
      try{
          Optional<Astarte> optionalAstarte = astarteRepository.findById(id);
          return optionalAstarte.map(AstarteDTO::new);
      }  catch (DataAccessException e) {
          throw new RuntimeException("Data not found");
      } catch (Exception e) {
          throw new RuntimeException("Unexpected error was found");

      }
    }

    public Astarte addOneAstarte (Astarte astarte){
        return astarteRepository.save(astarte);
    }


    public List<AstarteDTO> getAllAstartes(){
        List<Astarte> listOfAstarte = astarteRepository.findAll();
        List<AstarteDTO> listOfAstarteDTO = new ArrayList<>();

        for (Astarte astarte : listOfAstarte){
            AstarteDTO astarteDTO = new AstarteDTO(astarte);
            listOfAstarteDTO.add(astarteDTO);
        }
        return  listOfAstarteDTO;
    }



}
