/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ComboBox_ViewController implements Initializable {

    @FXML
    private Label lblDescricao;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtDescricao;
    private TextField txtPreco;
    //Tem que informar que a combobox receberá dados do tipo Produto
    @FXML
    private ComboBox<Produto> cbProduto;
    
    //Variaveis auxiliares
    private Produto produto =  new Produto(); //indica nosso MODEL
    //coleção que conterá os dados para sere exibidos demtro da combobox
    private ObservableList<Produto> produtos = FXCollections.observableArrayList();
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblPreco;
    @FXML
    private Label lblDescricao1;
    @FXML
    private TextField txtCodigo1;
    @FXML
    private Button btnInserirCombo;
    @FXML
    private Button btnFechar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //informa que a ComboBox terá a FXCollection 
        cbProduto.setItems(produtos);
    }    
    
    /**
     * Move os dados que estão no model para a nossa tela
     */
    private void moveModelParaView(){
        txtCodigo.setText(String.valueOf(produto.getCodigo()));
        txtDescricao.setText(String.valueOf(produto.getDescricao()));
        txtPreco.setText(String.valueOf(produto.getPreco()));
    }
    
    /**
     * Move os dados da tela para o model
     * @return Model Produto
     */
    private Produto moveViewParaModel(){
        //cria o objeto produto - (model)
        produto = new Produto();
        
        //movendoda tela para o model
        produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
        produto.setDescricao(txtDescricao.getText());
        produto.setPreco(Double.parseDouble(txtPreco.getText()));
        
        //devolve o model
        return produto;
    }
    
    @FXML
    private void btnInserirCombo_Click(ActionEvent event) {
        //transfere os dados da tela para o objeto de model (produt)
        produto = moveViewParaModel();
        
        //adiciona este objeto na coleção
        produtos.add(produto);
        
        mensagem("Produto inserido com sucesso!");
        
        limparCampos();
        
        //coloca o foco no codigo
        txtCodigo.requestFocus();
        
    }
    
    private void mensagem(String msg){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
        
        alerta.showAndWait();//exibe mensagem
    }

    private void limparCampos(){
        txtCodigo.clear();
        txtDescricao.clear();
        txtPreco.clear();
    }
    
    private void btnExibirDados_Click(ActionEvent event) {
        //verificar se tem algum selecionado
        if(cbProduto.getValue() == null){
            mensagem("Favor selecionar um item...");
        }
        else{
            //obte os dados da combo
            produto = cbProduto.getValue();
            
            //exibe os dados
            moveModelParaView();
        }
    }

    @FXML
    private void btnFechar_Click(ActionEvent event) {
        //fecha o sistema
        System.exit(0);
    }

    
}
