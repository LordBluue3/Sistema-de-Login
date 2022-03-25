package lord.sistema.login.sistemadelogin.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lord.sistema.login.sistemadelogin.gui.utilitarios.Alertas;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.json.simple.JSONObject;

import javax.xml.transform.Source;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ViewController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private int contagem = 1;

    @FXML
    private String porta = "12345";

    @FXML
    private String servidor = "127.0.0.1";

    @FXML
        public void onBtnLoginAction () {

        JSONObject json = new JSONObject();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        json.put("login", txtLogin.getText());
        json.put("senha", txtSenha.getText());

        try {
            // need host and port, we want to connect to the ServerSocket at port 7777
            Socket socket = new Socket(servidor, Integer.parseInt(porta));
            System.out.println("Connected!");

            // get the output stream from the socket.
            OutputStream outputStream = socket.getOutputStream();
            // create an object output stream from the output stream so we can send an object through it
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // make a bunch of messages to send.
            List<String> messages = new ArrayList<>();

            messages.add(new String(json.toJSONString()));


            System.out.println("Sending messages to the ServerSocket");
            objectOutputStream.writeObject(messages);

            System.out.println("Closing socket and terminating program.");
            socket.close();

        } catch (IOException e) {
         e.printStackTrace();
        }
        //Login e senha
        String loginn = "Lord@gmail.com";
        String senhaa = "1234";


            //contador para se a pessoa errar a senha 3x fechar a aplicação
            if(contagem == 3 ){
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
            }

            try {
                //se a senha e login forem iguais a da variaveis senhaa e loginn login valido!
            if (Objects.equals(login, loginn) && Objects.equals(senha, senhaa)) {
                Alertas.showAlerta("Acesso", "Logado com sucesso!", null, Alert.AlertType.INFORMATION);
            } else {
                Alertas.showAlerta("Erro", "Login ou senha inválido", null, Alert.AlertType.ERROR);
                contagem++; //se ele errar a senha vai ter incrementada 1 numero a variavel contagem
            }
            } catch (NumberFormatException e) {
                Alertas.showAlerta("Erro", "Numero invalido", e.getMessage(), Alert.AlertType.ERROR);
            }
    }
}


