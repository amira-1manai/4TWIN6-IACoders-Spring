package com.example.foyer.controller;


import com.example.foyer.entity.Foyer;
import com.ey.springboot3security.entity.Foyer;
import com.ey.springboot3security.service.foyer.IFoyerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    IFoyerService iFoyerService;

    @GetMapping("/affichertousfoyer")
    List<Foyer> retrieveAllfoyer(){
        return iFoyerService.retrieveAllFoyer();
    }

    @GetMapping("/afficherfoyerparid/{idFoyer}")
    Foyer findFoyerbyId(@PathVariable Long idFoyer){
        return iFoyerService.getFoyerById(idFoyer);
    }

    @PostMapping("/ajouterfoyer")
    Foyer addFoyer (@RequestBody Foyer foyer){
        return iFoyerService.addFoyer(foyer);
    }

    @PutMapping("/modifierfoyer")
    Foyer updateFoyer (@RequestBody Foyer  foyer){
        return iFoyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/supprimerfoyer/{idFoyer}")
    void deleteFoyer(@PathVariable Long idFoyer){
        iFoyerService.deleteFoyer(idFoyer);
    }

    @PutMapping("/incrementlike/{nomFoyer}")
    void incrementLikes(@PathVariable("nomFoyer") String nomFoyer){
        iFoyerService.incrementLike(nomFoyer);

    }

    @PutMapping("/decrementlike/{nomFoyer}")
    void decrementLikes(@PathVariable("nomFoyer") String nomFoyer){
        iFoyerService.decrementLike(nomFoyer);

    }

    @GetMapping("/getfoyersbyiduniversite/{iduniversite}")
    Foyer getFoyerByIdUniversite(@PathVariable("iduniversite") Long iduniv){
        return iFoyerService.getFoyerByIdUniversite(iduniv);
    }

    @GetMapping("/getidfoyerbyiduniversite/{iduniversite}")
    Long getIdfoyerByIdUniversite(@PathVariable("iduniversite") Long iduniv){
        return iFoyerService.getIdFoyerByIdUniversite(iduniv);
    }
    @PutMapping("/affecterblocafoyer/{idbloc}/{idfoyer}")
    Foyer affecterblocafoyer(@PathVariable("idbloc") Long idBloc, @PathVariable("idfoyer") Long idFoyer){
        return iFoyerService.affecterBlocAFoyer(idBloc,idFoyer);
    }
}
