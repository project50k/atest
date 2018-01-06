package pl.atest.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.atest.entity.Subject;
import pl.atest.repository.StudentRepository;
import pl.atest.repository.SubjectRepository;


@Controller
@RequestMapping("subject")
public class SubjectController {
	
	@Autowired
	StudentRepository studentRepo;

	@Autowired
	SubjectRepository subjectRepo;
	
	@GetMapping("/all")
	public String all(Model m) {
		return "subject/list";
	}
	
	
	@GetMapping("/add")
	public String addformGet(Model m) {
		m.addAttribute("subject", new Subject());
		return "subject/addSubject";
	}

	// Add division
	@PostMapping("/add")
	@Transactional
	public String addformPost(@Valid @ModelAttribute Subject subject, 
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "subject/addSubject";
		}
		this.subjectRepo.save(subject);	//save in DB
		return "redirect:/subject/add";
	}
		
	@GetMapping("/{id}/edit")
	public String editGet(@PathVariable long id, Model m) {
		Subject subject = this.subjectRepo.findById(id);
		m.addAttribute("subject", subject);
		return "subject/addSubject";
	}
	
	@PostMapping("/{id}/edit")
	public String editPost(@ModelAttribute Subject subject) {
		this.subjectRepo.save(subject);
		return "redirect:/subject/all";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteGet(@PathVariable long id, Model m) {
		Subject subject = this.subjectRepo.findById(id);
		m.addAttribute("subject", subject);
		m.addAttribute("del", id);
		return "subject/list";
	}
	
	@PostMapping("/{id}/delete")
	public String deletePost(@PathVariable long id) {
		this.subjectRepo.delete(id);
		return "redirect:/subject/all";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -------------------------------------------------- MODEL ATTRIBUTE --------------------------------------------

	@ModelAttribute("allSubjects")
	public List<Subject> allSubjects() {
		return subjectRepo.findAll();
	}
	
	
	
	
}
	
	

