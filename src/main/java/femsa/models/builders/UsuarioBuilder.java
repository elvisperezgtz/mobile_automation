package femsa.models.builders;

import femsa.models.Usuario;

public class UsuarioBuilder implements IBuilder {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private String nombreNegocio;
    private String actividadEconomica;
    private String codigoPostal;

    public UsuarioBuilder(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder conContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    public UsuarioBuilder conNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
        return this;
    }

    public UsuarioBuilder conActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
        return this;
    }

    public UsuarioBuilder conCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
        return this;
    }

    @Override
    public Usuario build() {
        Usuario usuario = new Usuario();
        usuario.setNombre(this.nombre);
        usuario.setApellido(this.apellido);
        usuario.setEmail(this.email);
        usuario.setContrasenia(this.contrasenia);
        usuario.setNombreNegocio(this.nombreNegocio);
        usuario.setActividadEconomica(this.actividadEconomica);
        usuario.setCodigoPostal(this.codigoPostal);
        return usuario;
    }

}
