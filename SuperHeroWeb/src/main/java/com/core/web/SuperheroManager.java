package com.core.web;

import com.core.entities.Superhero;
import com.core.entities.Team;
import com.core.entities.User;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.primefaces.PrimeFaces;

@Named(value = "superHeroController") //CDI Bean
@SessionScoped
public class SuperheroManager implements Serializable {

    // Campos de clase
    private static final long serialVersionUID = 1L;

    // @PersistenceContext(name = "SuperHeroesWebPU")
    private EntityManager em;
    private List<Superhero> currentSuperherosList, filteredSuperheroes;
    private Superhero currentSuperhero;
    private User currentUser;
    private boolean showAsList;
    private int idCurrentUser; // Provisional 
    private String source = "", errorMsg;
    private int credits = 20;

    @PostConstruct
    public void init() throws IOException {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (facesContext != null) {
                this.currentUser = (User) facesContext.getExternalContext().getSessionMap().get("user");
            }
            em = Persistence.createEntityManagerFactory("SuperHeroesWebPU").createEntityManager();
            this.currentSuperherosList = this.viewData();
            if (filteredSuperheroes == null) {
                this.filteredSuperheroes = new ArrayList<>();
            }
            currentUser.getTeamList().forEach(s -> System.out.println("heroId-> " + s.getHeroId()));
            System.out.println("_".repeat(40));
            findTeam();
        } catch (Exception ex) {
            errorMsg = "Error al recuperar los datos";
            throw new IOException(errorMsg);
        }
    }

    // Constructor
    public SuperheroManager() {
        this.currentSuperherosList = new ArrayList<>();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    // Accesor Methods (Getters&Setters)
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<Superhero> getFilteredSuperheroes() {
        return filteredSuperheroes;
    }

    public void setFilteredSuperheroes(List<Superhero> filteredSuperheroes) {
        this.filteredSuperheroes = filteredSuperheroes;
    }

    public boolean isShowAsList() {
        return showAsList;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setShowAsList(boolean showAsList) {
        this.showAsList = showAsList;
    }

    public Superhero getCurrentSuperhero() {
        return currentSuperhero;
    }

    public void setCurrentSuperhero(Superhero currentSuperhero) {
        this.currentSuperhero = currentSuperhero;
    }

    public int getIdCurrentUser() {
        return idCurrentUser;
    }

    public void setIdCurrentUser(int idCurrentUser) {
        this.idCurrentUser = idCurrentUser;
    }

    public List<Superhero> getCurrentSuperherosList() {
        return currentSuperherosList;
    }

    public void setCurrentSuperherosList(List<Superhero> currentSuperherosList) {
        this.currentSuperherosList = currentSuperherosList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    // OTROS METODOS
    public List<Superhero> viewData() throws IOException {
        try {
            List<Superhero> list = em.createQuery("SELECT s FROM Superhero s").getResultList();
            return list;
        } catch (Exception e) {
            throw new IOException("¡Error al recuperar los datos!");
        }
    }

    public String addHeroToTeam(Superhero superhero) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Duplicado!", "¡¡No puedes tener Superheroes repetidos!!");
        if (!filteredSuperheroes.stream().anyMatch(s -> s.getName().equals(superhero.getName()))) {
            if ((credits - superhero.getPrice()) >= 0 && filteredSuperheroes.size() <= 5) {
                this.credits -= superhero.getPrice();
                this.filteredSuperheroes.add(superhero);
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Exito!", "¡¡Superheroe añadido con éxito!!");
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "¡Cuidado!", "No se puede superar el limite de superheroes (6) o creditos (20).");
            }
        }
        FacesContext.getCurrentInstance()
                .addMessage(null, fm);
        return "create";
    }

    public void removeSuperhero(int id, int price) {
        filteredSuperheroes.removeIf(s -> s.getId() == id);
        credits += price;

    }

    public String saveTeam() {
        List<Team> teams = em.createNamedQuery("Team.findAll").getResultList();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Equipo Guardado!", "Ya tienes equipo. Prueba a combatir con él.");
        if (teams != null && !teams.stream().anyMatch(t -> Objects.equals(t.getUserId().getId(), currentUser.getId()))) {
            try {
                em.getTransaction().begin();
                filteredSuperheroes.stream().forEach(s -> {
                    Team t = new Team(s, currentUser);
                    em.persist(t);
                });
                em.getTransaction().commit();
                filteredSuperheroes.clear();
                credits = 20;
            } catch (Exception e) {
                em.getTransaction().rollback();
                errorMsg = "Error al añadir el equipo";
                return "error";
            }
        } else {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Ya tienes equipo!", "Si quieres crear un equipo nuevo, debes eliminar el actual.");
        }
        updateProfile();
        FacesContext.getCurrentInstance()
                .addMessage(null, fm);
        return "create";
    }

    public String logout() {
        try {
            this.currentUser = null;
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
            facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/index.jsp");
        } catch (IOException ex) {
            errorMsg = ex.getMessage();
            return "error";
        }
        return "";
    }

    public String viewInfo(Superhero superhero) {
        this.currentSuperhero = superhero;
        return "detail";
    }

    public void toggleView() {
        this.showAsList = !this.showAsList;
        PrimeFaces.current().ajax().update("viewContainer");
    }

    public String deleteTeam() {
        FacesMessage fm;
        try {
            if (!this.currentUser.getTeamList().isEmpty()) {
                em.getTransaction().begin();
                this.currentUser.getTeamList().forEach(t -> {
                    Team team = em.merge(t);
                    em.remove(team);
                });
                em.getTransaction().commit();

                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Equipo Eliminado!", "Has eliminado tu equipo con éxito.");
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡No tienes equipo que eliminar!", "Debes tener equipo para poder eliminarlo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha podido eliminar el equipo.");
        }
        updateProfile();
        FacesContext.getCurrentInstance().addMessage(null, fm);
        PrimeFaces.current().ajax().update("btnContainer");
        return "profile";
    }

    public String editProfile() {
        //TODO: Implementar lógica para editar el perfil de currentUser
        System.out.println("WORK IN PROGRESS");
        return "";
    }

    public void updateProfile() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            this.currentUser.setTeamList(findTeam());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", currentUser);
            currentUser.getTeamList().forEach(s -> System.out.println("heroId-> " + s.getHeroId()));
        }
    }

    public List<Team> findTeam() {
        return em.createNativeQuery("SELECT * FROM team WHERE user_id = ?",Team.class).setParameter(1, currentUser.getId()).getResultList();
    }
}
