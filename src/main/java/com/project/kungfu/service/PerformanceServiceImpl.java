package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.PerformanceDAO;
import com.project.kungfu.model.Attendance;
import com.project.kungfu.model.Performance;

@Service("performanceService")
@Transactional
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	private PerformanceDAO performanceDAO;

	@Override
	public void addPerformance(Performance performance) {
		performanceDAO.addPerformance(performance);
		
	}

	@Override
	public List<Performance> getAllPerformances(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return performanceDAO.getAllPerformances(specs, orderBy);
	}

	@Override
	public void deletePerformance(Integer performanceId) {
		performanceDAO.deletePerformance(performanceId);
		
	}

	@Override
	public Performance updatePerformance(Performance performance) {
		// TODO Auto-generated method stub
		return performanceDAO.updatePerformance(performance);
	}

	@Override
	public Performance getPerformance(int performanceid) {
		// TODO Auto-generated method stub
		return performanceDAO.getPerformance(performanceid);
	}

	
	
	

}
