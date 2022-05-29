package modelo.entidad;
// Generated 05-08-2022 02:05:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private TipoDocumento tipoDocumento;
     private String NDocumento;
     private String nombre;
     private String apellido;
     private String telefono;
     private Set<Remesa> remesas = new HashSet<Remesa>(0);

    public Cliente() {
        //para combo
        tipoDocumento = new TipoDocumento();
    }

    public Cliente(TipoDocumento tipoDocumento, String NDocumento, String nombre, String apellido, String telefono, Set<Remesa> remesas) {
       this.tipoDocumento = tipoDocumento;
       this.NDocumento = NDocumento;
       this.nombre = nombre;
       this.apellido = apellido;
       this.telefono = telefono;
       this.remesas = remesas;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNDocumento() {
        return this.NDocumento;
    }
    
    public void setNDocumento(String NDocumento) {
        this.NDocumento = NDocumento;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set<Remesa> getRemesas() {
        return this.remesas;
    }
    
    public void setRemesas(Set<Remesa> remesas) {
        this.remesas = remesas;
    }




}


