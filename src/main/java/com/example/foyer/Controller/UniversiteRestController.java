package com.example.foyer.Controller;

import com.example.foyer.entity.Universite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
@CrossOrigin(origins = "http://localhost:4200/")
public class UniversiteRestController {
    IUniversiteService iuniver;

    @PutMapping("affecterfoyeruniversite/{idf}/{nomu}")
    public Universite affecterFoyerAUniversite(@PathVariable("idf") long idFoyer , @PathVariable("nomu") String nomUniversite){
        return iuniver.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

}
