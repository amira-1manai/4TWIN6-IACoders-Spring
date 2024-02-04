package com.example.foyer.controller;


import com.example.foyer.service.universite.IUniversiteService;
import com.example.foyer.entity.Universite;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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




    @PutMapping("desaffecterfoyerauniversite/{idf}/{idu}")
    public Universite desaffecterFoyerAUniversite (@PathVariable("idf") long idFoyer,@PathVariable("idu") long idUniversite) {
        return iuniver.desaffecterFoyerAUniversite(idFoyer,idUniversite);
    }


    @RequestMapping(method = RequestMethod.GET, value ="/affichetoutuniversite")
    List<Universite> retrieveAllUniversite(){
        return iuniver.retrivealluniversites() ;
    }


    @RequestMapping(method = RequestMethod.POST,value ="ajouteruniversite")
    Universite adduniversite (@RequestBody Universite u){
        return iuniver.addUniversite(u);
    }


    @DeleteMapping("/supp/{idUniv}")
    public ResponseEntity<String> removeBloc(@PathVariable("idUniv") Long idUniversite) {
        iuniver.removeUniversite(idUniversite);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/ModifierUniversite")
    Universite updateBloc (@RequestBody Universite u ){
        return iuniver.updateUniversite(u);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/afficheuniversite/{idUniversite}")
    Universite getUnivByid(@PathVariable("idUniversite") long idUniversite){
        return iuniver.getUnivByid(idUniversite);
    }

}
