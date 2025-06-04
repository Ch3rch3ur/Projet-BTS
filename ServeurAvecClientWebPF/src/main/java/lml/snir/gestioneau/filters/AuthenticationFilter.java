package lml.snir.gestioneau.filters;

import lml.snir.gestioneau.beans.LoginBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtre pour restreindre l'accès aux pages sécurisées
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthenticationFilter implements Filter {
    
    /**
     * Liste des pages qui sont accessibles sans authentification
     */
    private static final String[] ALLOWED_PAGES = {
        "/login.xhtml",
        "/javax.faces.resource/"   // Permet l'accès aux ressources (CSS, JS, images)
    };
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        
        // Vérifie si l'URL demandée est une page publique
        boolean isAllowedPage = false;
        for (String page : ALLOWED_PAGES) {
            if (requestURI.contains(page)) {
                isAllowedPage = true;
                break;
            }
        }
        
        // Vérifie si l'utilisateur est connecté ou s'il accède à une page publique
        if (isAllowedPage || (session != null && session.getAttribute("loginBean") != null 
                && ((LoginBean) session.getAttribute("loginBean")).isLoggedIn())) {
            chain.doFilter(request, response);
        } else {
            // L'utilisateur n'est pas connecté, redirection vers la page de connexion
            res.sendRedirect(contextPath + "/login.xhtml");
        }
    }
    
    @Override
    public void destroy() {
        // Nettoyage des ressources si nécessaire
    }
}