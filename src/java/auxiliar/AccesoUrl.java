/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oscar
 */
public class AccesoUrl implements PhaseListener{
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        String currentPage = fc.getViewRoot().getViewId();
        boolean isPageLogin = currentPage.lastIndexOf("login.xhtml") > -1 ? true : false;

        HttpSession sesion;
        sesion = (HttpSession) fc.getExternalContext().getSession(true);
        Object usuario = sesion.getAttribute("usuario");

        if (!isPageLogin && usuario == null) {
            NavigationHandler nHandler = fc.getApplication().getNavigationHandler();
            nHandler.handleNavigation(fc, null, "/login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}