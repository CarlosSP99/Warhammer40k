package com.example.Warhammer40k.controller;

import com.example.Warhammer40k.model.dto.ApiResponseDTO;
import com.example.Warhammer40k.model.dto.FactionDTO;
import com.example.Warhammer40k.service.FactionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faction")
public class FactionController {

    @Autowired
    private FactionService factionService;

    @GetMapping("/listFaction")
    public ResponseEntity getAllFactions() {
        try{
            List< FactionDTO> listOfFactions = factionService.getAllFactions();
            return ResponseEntity.ok(new ApiResponseDTO<>(true, "200", listOfFactions));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>(false, "200", null));
        }

    }

}
