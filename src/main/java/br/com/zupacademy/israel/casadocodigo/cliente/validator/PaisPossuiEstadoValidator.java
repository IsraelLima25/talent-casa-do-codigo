package br.com.zupacademy.israel.casadocodigo.cliente.validator;

import br.com.zupacademy.israel.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.israel.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PaisPossuiEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }
        ClienteForm clienteForm = (ClienteForm) target;
        Pais pais = manager.find(Pais.class, clienteForm.getIdPais());

        if (pais.paisPossuiEstados() && clienteForm.getIdEstado() == null) {
            errors.rejectValue("idEstado", null, "Estado Inválido!! Este país possuí estados cadastrados");
            return;
        }
    }
}


