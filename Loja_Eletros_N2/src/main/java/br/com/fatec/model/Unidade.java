/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nicol
 */
public class Unidade {
    private int lojaID;
    private String nome;
    private int telefone;
    private String endereco; 
    private String cidade; 
    private String email;
    
    
    
    
    // para os campos das consulta
    public IntegerProperty lojaIDProperty() {
        return new SimpleIntegerProperty(lojaID);
    }

    public SimpleStringProperty nomeProperty() {
        return new SimpleStringProperty(nome);
    }

    public IntegerProperty telefoneProperty() {
        return new SimpleIntegerProperty(telefone);
    }
    
    
    
    

    public Unidade(int lojaID, String nome) {
        this.lojaID = lojaID;
        this.nome = nome;
    }

    public Unidade(int lojaID, String nome, int telefone, String endereco, String cidade, String email) {
        this.lojaID = lojaID;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.email = email;
    }

    public Unidade() {
    }



    
    
    public int getLojaID() {
        return lojaID;
    }

    public void setLojaID(int lojaID) {
        this.lojaID = lojaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

}
