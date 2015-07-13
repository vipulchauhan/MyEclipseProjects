package com.dvdrental.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dvdrental.dto.Actor;
import com.dvdrental.services.ActorService;

@Controller
public class ActorController {

	private static Logger logger = Logger.getLogger(ActorController.class);

	@Autowired()
	private ActorService actorService;

	public ActorService getActorService() {
		logger.info("getActorService");
		return actorService;
	}

	public void setActorService(ActorService actorService) {
		logger.info("setActorService");
		this.actorService = actorService;
	}

	@RequestMapping("/actors")
	public ModelAndView actorMainController() {

		logger.info("actors request received");
		// logger.debug("actors request received");
		// logger.error("actors request received");
		// logger.trace("actors request received");
		// logger.warn("warn");

		return new ModelAndView("actor");
	}

	@RequestMapping("/listActors")
	public ModelAndView listActorController() {
		logger.info("listActors request received");
		List<Actor> actorList = actorService.listActor();
		return new ModelAndView("actorList", "actorlist", actorList);
	}

	@RequestMapping("/addActorsPage")
	public ModelAndView addActorPageController() {
		logger.info("addActorsPage request received");

		return new ModelAndView("addActors", "actor", new Actor());

	}

	@RequestMapping("/editactorPage")
	public ModelAndView editActorPageController(@ModelAttribute Actor actor) {
		logger.info("editActorsPage request received for " + actor);
		actor = actorService.getActor(actor.getId());
		return new ModelAndView("editActorPage", "actor", actor);
	}

	@RequestMapping("/editActor")
	public String editActorController(@ModelAttribute Actor actor) {
		logger.info("editActors request received for " + actor);
		actorService.editActor(actor);
		logger.info("edited actor " + actor);
		return "redirect:/actors.html";
	}

	@RequestMapping("/deleteactor")
	public String deleteActorController(@ModelAttribute Actor actor) {
		logger.info("deleteactor request received for " + actor);
		actorService.deleteActor(actor.getId());
		return "redirect:/actors.html";

	}

	@RequestMapping(value = "/addactor", method = RequestMethod.POST)
	public ModelAndView addActorController(@ModelAttribute Actor actor) {

		logger.info("addActors request received :- " + actor);

		actorService.addActor(actor);
		return new ModelAndView("addActors");

	}
}
