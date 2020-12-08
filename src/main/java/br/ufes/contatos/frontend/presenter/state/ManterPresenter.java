
package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManterPresenter {
    
    private ManterContatosState estado;
    private ManterContatoView view;
    private Contato contato;

    public ManterPresenter(Contato contato) {  //Edição
        this.view = new ManterContatoView();
        this.contato = contato;
        this.estado = new EdicaoContatoPresenter(this);
        this.setContatoView(contato);
        
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estado.salvar();
            }
        });
        
        this.view.getBtnFechar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        
        this.view.setVisible(true);
    }
    
    public ManterPresenter() {  //Cadastro
        this.view = new ManterContatoView();
        this.contato = null;
        this.estado = new IncluirContatoPresenter(this);
        
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estado.salvar();
            }
        });
        
        this.view.getBtnFechar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        
        this.view.setVisible(true);
    }

    public Contato getContato() {
        return contato;
    }
    
    public Contato getContatoView(){
        return new Contato(this.view.getTxtNome().getText(), this.view.getTxtTelefone().getText());
    }
    
    public void setContatoView(Contato contato){
        this.view.getTxtNome().setText(contato.getNome());
        this.view.getTxtTelefone().setText(contato.getTelefone());
    }

    public ManterContatoView getView() {
        return view;
    }
    
    public void fechar(){
        this.view.dispose();
    }
    
}
