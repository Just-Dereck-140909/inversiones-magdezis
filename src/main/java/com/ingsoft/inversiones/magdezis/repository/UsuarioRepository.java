package main.java.com.ingsoft.inversiones.magdezis.repository;

import main.java.com.ingsoft.inversiones.magdezis.config.DataBaseConnection;
import main.java.com.ingsoft.inversiones.magdezis.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {

    public boolean registrarUsuario(Usuario usuario) {

        String sql = """
                INSERT INTO usuarios
                (nombre, apellido, correo, contrasena_hash, id_rol)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DataBaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContrasenaHash());

            // 1 = USER
            statement.setInt(5, 1);

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar: " + e.getMessage()
            );

            return false;
        }
    }

    public Usuario buscarPorCorreo(String correo) {

        String sql = """
                SELECT u.id_usuario,
                       u.nombre,
                       u.apellido,
                       u.correo,
                       u.contrasena_hash,
                       r.id_rol,
                       r.nombre_rol
                FROM usuarios u
                INNER JOIN roles r
                    ON u.id_rol = r.id_rol
                WHERE u.correo = ?
                """;

        try (
                Connection connection =
                        DataBaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, correo);

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                return new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("correo"),
                        resultSet.getString("contrasena_hash"),
                        resultSet.getInt("id_rol"),
                        resultSet.getString("nombre_rol")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar usuario: "
                    + e.getMessage()
            );
        }

        return null;
    }
}