/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class Cliente_cadastroController implements Initializable {

    @FXML
    private ComboBox<String> cb_funcionario;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblPreco;
    @FXML
    private TextField txtNome;
    @FXML
    private ComboBox<?> cb_unidade;
    @FXML
    private Label lblDescricao1;
    @FXML
    private Label lblCodigo1;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_email;
    @FXML
    private Label lbl_cpf;
    @FXML
    private TextField txtCodigo31;
    @FXML
    private Label lblCodigo111;
    @FXML
    private TextField txt_telefone;
    @FXML
    private Button btn_voltar;
    @FXML
    private Button btn_inserir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // Crie uma lista de itens para a ComboBox
        ObservableList<String> funcionarios = FXCollections.observableArrayList(
                "Funcionário 1",
                "Funcionário 2",
                "Funcionário 3"
                // Adicione mais funcionários conforme necessário
        );

        // Associe a lista à ComboBox
        cb_funcionario.setItems(funcionarios);
    }    

    @FXML
    private void btn_voltar_Click(ActionEvent event) {
            // Lógica para voltar para a tela de menu
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/fatec/view/MenuView.fxml"));
            Parent menuParent = null;
            try {
                menuParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // Trate a exceção conforme necessário
            }
            Scene menuScene = new Scene(menuParent);

            // Carrega a cena da tela de menu
            stage.setScene(menuScene);
            stage.show();
    }

    @FXML
    private void btn_inserir_Click(ActionEvent event) {
    }
    
}
