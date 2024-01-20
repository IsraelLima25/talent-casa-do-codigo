package br.com.zupacademy.israel.casadocodigo.estado.validator;

import br.com.zupacademy.israel.casadocodigo.estado.EstadoForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class UniqueNameStateCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return EstadoForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        EstadoForm estadoForm = (EstadoForm) target;
        Query query = manager.createQuery("select e from Estado e where e.nome=:nomeEstado AND e.pais.id=:idPais");
        query.setParameter("nomeEstado", estadoForm.getNome());
        query.setParameter("idPais", estadoForm.getIdPais());
        int quantidadeEstadosAssociadosPaisPorNome = query.getResultList().size();
        if (quantidadeEstadosAssociadosPaisPorNome > 0) {
            errors.rejectValue("nome", null, "Erro!! Já existe um estado chamado " + estadoForm.getNome() + " " +
                    "associado ao país com código " + estadoForm.getIdPais());
        }
    }
}
