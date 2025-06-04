package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean rememberMe;
    private boolean loggedIn = false;

    /**
     * Authentifie l'utilisateur
     *
     * @return redirection vers la page d'accueil si authentification réussie
     */
    public String login() {
        // Dans un environnement de production, cette logique devrait être remplacée
        // par une authentification sécurisée (LDAP, base de données, etc.)
        if ("admin".equals(username) && "admin123".equals(password)) {
            loggedIn = true;
            return "/index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur d'authentification",
                            "Identifiant ou mot de passe incorrect")
            );
            return null;
        }
    }

    /**
     * Déconnecte l'utilisateur
     *
     * @return redirection vers la page de connexion
     */
    public String logout() {
        // Invalidation de la session
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        loggedIn = false;
        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Vérifie si l'utilisateur est connecté
     *
     * @return true si l'utilisateur est connecté
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    // Getters et Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
