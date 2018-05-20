/**
 * RequestScoped e interessante quando apenas exibiremos valores na tela.
 * Se precisarmos chamar metodos ou submeter valores por formulario, sendo com ajax ou sem uso de ajax
 * nao podemos utilizar o RequestScoped, por que a partir do momento que a requisicao e finalizada.
 * Os objetos sao destruidos.   
 * 
 * Apresentado tambem os conceitos de Forward e redirect e as diferencas entre eles
 * Redirect: O Servidor responde para o cliente que a pagina precisa ser direcionada, o browser do cliente
 * faz uma requisicao solicitando a pagina, posteriormente o servidor devolve a pagina para o cliente.
 * ---Neste Ciclo, apos a conclusao do processo os objetos RequestScoped morrem --
 * 
 * Forward -- O servidor faz o redirecionamente internamente,
 * dessa forma os Objetos anotados como requestScoped permanecem vivos.
 * 
 */
package br.com.grupo.maratonajsf.bean.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TesteRequestBean implements Serializable{
    //Simulando lista do banco de dados.
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    
    /**
     * Se quisermos inicializar os atributos assim que o Objeto for instanciado
     * 1 - Construtores e Atributos sao inicializados
     * 2 - Executa o Metodo anotado como PostContruct antes de renderizar a pagina
     * No Escopo de Requisicao Sempre que a Pagina e renderizada, o post Construct e inicializado.
     */
    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do RequestScoped");
        this.personagens = asList("Goku","Kuririm","Vegeta");
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
