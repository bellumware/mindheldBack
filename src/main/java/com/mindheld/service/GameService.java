package com.mindheld.service;

import java.util.List;

import com.mindheld.entity.Game;
import com.mindheld.model.GameDTO;
import com.mindheld.model.GameHistoryDTO;

public interface GameService {

	public List<GameDTO> findAll();	
	public Game save(Game game);
    public void delete(long gameId);
    public List<GameDTO> getAllEnabled();
    public GameHistoryDTO saveGameHistory(GameHistoryDTO gameHistoryDTO);
    public void edit(GameDTO gameDto);
}
