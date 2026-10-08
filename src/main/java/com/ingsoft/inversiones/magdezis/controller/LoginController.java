
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

import main.java.com.ingsoft.inversiones.magdezis.dto.LoginRequest;
import main.java.com.ingsoft.inversiones.magdezis.model.Usuario;
import main.java.com.ingsoft.inversiones.magdezis.service.UsuarioService;

public class LoginController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;

    private UsuarioService usuarioService;

    public LoginController() {
        usuarioService = new UsuarioService();
    }

    @FXML
    private void iniciarSesion() {

        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        LoginRequest request =
                new LoginRequest(
                        correo,
                        contrasena
                );

        Usuario usuario =
                usuarioService.iniciarSesion(request);

        if (usuario != null) {

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Inicio de sesión",
                    "Bienvenido "
                    + usuario.getNombre()
                    + "\nRol: "
                    + usuario.getNombreRol()
            );

        } else {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Correo o contraseña incorrectos"
            );
        }
    }

    @FXML
    private void irRegistro() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/view/registro-view.fxml"
                            )
                    );

            Parent root = loader.load();

            Stage stage =
                    (Stage) txtCorreo
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