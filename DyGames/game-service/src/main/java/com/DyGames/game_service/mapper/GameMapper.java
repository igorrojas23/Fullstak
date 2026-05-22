package com.DyGames.game_service.mapper;

import com.DyGames.game_service.client.CategoryClient;
import com.DyGames.game_service.dto.GameRespuesta;
import com.DyGames.game_service.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameMapper {

    @Autowired
    private CategoryClient categoryClient;

    public GameRespuesta toDTO(Game game) {
        if (game == null) return null;
        GameRespuesta gr = new GameRespuesta();
        gr.setId(game.getId());
        gr.setTitulo(game.getTitulo());
        gr.setDesarrollador(game.getDesarrollador());
        gr.setPrecio(game.getPrecio());
        gr.setFechaLanzamiento(game.getFechaLanzamiento());
        gr.setCoverUrl(game.getCoverUrl());
        gr.setCategoria(categoryClient.buscarCategoriaPorId(game.getCategoriaId()));
        return gr;
    }

    public List<GameRespuesta> toDTOList(List<Game> lista) {
        return lista.stream().map(this::toDTO).toList();
    }
}
