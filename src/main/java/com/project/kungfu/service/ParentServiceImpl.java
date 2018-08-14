package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.ParentDAO;
import com.project.kungfu.model.Parent;

@Service("parentService")
@Transactional
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentDAO parentDAO;

	@Override
	public void addParent(Parent parent) {
		parentDAO.addParent(parent);
		
	}

	@Override
	public List<Parent> getAllParents(String specs, String orderBy) {
		return parentDAO.getAllParents(specs, orderBy);
	}

	@Override
	public void deleteParent(Integer parentId) {
		parentDAO.deleteParent(parentId);
		
	}

	@Override
	public Parent updateParent(Parent parent) {
		return parentDAO.updateParent(parent);
	}

	@Override
	public Parent getParent(int parentid) {
	return	parentDAO.getParent(parentid);
	}

	
	

}
