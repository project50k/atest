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

import pl.atest.entity.Division;
import pl.atest.entity.Student;
import pl.atest.repository.DivisionRepository;
import pl.atest.repository.StudentRepository;


@Controller
@RequestMapping("division")
public class DivisionController {
	
	@Autowired
	StudentRepository studentRepo;

	@Autowired
	DivisionRepository divisionRepo;
	
	@GetMapping("/all")
	public String all(Model m) {
		return "division/list";
	}
	
	
	@GetMapping("/add")
	public String addformGet(Model m) {
		m.addAttribute("division", new Division());
		return "division/addDivision";
	}

	// Add division
	@PostMapping("/add")
	@Transactional
	public String addformPost(@Valid @ModelAttribute Division division, 
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "division/addDivision";
		}
		this.divisionRepo.save(division);	//save in DB
		return "redirect:/division/add";
	}
	
	
	@GetMapping("/{id}/edit")
	public String editGet(@PathVariable long id, Model m) {
		Division division = this.divisionRepo.findById(id);
		m.addAttribute("division", division);
		return "division/addDivision";
	}
	
	@PostMapping("/{id}/edit")
	public String editPost(@ModelAttribute Division division) {
		this.divisionRepo.save(division);
		return "redirect:/division/all";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteGet(@PathVariable long id, Model m) {
		Division division = this.divisionRepo.findById(id);
		if (division.getStudent()!=null) {
			List<Student> allStudentsInGroup = this.studentRepo.sqlFindAllInGroup(id);
			for (Student s:allStudentsInGroup) {
				s.setDivision(null);
				this.studentRepo.save(s);
			}
		}
		m.addAttribute("division", division);
		m.addAttribute("del", id);
		return "division/list";
	}
	
	@PostMapping("/{id}/delete")
	@Transactional
	public String deletePost(@PathVariable long id) {
		this.divisionRepo.delete(id);
		return "redirect:/division/all";
	}
	
	
	@GetMapping("{id}/addStudentToDivision")
	public String addStudentToDivision(@PathVariable Long id, Model m) {
		List<Student> allStudentsInGroup = this.studentRepo.sqlFindAllInGroup(id);
		m.addAttribute("allStudentsInGroup", allStudentsInGroup);
		
		Student tmpStudent = new Student();
		Division tmpDivison = this.divisionRepo.findById(id);
		m.addAttribute("addToDivision", tmpStudent);
		m.addAttribute("divisionParams", tmpDivison);
		return "division/addStudentToDivision";
	}
	
	@PostMapping("{id}/addStudentToDivision")
	@Transactional
	public String addStudentToDivision(@PathVariable Long id, @ModelAttribute Student tmpStudent) {	
		Student student = this.studentRepo.findById(tmpStudent.getId());
		Division division = this.divisionRepo.findById(id);
		student.setDivision(division);
		this.studentRepo.save(student);
		return "redirect:/division/all";
	}
	
	
	
	// -------------------------------------------------- MODEL ATTRIBUTE --------------------------------------------

	@ModelAttribute("allDivisions")
	public List<Division> allDivisions() {
		return divisionRepo.findAll();
	}
	
	@ModelAttribute("allAvailableStudents")
	public List<Student> allAvailableStudents() {
		return studentRepo.sqlFindAllWithoutDivision();
	}	
	
	
}
	
	

