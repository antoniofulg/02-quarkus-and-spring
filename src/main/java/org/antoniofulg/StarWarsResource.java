package org.antoniofulg;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

  @RestClient
  StarWarsService starWarsService;

  @GET
  public String getStarships() {
    return starWarsService.getStarships();
  }
}
