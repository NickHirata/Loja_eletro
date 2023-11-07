package br.com.fatec;
import br.com.fatec.DAO.ConexaoBanco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JavaFX Principal
 */
public class Principal extends Application {

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Principal.scene = scene;
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #C3C3C3;");
        scene = new Scene(loadFXML("view/MenuView"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
       launch();
        PreparedStatement stmt = null;
        ResultSet rs = null;
         // Testando a conexão com o banco de dados
        try {
            Connection conexao = ConexaoBanco.conectar();
            System.out.println("Conexão bem-sucedida. Você está conectado ao banco de dados!");
            
            // operaçoes com o banco
            //  teste de conexao...
             String sql = "SELECT * FROM loja";
             stmt = conexao.prepareStatement(sql);
             rs = stmt.executeQuery();

             // Processar os resultados da consulta
             while (rs.next()) {
                 int id = rs.getInt("lojaID");
                 String nome = rs.getString("nome");
                 String endereco = rs.getString("endereco");

                 System.out.println("ID: " + id + ", Nome: " + nome + ", Endereço: " + endereco);
             }
            
             
             
            // Fechando a conexão após a conclusão das operações
            ConexaoBanco.desconectar(conexao);
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            System.out.println("Falha na conexão com o banco de dados.");
        } 
        
        
    }

}