package com.example.foyer.controller;


import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;
import com.example.foyer.service.chambre.ChambreServiceImpl;
import com.example.foyer.service.chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreRestController {
    IChambreService iChambreService;
    ChambreServiceImpl chamb;



    @RequestMapping(method = RequestMethod.GET , value = "/affichetoutchambres")
    List<Chambre> retrieveAllchambres(){
        return iChambreService.retrieveAllchambres();
    }

    @PostMapping("/ajouterchambre")
    Chambre addchambres (@RequestBody Chambre c){
        return iChambreService.addchambres(c);
    }

    @PutMapping("/modifierchambre")
    Chambre updatechambres (@RequestBody Chambre c){
        return iChambreService.updatechambres(c);
    }

    @GetMapping("/afficherchambre/{idchambre}")
    Chambre retrievechambres (@PathVariable("idchambre") Long idChambre){
        return iChambreService.retrievechambres(idChambre);
    }

    @GetMapping("/afficherchambresparidbloc/{idBloc}")
    List<Chambre> getChambresByIdBloc (@PathVariable("idBloc") Long idBloc){
        return iChambreService.getChambresByIdBloc(idBloc);
    }





    @DeleteMapping("/supprimerchambre/{idch}")
    void removeChambre(@PathVariable("idch") Long idChambre){
        iChambreService.removeChambre(idChambre);
    }


    @GetMapping("/getbynombloc/{nom}")
    public List<Chambre> getChambrebyNombloc(@PathVariable("nom") String nom){
        return iChambreService.getNomchambrebybloc(nom);
    }


    @GetMapping("/getnbchhambreparblocetype/{typec}/{idBloc}")
    public long getnbchambreparblocetype(@PathVariable("typec") TypeChambre typec, @PathVariable("idBloc") long idBloc){
        return chamb.countchambrepartypeetbloc(typec,idBloc);
    }


}
