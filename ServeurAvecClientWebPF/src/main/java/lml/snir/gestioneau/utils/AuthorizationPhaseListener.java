package lml.snir.gestioneau.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lml.snir.gestioneau.beans.LoginBean;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Listener de phase JSF qui redirige les utilisateurs non connectés vers la page de connexion
 */
public class AuthorizationPhaseListener implements PhaseListener {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession(false);
        
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        
        // Vérifier si l'utilisateur demande la page de connexion ou des ressources
        boolean isResourceRequest = requestURI.contains(ResourceHandler.RESOURCE_IDENTIFIER);
        boolean isLoginPage = requestURI.contains("/login.xhtml");
        
        // Si ce n'est pas une demande de ressource ou la page de connexion,
        // et que l'utilisateur n'est pas connecté, le rediriger vers la page de connexion
        if (!isResourceRequest && !isLoginPage) {
            if (session == null || session.getAttribute("loginBean") == null ||
                !((LoginBean) session.getAttribute("loginBean")).isLoggedIn()) {
                try {
                    response.sendRedirect(contextPath + "/login.xhtml");
                    facesContext.responseComplete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (isLoginPage) {
            // Si c'est la page de connexion et que l'utilisateur est déjà connecté,
            // le rediriger vers l'index
            if (session != null && session.getAttribute("loginBean") != null &&
                ((LoginBean) session.getAttribute("loginBean")).isLoggedIn()) {
                try {
                    response.sendRedirect(contextPath + "/index.xhtml");
                    facesContext.responseComplete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // Rien à faire ici
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}