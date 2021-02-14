package ma.fst.credit.ws;

import ma.fst.credit.bean.Client;
import ma.fst.credit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bp/client")
public class ClientWs {

    @PutMapping("/")
    public void update(@RequestBody Client client) {
        clientService.update(client);
    }

    @GetMapping("/ref/{ref}")
    public Client findByRef(@PathVariable String ref) {
        return clientService.findByRef(ref);
    }
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }
    @GetMapping("/id/{id}")
    public Client getOne(Long id) {
        return clientService.getOne(id);
    }
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @Autowired
    private ClientService clientService;
}
