package modelo.entidad;
// Generated 05-08-2022 02:05:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private int idEstado;
     private String nombreEstado;
     private Set<Remesa> remesas = new HashSet<Remesa>(0);

    public Estado() {
    }

	
    public Estado(int idEstado) {
        this.idEstado = idEstado;
    }
    public Estado(int idEstado, String nombreEstado, Set<Remesa> remesas) {
       this.idEstado = idEstado;
       this.nombreEstado = nombreEstado;
       this.remesas = remesas;
    }
   
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public String getNombreEstado() {
        return this.nombreEstado;
    }
    
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    public Set<Remesa> getRemesas() {
        return this.remesas;
    }
    
    public void setRemesas(Set<Remesa> remesas) {
        this.remesas = remesas;
    }




}


