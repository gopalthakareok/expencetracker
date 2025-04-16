package com.grownited.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;


@Controller
public class StateController 
{
	@Autowired
	StateRepository repositoryState;
	
	@GetMapping("newstate")
	public String newstate()
	{
		return "NewState";
	}
	
	@PostMapping("savestate")
	public String savestate(StateEntity entityState) 
	{
		repositoryState.save(entityState);
		return "redirect:liststate";
	}
	
	@GetMapping("liststate")
	public String liststate(Model model) 
	{
		List<StateEntity> stateList = repositoryState.findAll();
		model.addAttribute("stateList", stateList);
		return "ListState";
	}
	
	@GetMapping("viewstate")
	public String viewstate(Model model,Integer stateId) 
	{
		Optional<StateEntity> state = repositoryState.findById(stateId);
		model.addAttribute("state", state.get());
		return "ViewState";
	}
	
	@GetMapping("editstate")
	public String editstate(Integer stateId,Model model) 
	{
		Optional<StateEntity>op = repositoryState.findById(stateId);
		if(op.isEmpty()) 
		{
			return "redirect:/liststate";
		}
		else 
		{
			model.addAttribute("state",op.get());
		    return "EditState";
	    }
	}
	
	
	@PostMapping("updatestate")
	public String updatestate(StateEntity stateentity)
	{
		System.out.println(stateentity.getStateId());
		System.out.println(stateentity.getStatename());
		Optional<StateEntity>op = repositoryState.findById(stateentity.getStateId());
		System.out.println(op.isPresent());
		
		if (op.isPresent())
		{
			StateEntity dbState = op.get();
			dbState.setStatename(stateentity.getStatename());
			repositoryState.save(dbState);
			System.out.println(dbState.getStatename());
				
		}
		return "redirect:/liststate";
		
	}
	
	
	@GetMapping("deletestate")
	public String deletestate(@RequestParam Integer stateId) 
	{
		repositoryState.deleteById(stateId);
		return "redirect:liststate";
	}
	
}
