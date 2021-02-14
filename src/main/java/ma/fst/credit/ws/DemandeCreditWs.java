package ma.fst.credit.ws;

import ma.fst.credit.bean.DemandeCredit;
import ma.fst.credit.service.DemandereditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bp/credit")
public class DemandeCreditWs {
    @PostMapping("/")
    public int save(@RequestBody  DemandeCredit demandeCredit) {
        return demandereditService.save(demandeCredit);
    }

    @GetMapping("/taux/{taux}/refBank/{refBank}")
    public List<DemandeCredit> findByTauxAndAndRefBank(@PathVariable double taux,@PathVariable String refBank) {
        return demandereditService.findByTauxAndAndRefBank(taux, refBank);
    }
    @GetMapping("/ref/{ref}")
    public List<DemandeCredit> findByClientRef(@PathVariable String ref) {
        return demandereditService.findByClientRef(ref);
    }
    @GetMapping("/")
    public List<DemandeCredit> findAll() {
        return demandereditService.findAll();
    }
    @GetMapping("/id/{id}")
    public DemandeCredit getOne(@PathVariable Long id) {
        return demandereditService.getOne(id);
    }
    @GetMapping("/ref/{ref}/refBank/{refBank}")
    public DemandeCredit findByRefAndRefBank(@PathVariable String ref,@PathVariable String refBank) {
        return demandereditService.findByRefAndRefBank(ref, refBank);
    }

    @Autowired
    private DemandereditService demandereditService;
}
