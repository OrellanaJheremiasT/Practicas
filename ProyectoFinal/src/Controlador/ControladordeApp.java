package controlador;

import modelo.Usuario;
import modelo.Pelicula;
import vista.ConsolaView;
import java.util.List;

public class ControladordeApp {
    private List<Usuario> usuarios;
    private ConsolaView view;
    private Usuario actual;

    public UsuarioController(List<Usuario> usuarios, ConsolaView view) {
        this.usuarios = usuarios;
        this.view = view;
    }

    public void iniciar() {
        login();

        int op;
        do {
            op = view.menuPrincipal();
            switch (op) {
                case 1 -> actual.mostrarPerfil();
                case 2 -> actual.mostrarCarrito();
                case 3 -> agregarPelicula();
                case 4 -> actual.pagarCarrito();
                case 5 -> actual.mostrarHistorial();
                case 6 -> actual.mostrarAdquiridas();
                case 7 -> view.mensaje("Saliendo...");
                default -> view.mensaje("Opción inválida");
            }
        } while (op != 7);
    }

    private void agregarPelicula() {
        String titulo = view.pedirTitulo();
        double precio = view.pedirPrecio();
        actual.agregarAlCarrito(new Pelicula(titulo, precio));
    }

    private void login() {
        while (true) {
            String u = view.pedirUsuario();
            String p = view.pedirPassword();

            for (Usuario user : usuarios) {
                if (user.getUsername().equals(u) && user.verificarPassword(p)) {
                    actual = user;
                    view.mensaje("Ingreso exitoso.");
                    return;
                }
            }
            view.mensaje("Usuario o contraseña incorrectos.");
        }
    }
}
