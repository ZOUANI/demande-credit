package ma.fst.credit.service;

import ma.fst.credit.bean.Client;
import ma.fst.credit.bean.DemandeCredit;
import ma.fst.credit.dao.DemandeCreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandereditService {
    public int save(DemandeCredit demandeCredit){
        if(findByRefAndRefBank(demandeCredit.getRef(),demandeCredit.getRefBank())!=null){
            return -1;
        }
        Client client = clientService.findByRef(demandeCredit.getClient().getRef());
        if(client==null){
            return -2;
        }else if(client.getTotalCredit()+demandeCredit.getMontant()>client.getPlafondCredit()){
            return -3;
        }else{
            demandeCredit.setClient(client);
            client.setTotalCredit(client.getTotalCredit()+demandeCredit.getMontant());
            clientService.update(client);
            demandeCreditDao.save(demandeCredit);
            return 1;
        }
    }
    public List<DemandeCredit> findByTauxAndAndRefBank(double taux, String refBank) {
        return demandeCreditDao.findByTauxAndAndRefBank(taux, refBank);
    }

    public List<DemandeCredit> findByClientRef(String ref) {
        return demandeCreditDao.findByClientRef(ref);
    }

    public List<DemandeCredit> findAll() {
        return demandeCreditDao.findAll();
    }

    public DemandeCredit getOne(Long aLong) {
        return demandeCreditDao.getOne(aLong);
    }

    public DemandeCredit findByRefAndRefBank(String ref, String refBank) {
        return demandeCreditDao.findByRefAndRefBank(ref, refBank);
    }

    @Autowired
    private DemandeCreditDao demandeCreditDao;
    @Autowired
    private ClientService clientService;
}
