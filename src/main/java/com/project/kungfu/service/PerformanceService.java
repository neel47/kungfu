
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Performance;

public interface PerformanceService {

	public void addPerformance(Performance performance);

	public List<Performance> getAllPerformances(String specs, String orderBy);

	public void deletePerformance(Integer performanceId);

	public Performance updatePerformance(Performance performance);

	public Performance getPerformance(int performanceid);
}
