package org.antoniofulg;

import java.util.List;

import io.micrometer.core.annotation.Counted;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

  @GET
  @Counted(value = "counted.getPessoa")
  public List<Pessoa> getPessoa() {
    return Pessoa.listAll();
  }

  @GET
  @Path("findByYearOfBirth")
  public List<Pessoa> findByYearOfBirth(@QueryParam("yearOfBirth") int yearOfBirth) {
    return Pessoa.findByYearOfBirth(yearOfBirth);
  }

  @POST
  @Transactional
  public Pessoa createPessoa(Pessoa pessoa) {
    pessoa.id = null;
    pessoa.persist();

    return pessoa;
  }

  @PUT
  @Transactional
  public Pessoa updatePessoa(Pessoa pessoa) {
    Pessoa p = Pessoa.findById(pessoa.id);
    p.name = pessoa.name;
    p.yearOfBirth = pessoa.yearOfBirth;
    p.persist();

    return pessoa;
  }

  @DELETE
  @Transactional
  public void deletePessoa(int id) {
    Pessoa p = Pessoa.findById(id);
    p.delete();
  }
}
