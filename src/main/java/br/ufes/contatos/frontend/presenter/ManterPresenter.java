
package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.ManterContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.ufes.contatos.frontend.presenter.command.ICommandPresenter;
import br.ufes.contatos.frontend.presenter.command.InsercaoCommand;
import br.ufes.contatos.frontend.presenter.state.EdicaoContatoPresenter;
import br.ufes.contatos.frontend.presenter.state.IncluirContatoPresenter;
import br.ufes.contatos.frontend.presenter.state.ManterContatosState;

public class ManterPresenter extends Observado{
    
    private ManterContatosState estado;
    private ManterContatoView view;
    private Contato contato;
    private ICommandPresenter command; 

    public ManterPresenter(Contato contato) {  //Edição
        this.view = new ManterContatoView();
        this.contato = contato;
        this.estado = new EdicaoContatoPresenter(this);
        this.setContatoView(contato);
        
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = new InsercaoCommand(estado);
                command.executar();
                update();
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
                command = new InsercaoCommand(estado);
                command.executar();
                update();
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
