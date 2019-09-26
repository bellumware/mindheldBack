package com.mindheld.model;

import java.util.List;

import com.mindheld.entity.ObservationPerUserStatistic;
import com.mindheld.entity.ObservationStatistic;

public class ObservationStatisticsDTO {

	private List<ObservationStatistic> observationsPerMonth;
	private List<ObservationPerUserStatistic> observationsPerUser;

	public List<ObservationStatistic> getObservationsPerMonth() {
		return observationsPerMonth;
	}

	public void setObservationsPerMonth(List<ObservationStatistic> observationsPerMonth) {
		this.observationsPerMonth = observationsPerMonth;
	}

	public List<ObservationPerUserStatistic> getObservationsPerUser() {
		return observationsPerUser;
	}

	public void setObservationsPerUser(List<ObservationPerUserStatistic> observationsPerUser) {
		this.observationsPerUser = observationsPerUser;
	}
	
	
	
}
