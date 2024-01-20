package br.com.zupacademy.israel.casadocodigo.cliente;

import br.com.zupacademy.israel.casadocodigo.cliente.validator.EstadoPertencePaisValidator;
import br.com.zupacademy.israel.casadocodigo.cliente.validator.PaisPossuiEstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoPertencePaisValidator estadoPertencePaisValidator;
    @Autowired
    private PaisPossuiEstadoValidator paisPossuiEstadoValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(
                estadoPertencePaisValidator,
                paisPossuiEstadoValidator
        );
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Long> cadastroCliente(@Valid @RequestBody ClienteForm clienteForm) {
        Cliente cliente = clienteForm.toModel(manager);
        Cliente novoCliente = manager.merge(cliente);
        return ResponseEntity.ok(novoCliente.getId());
    }
}
