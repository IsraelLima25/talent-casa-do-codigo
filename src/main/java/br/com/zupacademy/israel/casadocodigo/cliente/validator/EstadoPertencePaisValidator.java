package br.com.zupacademy.israel.casadocodigo.cliente.validator;

import br.com.zupacademy.israel.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.israel.casadocodigo.estado.Estado;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertencePaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ClienteForm clienteForm = (ClienteForm) target;
        if (clienteForm.getIdEstado() != null) {
            Estado estado = manager.find(Estado.class, clienteForm.getIdEstado());
            if (!estado.temPais(clienteForm.getIdPais())) {
                errors.rejectValue("idEstado", null, "O idEstado não pertence ao país selecionado.");
            }
        }
    }
}
