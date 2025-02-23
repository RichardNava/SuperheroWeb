package com.core.web.rs;

import com.core.dto.SuperheroDTO;
import com.core.entities.Superhero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/superhero")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuperheroService {

//    @PersistenceContext(name = "SuperHeroesWebPU")
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperHeroesWebPU");

    //private Gson gson = new Gson();
//    @GET
//    public Response ping(){
//        return Response
//                .ok("ping Jakarta EE")
//                .build();
//    }
    @GET //@Path("/name")
    public Response busquedaSuperheroes() {
        try (EntityManager em = emf.createEntityManager();) {
            List<Superhero> superheroList = em.createNamedQuery("Superhero.findAll").getResultList();
            return Response.ok(superheroList).build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseMSG(2, e.getMessage()))
                    .build();
        }
    }

    // @PUT -> metodo update() @DELETE -> metodo delete() 
    @GET
    @Path("/{id}")
    public Response getSuperheroById(@PathParam("id") int id) {
        try (EntityManager em = emf.createEntityManager();) {
            Superhero superhero = em.find(Superhero.class, id);
            // String jsonSuperhero = gson.toJson(superhero); // "{'id':2,'name':'Atomic-boy'...}"
            if (superhero != null) {
                return Response.ok(SuperheroDTO.convertSuperheroDTO(superhero)).build();
            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseMSG(2, e.getMessage()))
                    .build();
        }
        ResponseMSG msg = new ResponseMSG(id, "ID no disponible");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(msg).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSuperheroById(@PathParam("id") int id) {
        try (EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();
            Superhero superhero = em.find(Superhero.class, id);
            if (superhero != null) {
                em.remove(superhero);
                em.getTransaction().commit();
                return Response.ok(new ResponseMSG(1, "Superhero eliminado con éxito")).build();
            } else {
                em.getTransaction().rollback();
                ResponseMSG msg = new ResponseMSG(id, "ID no disponible");
                return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
            }

        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseMSG(2, e.getMessage()))
                    .build();
        }
    }

    @POST
    public Response createSuperhero(Superhero superhero) {
        try (EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();
            em.persist(superhero);
            em.getTransaction().commit();
            return Response
                    .ok(new ResponseMSG(1, "Superhero añadido con éxito"))
                    .build();
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException ex) {
                for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
                    System.out.println("Violación de constraint: " + violation.getMessage());
                }
            }
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseMSG(2, e.getMessage()))
                    .build();
        }
    }

    @PUT
    public Response updateSuperhero(Superhero superhero) {
        try (EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();
            em.merge(superhero);
            em.getTransaction().commit();
            return Response
                    .ok(new ResponseMSG(1, "Superhero modificado con éxito"))
                    .build();
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException ex) {
                for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
                    System.out.println("Violación de constraint: " + violation.getMessage());
                }
            }
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseMSG(2, e.getMessage()))
                    .build();
        }
    }

    public class ResponseMSG {

        private int code;
        private String msg;

        public ResponseMSG(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }
}
