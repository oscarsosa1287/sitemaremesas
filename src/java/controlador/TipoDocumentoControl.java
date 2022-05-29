/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.TipoDocumentoDao;
import modelo.entidad.TipoDocumento;

/**
 *
 * @author Oscar Sosa
 */
//@Named(value = "tipoDocumentoControl")
//@Dependent
@ManagedBean
@ViewScoped
public class TipoDocumentoControl implements Serializable {

    private List<TipoDocumento> listaTipoDocumentos;
    private TipoDocumento tipoDocumento;

    /**
     * Creates a new instance of TipoDocumentoControl
     */
    public TipoDocumentoControl() {
    }

    public List<TipoDocumento> getListaTipoDocumentos() {
        TipoDocumentoDao ed = new TipoDocumentoDao();
        listaTipoDocumentos = ed.listarTipoDocumento();
        return listaTipoDocumentos;
    }

    public void setListaTipoDocumentos(List<TipoDocumento> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void limpiarTipoDocumento() {
        tipoDocumento = new TipoDocumento();
    }

    public void agregarTipoDocumento() {
        TipoDocumentoDao ed = new TipoDocumentoDao();       
        ed.agregar(tipoDocumento);
    }

    public void modificarTipoDocumento() {
        TipoDocumentoDao ed = new TipoDocumentoDao();
        ed.modificar(tipoDocumento);
        limpiarTipoDocumento();
    }

    public void eliminarTipoDocumento() {
        TipoDocumentoDao ed = new TipoDocumentoDao();
        ed.eliminar(tipoDocumento);
        limpiarTipoDocumento();

    }
}

