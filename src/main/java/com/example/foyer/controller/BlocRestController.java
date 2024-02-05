package com.example.foyer.controller;


import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;
import com.example.foyer.service.bloc.IBlocService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")

public class BlocRestController {
    IBlocService iBlocService;

    @RequestMapping(method = RequestMethod.GET, value = "/affichetoutblocs")
    List<Bloc> retrieveAllBlocs() {
        return iBlocService.retrieveAllBlocs();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ajouterbloc")
    Bloc addBloc(@RequestBody Bloc b) {
        return iBlocService.addBloc(b);
    }

    @PutMapping("/Modifierbloc")
    Bloc updateBloc(@RequestBody Bloc b) {
        return iBlocService.updateBloc(b);
    }

    @GetMapping("/afficherbloc/{idbloc}")
    Bloc retrieveblocbyid(@PathVariable("idbloc") Long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping ("/supp/{idbloc}")
    void removeBloc(@PathVariable("idbloc") Long idBloc) {
        iBlocService.removeBloc(idBloc);
    }

    @PutMapping("affecterchambrebloc/{nom}")
    Bloc affecterChambresABloc(@RequestBody List<Long> numeroChambre, @PathVariable("nom") String nomBloc) {
        return iBlocService.affecterChambresABloc(numeroChambre, nomBloc);
    }

    @PutMapping("affecterblocafoyer/{nombloc}/{nomfoyer}")
    Bloc affecterblocafoyer(@PathParam("nombloc") String nomBloc, @PathParam("nomfoyer") String nomFoyer) {
        return iBlocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }


    @GetMapping("/afficherblocparidfoyer/{idFoyer}")
    List<Bloc> getBlocsByIdFoyer(@PathVariable("idFoyer") Long idFoyer) {
        return iBlocService.afficherBlocParIdFoyer(idFoyer);
    }

    @PostMapping("/findBlocByChambre")
    public Bloc findBlocByChambresContaining(@RequestBody Chambre chambre){
        return iBlocService.findBlocByChambresContaining(chambre);
    }

}
