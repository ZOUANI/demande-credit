package ma.fst.credit.dao;

import ma.fst.credit.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByRef(String ref);
}
