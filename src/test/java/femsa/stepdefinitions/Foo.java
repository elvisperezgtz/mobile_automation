package femsa.stepdefinitions;

import femsa.models.Usuario;
import femsa.models.builders.UsuarioBuilder;

public class Foo {
    public static void main(String[] args) {

        UsuarioBuilder builder = new UsuarioBuilder("Elvis");
        Usuario usuario = builder.conApellido("Perez")
                .conEmail("elvisperezgtz@gmail.com")
                .conContrasenia(null)
                .conNombreNegocio("Palancas FC")
                .conActividadEconomica("Development")
                .conCodigoPostal("0522251")
                .build();

        Usuario usuario2 = new Usuario();
        usuario2.defaulValues();

        System.out.println(usuario.toString());
        System.out.println(usuario2.toString());
    }

}
