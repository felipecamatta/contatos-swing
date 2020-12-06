package br.ufes.contatos.frontend.collection;

import br.ufes.contatos.frontend.model.Contato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContatoCollection {

    private List<Contato> contatos;

    public ContatoCollection() {
        contatos = new ArrayList<>();
    }

    public ContatoCollection(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void add(Contato contato) {
        if (contatos.contains(contato)) {
            throw new RuntimeException("Contato já existe");
        }
        if (contato != null) {
            contatos.add(contato);
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato");
        }
    }

    public List<Contato> getContatos() {
        return Collections.unmodifiableList(contatos);
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

}
