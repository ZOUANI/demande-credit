package ma.fst.credit.dao;

import ma.fst.credit.bean.Client;
import ma.fst.credit.bean.DemandeCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeCreditDao extends JpaRepository<DemandeCredit,Long> {

    DemandeCredit findByRefAndRefBank(String ref,String refBank);

    List<DemandeCredit> findByTauxAndAndRefBank(double taux,String refBank);

    List<DemandeCredit>  findByClientRef(String ref);
}
