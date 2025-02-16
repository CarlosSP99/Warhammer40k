package com.example.Warhammer40k.controller;


import com.example.Warhammer40k.model.Astarte;
import com.example.Warhammer40k.model.dto.ApiResponseDTO;
import com.example.Warhammer40k.model.dto.AstarteDTO;
import com.example.Warhammer40k.service.AstarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/astarte")
public class AstarteController {
    @Autowired
    private AstarteService astarteService;

    @PostMapping
    public ResponseEntity addOneAstarte(@RequestBody Astarte astarte){
        try {
            astarteService.addOneAstarte(astarte);
            AstarteDTO astarteDTO = new AstarteDTO(astarte);
            return  ResponseEntity
                    .ok(new ApiResponseDTO(true, "200", astarteDTO));
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(new ApiResponseDTO(false, "400", null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneAstarte(@PathVariable Long id){
        try {
            Optional<AstarteDTO> astarteDTO = astarteService.getAstarteById(id);
            if (astarteDTO.isPresent()){
                return ResponseEntity
                        .ok(new ApiResponseDTO(true, "200", astarteDTO));
            } else{ return ResponseEntity
                    .ok()
                    .body(new ApiResponseDTO(false, "400", "Data not found"));

            }
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(new ApiResponseDTO(false, "400", null));
        }
    }

    @GetMapping("/listAstartes")
    public ResponseEntity<?> getAllAstarte() {
        try {
            List<AstarteDTO> listOfAstartes = astarteService.getAllAstartes();
            return ResponseEntity
                    .ok(new ApiResponseDTO(true, "200", listOfAstartes));
        } catch (DataAccessException e) {
            // Manejo de errores de acceso a datos
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDTO(false, "500", "Error de acceso a datos"));
        } catch (Exception e) {
            // Manejo de otros errores
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDTO(false, "500", "Error interno del servidor"));
        }
    }


}
