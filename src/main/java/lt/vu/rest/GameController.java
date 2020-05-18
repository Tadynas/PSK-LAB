package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.entities.User;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.PublishersDAO;
import lt.vu.rest.contracts.GameDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/games")
public class GameController {

    @Inject
    @Setter
    @Getter
    private GamesDAO gamesDAO;

    @Inject
    @Getter
    private PublishersDAO publishersDAO;

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@QueryParam("id") int id)
    {
        Game game = gamesDAO.findOne(id);
        if (game == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else
        {
            GameDto gameDto = new GameDto(game.getTitle(), game.getPrice(), game.getCoverLink(), game.getPublisher().getId());
            return Response.ok(gameDto).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addGame(GameDto gameDto)
    {
        Game gameToAdd = new Game();
        gameToAdd.setTitle(gameDto.getTitle());
        gameToAdd.setPrice(gameDto.getPrice());
        gameToAdd.setCoverLink(gameDto.getCoverLink());
        gameToAdd.setPublisher(publishersDAO.findOne(gameDto.getPublisherId()));
        gamesDAO.persist(gameToAdd);
        return Response.ok().build();
    }

    @PUT
    @Path("/modify")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response modifyGame(@QueryParam("id") int id, GameDto gameDto)
    {
        try {
            Game gameToModify = gamesDAO.findOne(id);
            if (gameToModify == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            gameToModify.setTitle(gameDto.getTitle());
            gameToModify.setPrice(gameDto.getPrice());
            gameToModify.setCoverLink(gameDto.getCoverLink());
            gameToModify.setPublisher(publishersDAO.findOne(gameDto.getPublisherId()));
            gamesDAO.update(gameToModify);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
