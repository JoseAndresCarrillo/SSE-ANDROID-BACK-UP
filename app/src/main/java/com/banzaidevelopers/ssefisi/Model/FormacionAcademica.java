package com.banzaidevelopers.ssefisi.Model;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public class FormacionAcademica {

    private int id_estudio;
    private String fecha_egreso;
    private String institucion;
    private String programa_academico;
    private String fecha_ingreso;
    private String tipo_programa_academico;

    public int getIdEstudio() {
        return id_estudio;
    }

    public void setIdEstudio(int id_estudio) {
        this.id_estudio = id_estudio;
    }

    public String getFechaEgreso() {
        return fecha_egreso;
    }

    public void setFechaEgreso(String fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getProgramaAcademico() {
        return programa_academico;
    }

    public void setProgramaAcademico(String programa_academico) {
        this.programa_academico = programa_academico;
    }

    public String getFechaIngreso() {
        return fecha_ingreso;
    }

    public void setFechaIngreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getTipoProgramaAcademico() {
        return tipo_programa_academico;
    }

    public void setTipoProgramaAcademico(String tipo_programa_academico) {
        this.tipo_programa_academico = tipo_programa_academico;
    }

}