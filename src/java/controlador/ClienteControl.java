/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.ClienteDao;
import modelo.dao.TipoDocumentoDao;
import modelo.entidad.Cliente;
import modelo.entidad.TipoDocumento;

/**
 *
 * @author Oscar
 */
//@Named(value = "clienteControl")
//@Dependent
@ManagedBean
@ViewScoped
public class ClienteControl implements Serializable {

    private List<Cliente> listaClientes;
    private Cliente cliente;
    
     // agregado para el combo
    private List<SelectItem> listaTipoDocumentos;
    
    // agregado para capturar el id de usuario
////    @ManagedProperty("#{loginControl}")
////    private LoginControl loginControl;

    /**
     * Creates a new instance of ClienteControl
     */
    public ClienteControl() {
        // agregado para el combo
        cliente = new Cliente();
    }

    public List<Cliente> getListaClientes() {
        ClienteDao ed = new ClienteDao();
        listaClientes = ed.listarClientes();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void limpiarCliente() {
        cliente = new Cliente();
    }

    public void agregarCliente() {
        ClienteDao ed = new ClienteDao();
        ed.agregar(cliente);
    }

    public void modificarCliente() {
        ClienteDao ed = new ClienteDao();
        ed.modificar(cliente);
        limpiarCliente();
    }

    public void eliminarCliente() {
        ClienteDao ed = new ClienteDao();
        ed.eliminar(cliente);
        limpiarCliente();
    }
    
//    public LoginControl getLoginControl() {
//        return loginControl;
//    }
//
//    public void setLoginControl(LoginControl loginControl) {
//        this.loginControl = loginControl;
//    }

    // para combos
    public List<SelectItem> getListaTipoDocumentos() {
        this.listaTipoDocumentos = new ArrayList<SelectItem>();
        TipoDocumentoDao td = new TipoDocumentoDao();
        List<TipoDocumento> tipoDocumentos = td.listarTipoDocumento();
        listaTipoDocumentos.clear();
        for (TipoDocumento tipoDocumento : tipoDocumentos) {
            SelectItem tipoDocumentoItem = new SelectItem(tipoDocumento.getIdTipoDocumento(), tipoDocumento.getNombreTipoDocumento());
            listaTipoDocumentos.add(tipoDocumentoItem);
        }
        return listaTipoDocumentos;
    }

}