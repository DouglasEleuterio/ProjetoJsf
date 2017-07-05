/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dougas
 */
@ManagedBean(name = "login")
@RequestScoped
public class LoginBean implements Serializable {

    private String name;
    private String password;

    @PostConstruct
    public void init() {
        name = "";
        password = "";
    }

    public LoginBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//   Framework Kimera.
//    Futuramente trocar por Hibernate 
    public void access() {
        String dummy_user = "douglas";
        String dummy_pass = "fox789";
        FacesContext context = FacesContext.getCurrentInstance();
        //I use JDBC PostgreSQL driver for find the users in table "users"
        if (name.equals(dummy_user) && password.equals(dummy_pass)) {
            //Here you must put your code to redirect or do something 
            context.addMessage(null, new FacesMessage("Login Realizado", "Você está logado"));
        } else {
            context.addMessage(null, new FacesMessage("Acesso Negado", "Tente novamente"));
        }
    }

}

//    Usando Sweet Alert para exibir as mensagens
//    public void login (){
//        RequestContext context = RequestContext.getCurrentInstance();
//        context.execute ("swal('Login Sucess','Congratulation! you are login in','Sucess')");
//    }
//    
