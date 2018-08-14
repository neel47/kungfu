package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.RankDAO;
import com.project.kungfu.model.Rank;

@Service("rankService")
@Transactional
public class RankServiceImpl implements RankService {

	@Autowired
	private RankDAO rankDAO;

	@Override
	public void addRank(Rank rank) {
		rankDAO.addRank(rank);
		
	}

	@Override
	public List<Rank> getAllRanks(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return rankDAO.getAllRanks(specs, orderBy);
	}

	@Override
	public void deleteRank(Integer rankId) {
		rankDAO.deleteRank(rankId);
		
	}

	@Override
	public Rank updateRank(Rank rank) {
	return	rankDAO.updateRank(rank);
	}

	@Override
	public Rank getRank(int rankid) {
		// TODO Auto-generated method stub
		return rankDAO.getRank(rankid);
	}

	
	

}
