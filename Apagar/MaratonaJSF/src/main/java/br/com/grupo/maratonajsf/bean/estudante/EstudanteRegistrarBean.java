package br.com.grupo.maratonajsf.bean.estudante;

import br.com.grupo.maratonajsf.model.Estudante;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;

//Managed Bean sera descontinuado, utilizaremos CDI como Injetor de Dependencias
@Named
public class EstudanteRegistrarBean implements Serializable {

//    Inicializar a variavel para nao ocorrer NullPointerException
//    Nao instanciala sera o mesmo que tentar obter paramentros de um objeto nulo.
    private Estudante estudante = new Estudante();
    private String[] nomesArray = {"Douglas", "Eleuterio", "Ferreira"};
    private List<String> nomesList = Arrays.asList("Douglas", "Meire", "Samuel","Eleuterio");

//    Trabalhando com Set
    private Set<String> nomesSet = new HashSet<>(Arrays.asList("Nomes Set", "Nomes Set2", "Goku"));

//    Trabalhando com Map 
    private Map<String, String> nomesMap = new HashMap<>();

    {
        nomesMap.put("Goku", "O mais forte");
        nomesMap.put("OnePiece", "O mais longo");
        nomesMap.put("Naruto", "O mais lenga lenga");

        for (Map.Entry<String, String> entry : nomesMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * Chamando metodos via expression Language. Se chamar os metodos pela web,
     * podemos fazer muitas coisas.
     */
    public void executar() {
        System.out.println("Fazendo uma busca no banco de dados");
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados");
    }

    public void executar(String param) {
        System.out.println("Fazendo uma busca no banco de dados com PARAMETRO: " + param);
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados");
    }

    /**
     * Parametro com retorno
     *
     * @param param
     * @return
     */
    public String executarRetorno(String param) {
        return "<h1>Quem e o Gostosao?" + param + "</h1>";
    }

    /**
     * navegacao via String
     */
    public String menuLinks() {
        String a = "?faces-redirect=true";
        return "pagina1";
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

}
