/**
 * O Session Scoped fica vivo ate que o Browser seja fechado 
 * (Se a janela for fechada, o Bean contiua ativa. Deve-se fechar o Browser)
 * Ou ate que voce acesse um metodo que mate a sessao.
 * Devemos utilizar quando precisarmos utilizar aqueles atributos em outras paginas ou por outros beans.
 * Exemplo Classico : Login
 */

package br.com.grupo.maratonajsf.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable{
    
     //Simulando lista do banco de dados.
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    
    /**
     * Se quisermos inicializar os atributos assim que o Objeto for instanciado
     * 1 - Construtores e Atributos sao inicializados
     * 2 - Executa o Metodo anotado como PostContruct antes de renderizar a pagina
     * Com o Esccopo Session o post Construct e inicializado apenas uma vez.
     */
    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do RequestScoped");
        this.personagens = asList("Tom","Jerry","Piu Piu");
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session2?faces-redirect=true";
    }
    
    
    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }
    
    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
