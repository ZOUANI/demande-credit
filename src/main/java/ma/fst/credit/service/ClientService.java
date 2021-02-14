package ma.fst.credit.service;

import ma.fst.credit.bean.Client;
import ma.fst.credit.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    public void update(Client client){
         clientDao.save(client);
    }
    public Client findByRef(String ref) {
        return clientDao.findByRef(ref);
    }
    public List<Client> findAll() {
        return clientDao.findAll();
    }
    public Client getOne(Long aLong) {
        return clientDao.getOne(aLong);
    }
    public int save(Client client){
        if(findByRef(client.getRef())!=null){
            return -1;
        }else if(client.getPlafondCredit()< client.getTotalCredit()){
            return -2;
        }else{
            clientDao.save(client);
            return 1;
        }
    }
    @Autowired
    private ClientDao clientDao;
}
