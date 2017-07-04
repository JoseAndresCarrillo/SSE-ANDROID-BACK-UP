package com.banzaidevelopers.ssefisi.Model;

/**
 * Created by Jose on 17/06/2017.
 */

public class LoginPojo {
    private String id_persona;
    private String mensaje;

    public LoginPojo(String id_persona, String mensaje) {
        this.id_persona = id_persona;
        this.mensaje = mensaje;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
