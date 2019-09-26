package com.mindheld.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mindheld.entity.Game;
import com.mindheld.entity.GamesHistory;
import com.mindheld.model.GameDTO;
import com.mindheld.model.GameHistoryDTO;
import com.mindheld.repository.GameHistoryRepository;
import com.mindheld.repository.GameRepository;
import com.mindheld.service.GameService;
import com.mindheld.service.StudentService;

@Service("gameService")
public class GameServiceImpl implements GameService {

	@Autowired
	@Qualifier("gameRepository")
	private GameRepository gameRepository;
	
	@Autowired
	@Qualifier("gameHistoryRepository")
	private GameHistoryRepository gameHistoryRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public List<GameDTO> findAll() {
		var games = gameRepository.findAll();
		return convertGamesToGamesDTO(games);
	}

	@Override
	public Game save(Game game) {
		return gameRepository.save(game);
	}

	
	@Override
	public void edit(GameDTO gameDto) {
		var game = gameRepository.findByGameId(gameDto.getGameId());
		game.setEnabled(gameDto.isEnabled());
		save(game);
	}
	@Override
	public void delete(long gameId) {
		var game = gameRepository.findByGameId(gameId);
		game.setEnabled(Boolean.FALSE);
		save(game);
	}

	@Override
	public List<GameDTO> getAllEnabled() {
		var games = gameRepository.findByEnabled(Boolean.TRUE);
		return convertGamesToGamesDTO(games);
	}
	
	@Override
	public GameHistoryDTO saveGameHistory(GameHistoryDTO gameHistoryDTO) {
		var entity = gameHistoryRepository.save(gameHistoryDTOToEntity(gameHistoryDTO));
		return gameHistoryEntityToDTO(entity);
	}
	
	private List<GameDTO> convertGamesToGamesDTO(List<Game> games){
		var gamesDTO = new ArrayList<GameDTO>();
		games.forEach((@NotNull var game) -> gamesDTO.add(new GameDTO(game)) );
		return gamesDTO;
	}
	
	private GamesHistory gameHistoryDTOToEntity(GameHistoryDTO gameHistoryDTO){
		var gameEntity = new GamesHistory();
		gameEntity.setGamesHistoryId(gameHistoryDTO.getGameHistoryId());
		gameEntity.setStartPlaying(gameHistoryDTO.getStartPlaying());
		gameEntity.setEndPlaying(gameHistoryDTO.getEndPlaying());
		gameEntity.setStudent(studentService.findStudentEntityById(gameHistoryDTO.getStudentId()));
		gameEntity.setGame(gameRepository.findByGameId(gameHistoryDTO.getGameId()));
		return gameEntity;		
	}
	
	private GameHistoryDTO gameHistoryEntityToDTO(GamesHistory gameHistory){
		var gameHistoryDTO = new GameHistoryDTO();
		gameHistoryDTO.setGameHistoryId(gameHistory.getGamesHistoryId());
		gameHistoryDTO.setStartPlaying(gameHistory.getStartPlaying());
		gameHistoryDTO.setEndPlaying(gameHistory.getEndPlaying());
		gameHistoryDTO.setStudentId(gameHistory.getStudent().getStudentId());
		gameHistoryDTO.setGameId(gameHistory.getGame().getGameId());
		return gameHistoryDTO;		
	}
	
	
	

	
}
