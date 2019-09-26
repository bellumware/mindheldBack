package com.mindheld.service;

import java.util.List;

import com.mindheld.entity.GameResult;
import com.mindheld.entity.GamesEnabled;
import com.mindheld.entity.GamesStatistics;
import com.mindheld.entity.ObservationStatistic;
import com.mindheld.entity.Student;
import com.mindheld.entity.StudentsCreateStatistic;
import com.mindheld.entity.StudentsEnabled;
import com.mindheld.model.GameResultDTO;
import com.mindheld.model.ObservationStatisticsDTO;

public interface StatisticsService {
	public List<StudentsCreateStatistic> getStudentsCreateStatistic();
	public List<StudentsEnabled> getStudentsEnabledtistic();
	public List<GamesEnabled> getGamesEnabledtistic();
	public List<GamesStatistics> getGamesStatisticsByStudent(String studentId);
	public ObservationStatisticsDTO getObservationStatisticByStudent(String studentId);
	public void saveResult(GameResult gameResult);
	public List<GameResultDTO> getGameResultsByStudent(Student student);

}
