package com.banzaidevelopers.ssefisi.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public class ResponseListadoFormacion {
    private List<FormacionAcademica> formacion_academica = new ArrayList<FormacionAcademica>();

    public List<FormacionAcademica> getFormacion_academica() {
        return formacion_academica;
    }

    public void setFormacion_academica(List<FormacionAcademica> formacion_academica) {
        this.formacion_academica = formacion_academica;
    }
}
