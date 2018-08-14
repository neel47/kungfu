
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Rank;

public interface RankService {

	public void addRank(Rank rank);

	public List<Rank> getAllRanks(String specs, String orderBy);

	public void deleteRank(Integer rankId);

	public Rank updateRank(Rank rank);

	public Rank getRank(int rankid);
}
