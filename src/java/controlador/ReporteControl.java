/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Rolando
 */
@ManagedBean
@ViewScoped
public class ReporteControl {

    JasperPrint jasperPrint;
    HttpServletResponse httpServletResponse = null;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Creates a new instance of ReporteControl
     */
    public ReporteControl() {
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }   
    

    public void generarReporte(String nombreReporte) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remesas", "root", "");
        } catch (Exception ex) {
            System.out.println("Error de conexion: " + ex.getMessage());
        }

        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportPath = sc.getRealPath("vista/reportes/" + nombreReporte + ".jasper");
        Map<String, Object> parametros = new HashMap<>();

        if (nombreReporte.equalsIgnoreCase("remesasfechas")) {
            parametros.put("fecha_inicio", fechaInicio);
            parametros.put("fecha_fin", fechaFin);
        }

        try {
            jasperPrint = JasperFillManager.fillReport(reportPath, parametros, con);
        } catch (JRException ex) {
            Logger.getLogger(ReporteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "inline; filename=" + nombreReporte + ".pdf");
        ServletOutputStream servletOutputStream;
        try {
            servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ReporteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().responseComplete();
        
    }

}
