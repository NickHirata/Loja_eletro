package br.com.fatec.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.fatec.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class MenuViewController implements Initializable {

    @FXML
    private MenuItem mi_funcionario;
    @FXML
    private MenuItem mi_loja;
    @FXML
    private MenuItem mi_cliente;
    @FXML
    private MenuItem mi_produto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mi_funcionario_Click(ActionEvent event) {
    
            
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/fatec/view/produtos_cadastro.fxml"));
            Parent menuParent = null;
            try {
                menuParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                //Trate a exceção conforme necessário
            }
            Scene menuScene = new Scene(menuParent);

   
            stage.setScene(menuScene);
            stage.show();
    }

    @FXML
    private void mi_loja_Click(ActionEvent event) throws IOException {
        
        //Principal.setRoot("view/Loja_cadastro");
    }

       private BorderPane mainPane; // Referência ao contêiner de layout do MenuView.fxml

       @FXML
       private void mi_cliente_click(ActionEvent event) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/fatec/view/ClienteCadastro.fxml"));
           Parent clienteCadastro = null;
           try {
               clienteCadastro = loader.load();
           } catch (IOException e) {
               e.printStackTrace();
               // Trate a exceção conforme necessário
           }

           mainPane.setCenter(clienteCadastro); // Substitui o conteúdo do contêiner pelo ClienteCadastro.fxml
       }


    @FXML
    private void mi_produto_Click(ActionEvent event) {
      
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/fatec/view/produtos_cadastro.fxml"));
            Parent menuParent = null;
            try {
                menuParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                // Trate a exceção conforme necessário
            }
            Scene menuScene = new Scene(menuParent);

   
            stage.setScene(menuScene);
            stage.show();
    }

    private void btn_click(ActionEvent event) {
            // Lógica para voltar para a tela de menu
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/fatec/view/produtos_cadastro"));
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
    
    
}
