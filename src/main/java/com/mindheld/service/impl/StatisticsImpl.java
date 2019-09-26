package com.mindheld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindheld.entity.GameResult;
import com.mindheld.entity.GamesEnabled;
import com.mindheld.entity.GamesStatistics;
import com.mindheld.entity.Student;
import com.mindheld.entity.StudentsCreateStatistic;
import com.mindheld.entity.StudentsEnabled;
import com.mindheld.model.GameResultDTO;
import com.mindheld.model.ObservationStatisticsDTO;
import com.mindheld.repository.GameResultRepository;
import com.mindheld.repository.GamesEnabledRepository;
import com.mindheld.repository.GamesStatisticsRepository;
import com.mindheld.repository.ObservationPerUserStatisticRepository;
import com.mindheld.repository.ObservationStatisticRepository;
import com.mindheld.repository.StudentsCreateStatisticRepository;
import com.mindheld.repository.StudentsEnabledRepository;
import com.mindheld.service.GameService;
import com.mindheld.service.StatisticsService;

@Service("statisticsService")
public class StatisticsImpl implements StatisticsService {

	@Autowired
	private StudentsCreateStatisticRepository studentsCreateStatisticRepository;
	@Autowired
	private StudentsEnabledRepository studentsEnabledRepository;
	@Autowired
	private GamesEnabledRepository gamesEnabledRepository;
	@Autowired
	private GamesStatisticsRepository gamesStatisticsRepository;
	@Autowired
	private ObservationStatisticRepository observationStatisticRepository;
	@Autowired
	private ObservationPerUserStatisticRepository observationPerUserStatisticRepository;
	@Autowired
	private GameResultRepository gameResultRepository;
	@Autowired
	private GameService gameService;

	@Override
	public List<StudentsCreateStatistic> getStudentsCreateStatistic() {
		return studentsCreateStatisticRepository.findAll();
	}

	@Override
	public List<StudentsEnabled> getStudentsEnabledtistic() {
		return studentsEnabledRepository.findAll();
	}

	@Override
	public List<GamesEnabled> getGamesEnabledtistic() {
		return gamesEnabledRepository.findAll();
	}

	@Override
	public List<GamesStatistics> getGamesStatisticsByStudent(String studentId) {
		var _return = gamesStatisticsRepository.findByStudentId(studentId);
		var _returnGames = new ArrayList<String>();
		var games = gameService.findAll();
		_return.forEach(value -> _returnGames.add(value.getGameName()));
		games.forEach(game -> {
			if (!_returnGames.contains(game.getName())) {
				_return.add(new GamesStatistics(game.getName(), studentId));
			}
		});
		return _return;
	}

	@Override
	public ObservationStatisticsDTO getObservationStatisticByStudent(String studentId) {
		var _return = new ObservationStatisticsDTO();
		_return.setObservationsPerMonth(observationStatisticRepository.findByStudentId(studentId));
		_return.setObservationsPerUser(observationPerUserStatisticRepository.findByStudentId(studentId));
		return _return;
	}

	@Override
	public List<GameResultDTO> getGameResultsByStudent(Student student) {
		var result = new ArrayList<GameResultDTO>();
		var gameResults = gameResultRepository.findByStudentOrderByGameAsc(student);
		var gameAux = new GameResultDTO();
		for (GameResult gameResult : gameResults) {
			if (!gameResult.getGame().getName().equals(gameAux.getGameName())) {
				gameAux.generateXaxis();
				result.add(gameAux);
				gameAux = new GameResultDTO();
				gameAux.setGameName(gameResult.getGame().getName());
			}
			gameAux.addSucces(gameResult.getSuccess());
			gameAux.addFail(gameResult.getFails());
		}
		result.remove(0);
		gameAux.generateXaxis();
		result.add(gameAux);
		return result;
	}

	@Override
	public void saveResult(GameResult gameResult) {
		gameResultRepository.save(gameResult);
	}

}
