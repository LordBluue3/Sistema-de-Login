package lord.sistema.login.sistemadelogin.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ViewController {

    @FXML
    private String porta = "12345";

    @FXML
    private String servidor = "127.0.0.1";

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnLogin;

    @FXML
        public void onBtnLoginAction () {
        conexao();
    }

    public void conexao(){
        JSONObject json = new JSONObject();

        json.put("login", txtLogin.getText());
        json.put("senha", txtSenha.getText());

        try {
            // Tentado conexão ao servidor
            Socket socket = new Socket(servidor, Integer.parseInt(porta));
            System.out.println("Conectado!");

            // obter o fluxo de saída do soquete.
            OutputStream outputStream = socket.getOutputStream();
            // cria um fluxo de saída de objeto a partir do fluxo de saída para que possamos enviar um objeto através dele
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //fazer um monte de mensagens para enviar.
            List<String> messages = new ArrayList<>();
            //enviando mensagem em Json ao servidor
            messages.add(new String(json.toJSONString()));
            //Enviando mensagem ao socket
            System.out.println("Enviando mensagem ao ServerSocket: ");
            System.out.println(json);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Resultado: ");
            objectOutputStream.writeObject(messages);

            //recebendo mensagem do socket
            DataInputStream dus = new DataInputStream(socket.getInputStream());
            String mgs = dus.readUTF();
            String contador = dus.readUTF();
            System.out.println(mgs);
            if(contador.equalsIgnoreCase("3")){
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
            }
            System.out.println("numero da tentativa: "+contador);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
            //fechando o socket
            System.out.println("Fechando o socket.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


