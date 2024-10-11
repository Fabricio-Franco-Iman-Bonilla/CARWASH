
package pe.edu.dao.entity;

public class Usuario {

    /**
     * @return the usuario_usuario
     */
    public String getUsuario_usuario() {
        return usuario_usuario;
    }

    /**
     * @param usuario_usuario the usuario_usuario to set
     */
    public void setUsuario_usuario(String usuario_usuario) {
        this.usuario_usuario = usuario_usuario;
    }

    /**
     * @return the usuario_tipoDocumento
     */
    public String getUsuario_tipoDocumento() {
        return usuario_tipoDocumento;
    }

    /**
     * @param usuario_tipoDocumento the usuario_tipoDocumento to set
     */
    public void setUsuario_tipoDocumento(String usuario_tipoDocumento) {
        this.usuario_tipoDocumento = usuario_tipoDocumento;
    }

    /**
     * @return the usuario_numDocumento
     */
    public String getUsuario_numDocumento() {
        return usuario_numDocumento;
    }

    /**
     * @param usuario_numDocumento the usuario_numDocumento to set
     */
    public void setUsuario_numDocumento(String usuario_numDocumento) {
        this.usuario_numDocumento = usuario_numDocumento;
    }
    
    protected int usuario_id;
    protected String usuario_nombre;
    protected String usuario_apellido;
    protected String usuario_telefono;
    protected String usuario_correo;
    protected String usuario_password;
    protected int usuario_rol;
    protected String usuario_usuario;
    protected String usuario_tipoDocumento;
    protected String usuario_numDocumento;
    

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_telefono() {
        return usuario_telefono;
    }

    public void setUsuario_telefono(String usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
    }

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }

    public int getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(int usuario_rol) {
        this.usuario_rol = usuario_rol;
    }
        
}
