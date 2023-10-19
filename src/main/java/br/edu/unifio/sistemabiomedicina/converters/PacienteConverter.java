package br.edu.unifio.sistemabiomedicina.converters;

import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Paciente retorno = null;

        if (StringUtils.isNotBlank(value)) {
            retorno = this.pacienteRepository.getById(Long.parseLong(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Paciente value) {
        if (value != null) {
            Long codigo = ((Paciente) value).getId();
            String retorno = (codigo == null ? null : codigo.toString());

            return retorno;
        }

        return "";
    }
}
