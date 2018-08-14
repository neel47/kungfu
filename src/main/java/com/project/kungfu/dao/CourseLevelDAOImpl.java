package com.project.kungfu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kungfu.model.CourseLevel;
import com.project.kungfu.model.Instructor;

@Repository("courseLevelDAO")
public class CourseLevelDAOImpl implements CourseLevelDAO {

	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public void addCourseLevel(CourseLevel courseLevel) {
		sessionFactory.getCurrentSession().saveOrUpdate(courseLevel);
		
	}

	@Override
	public List<CourseLevel> getAllCourseLevels(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" CourseLevel ");
		specification.append(" ");
		if (null != specs && !"".equals(specs)) {
			specification.append(" where ");
			/*
			 * if(specs.lastIndexOf(",") >= 0) specs=specs.substring(0,
			 * specs.lastIndexOf(","));
			 */

			String[] filters = specs.split("&");
			for (String filter : filters) {
				String[] filterKeyValuePairs = filter.split(":");

				if (filterKeyValuePairs[1].trim().lastIndexOf("!") >= 0) {
					specification
							.append(" " + filterKeyValuePairs[1].trim().substring(1, filterKeyValuePairs[1].length())
									+ " not in (" + filterKeyValuePairs[0].trim() + " )");
				} else if (filterKeyValuePairs[1].trim().lastIndexOf("^") >= 0) {
					specification
							.append(" " + filterKeyValuePairs[1].trim().substring(1, filterKeyValuePairs[1].length())
									+ " in (" + filterKeyValuePairs[0].trim() + " )");
				} else {
					specification.append(
							" " + filterKeyValuePairs[1].trim() + " = '" + filterKeyValuePairs[0].trim() + "' ");
				}

				specification.append(" and ");
			}
		}

		if (specification.lastIndexOf("and") >= 0)
			specs = specification.substring(0, specification.lastIndexOf("and"));
		else
			specs = specification.toString();

		if (null != orderBy && !"".equals(orderBy)) {
			specs += " order by " + orderBy;
		}
		return sessionFactory.getCurrentSession().createQuery(specs).list();
	}

	@Override
	public void deleteCourseLevel(Integer courseLevelId) {
		CourseLevel courseLevel = (CourseLevel) sessionFactory.getCurrentSession().load(CourseLevel.class, courseLevelId);
		if (null != courseLevel) {
			this.sessionFactory.getCurrentSession().delete(courseLevel);
		}
		
	}

	@Override
	public CourseLevel updateCourseLevel(CourseLevel courseLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseLevel getCourseLevel(int courseLevelid) {
		return (CourseLevel) sessionFactory.getCurrentSession().get(CourseLevel.class, courseLevelid);
	}
	
	
	
	
	
	

}
