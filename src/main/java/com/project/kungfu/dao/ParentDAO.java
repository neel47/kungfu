
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Parent;

public interface ParentDAO {

	public void addParent(Parent parent);

	public List<Parent> getAllParents(String specs, String orderBy);

	public void deleteParent(Integer parentId);

	public Parent updateParent(Parent parent);

	public Parent getParent(int parentid);
}
