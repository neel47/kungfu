package com.project.kungfu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.kungfu.model.Rank;
import com.project.kungfu.service.RankService;

@Controller
public class RankController {

	@Autowired
	private RankService rankService;

	@RequestMapping(value = "/RankCreation")
	public ModelAndView rankCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Rank rank = new Rank();
		String sid = request.getSession().getId();
		model.addObject("rank", rank);
		model.setViewName("rankForm");
		return model;
	}

	@RequestMapping(value = "/RankCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("rank") Rank rank, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in rank Controller");
		}
		
		rankService.addRank(rank);
		model.setViewName("redirect:/RankList");
		return model;
	}

	@RequestMapping(value = "/RankList")
	public ModelAndView rankList(ModelAndView model, HttpServletRequest request) throws IOException {

		List<Rank> ranktList = rankService.getAllRanks("", " RANK_LEVEL asc ");
		String sid = request.getSession().getId();
		model.addObject("ranktList", ranktList);
		model.setViewName("rankList");
		return model;
	}

	@RequestMapping(value = "/RankEdit")
	public ModelAndView editRank(ModelAndView model, HttpServletRequest request) throws IOException {

		int rankid = Integer.parseInt(request.getParameter("id"));
		Rank rank =rankService.getRank(rankid);
		String sid = request.getSession().getId();
		model.addObject("rank", rank);
		model.setViewName("rankForm");
		return model;
	}

	@RequestMapping(value = "/RankDelete")
	public ModelAndView deleteRank(ModelAndView model, HttpServletRequest request) throws IOException {

		int rankId = Integer.parseInt(request.getParameter("id"));
		rankService.deleteRank(rankId);
		model.setViewName("redirect:/RankList");
		return model;
	}

}
