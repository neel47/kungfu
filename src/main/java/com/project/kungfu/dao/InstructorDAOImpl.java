package com.project.kungfu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.kungfu.model.Instructor;
import com.project.kungfu.model.Parent;

@Repository("instructorDAO")
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addInstructor(Instructor instructor) {
		sessionFactory.getCurrentSession().saveOrUpdate(instructor);
		
	}

	@Override
	public List<Instructor> getAllInstructors(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" Instructor ");
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
	public void deleteInstructor(Integer instructorId) {
		Instructor instructor = (Instructor) sessionFactory.getCurrentSession().load(Instructor.class, instructorId);
		if (null != instructor) {
			this.sessionFactory.getCurrentSession().delete(instructor);
		}
		
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor getInstructor(int instructorid) {
		return (Instructor) sessionFactory.getCurrentSession().get(Instructor.class, instructorid);
	}

	@Override
	public Instructor getUserByUserName(String userName) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.openSession();
				Query query = session.createQuery("from Instructor where LOGINID = :username");
				query.setParameter("username", userName);
				Instructor instructor = (Instructor) query.uniqueResult();
				session.close();
				return instructor;
	}
	
	
	
	
	
	

}
