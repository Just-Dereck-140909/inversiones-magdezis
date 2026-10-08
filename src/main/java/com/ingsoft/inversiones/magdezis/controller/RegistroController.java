package main.java.com.ingsoft.inversiones.magdezis.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import main.java.com.ingsoft.inversiones.magdezis.dto.RegistroRequest;
import main.java.com.ingsoft.inversiones.magdezis.service.UsuarioService;

public class RegistroController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;

    private UsuarioService usuarioService;

    public RegistroController() {
        usuarioService = new UsuarioService();
    }

    @FXML
    private void registrarUsuario() {

        RegistroRequest request =
                new RegistroRequest(
                        txtNombre.getText(),
                        txtApellido.getText(),
                        txtCorreo.getText(),
                        txtContrasena.getText()
                );

        boolean resultado =
                usuarioService.registrarUsuario(request);

        if (resultado) {

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Registro",
                    "Usuario registrado correctamente"
            );

            volverLogin();

        } else {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No se pudo registrar el usuario"
            );
        }
    }

    @FXML
    private void volverLogin() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/view/login-view.fxml"
                            )
                    );

            Parent root = loader.load();

            Stage stage =
                    (Stage) txtNombre
                            .getScene()
                            .getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}