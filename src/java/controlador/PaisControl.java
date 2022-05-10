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
import modelo.dao.PaisDao;
import modelo.entidad.Pais;

/**
 *
 * @author Rolando
 */
//@Named(value = "paisControl")
//@Dependent
@ManagedBean
@ViewScoped
public class PaisControl implements Serializable {

    private List<Pais> listaPaises;
    private Pais pais;

    /**
     * Creates a new instance of PaisControl
     */
    public PaisControl() {
    }

    public List<Pais> getListaPaises() {
        PaisDao ed = new PaisDao();
        listaPaises = ed.listarPaises();
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void limpiarPais() {
        pais = new Pais();
    }

    public void agregarPais() {
        PaisDao ed = new PaisDao();
        ed.agregar(pais);
    }

    public void modificarPais() {
        PaisDao ed = new PaisDao();
        ed.modificar(pais);
        limpiarPais();
    }

    public void eliminarPais() {
        PaisDao ed = new PaisDao();
        ed.eliminar(pais);
        limpiarPais();
    }

}
