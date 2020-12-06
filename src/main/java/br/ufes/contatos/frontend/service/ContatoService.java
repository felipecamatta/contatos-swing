package br.ufes.contatos.frontend.service;

import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ContatoService {

    private static String url = "https://contatos-pss.herokuapp.com/contatos";

    public ContatoCollection getContatos() {
        RestTemplate restTemplate = new RestTemplate();

        Contato[] contatos = restTemplate.getForObject(url, Contato[].class);

        return new ContatoCollection(Arrays.asList(contatos));
    }

    public void saveContato(Contato contato) {
        RestTemplate restTemplate = new RestTemplate();

        Contato result = restTemplate.postForObject(url, contato, Contato.class);
    }

}
