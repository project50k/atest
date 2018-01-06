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

import pl.atest.entity.Student;
import pl.atest.entity.User;
import pl.atest.repository.StudentRepository;
import pl.atest.repository.TeacherRepository;
import pl.atest.repository.UserRepository;


@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	StudentRepository studentRepo;

	@Autowired
	TeacherRepository teacherRepo;
	
	@GetMapping("/all")
	public String all(Model m) {
		return "student/list";
	}
	
	// TEST -------------------------------------------------------------------------------------------------------- \
//	@GetMapping("/allconn")
//	public String allconn(Model m) {
//		return "student/listconn";
//	}
//	
//	@GetMapping("/addget")
//	public String addformGetget(Model m) {
//		Student t1= new Student("stoch", "stoch@stoch.pl", "stoch", "stoch");
//		Student t2= new Student("kubacki", "kubacki@kubacki.pl", "kubacki", "kubacki");
//		Student t3= new Student("malysz", "malysz@malysz.pl", "malysz", "malysz");
//		Student t4= new Student("lewy", "lewy@lewy.pl", "lewy", "lewy");
//		Student t5= new Student("piszczu", "piszczu@piszczu.pl", "piszczu", "piszczu");
//		Student t6= new Student("blaszczu", "blaszczu@blaszczu.pl", "blaszczu", "blaszczu");
//		Student t7= new Student("gortat", "gortat@gortat.pl", "gortat", "gortat");
//		Student t8= new Student("jordan", "jordan@jordan.pl", "jordan", "jordan");
//		this.studentRepo.save(t1);
//		this.studentRepo.save(t2);
//		this.studentRepo.save(t3);
//		this.studentRepo.save(t4);
//		this.studentRepo.save(t5);
//		this.studentRepo.save(t6);
//		this.studentRepo.save(t7);
//		this.studentRepo.save(t8);
//		return "student/listconn";
//	}
	// TEST -------------------------------------------------------------------------------------------------------- /
	
	@GetMapping("/add")
	public String addformGet(Model m) {
		m.addAttribute("student", new Student());
		return "student/addStudent";
	}

	// Add student and user
	@PostMapping("/add")
	@Transactional
	public String addformPost(@Valid @ModelAttribute Student student, 
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "student/addStudent";
		}
		User u = new User(student.getPassword(), student.getEmail(), "ROLE_STUDENT"); 
		this.userRepo.save(u);			//save in DB
		u.setStudent(student);			//set connection between student and user
		this.studentRepo.save(student);	//save in DB
		this.userRepo.save(u);			//save in DB
		return "redirect:/student/add";
}
	
	@GetMapping("/{id}/edit")
	public String editGet(@PathVariable long id, Model m) {
		Student student = this.studentRepo.findById(id);
		m.addAttribute("student", student);
		return "student/addStudent";
	}
	
	@PostMapping("/{id}/edit")
	public String editPost(@ModelAttribute Student student) {
		this.studentRepo.save(student);
		return "redirect:/student/all";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteGet(@PathVariable long id, Model m) {
		Student student = this.studentRepo.findById(id);
		m.addAttribute("student", student);
		m.addAttribute("del", id);
		return "student/list";
	}
	
	@PostMapping("/{id}/delete")
	public String deletePost(@PathVariable long id) {
		this.studentRepo.delete(id);
		return "redirect:/student/all";
	}
	
	// -------------------------------------------------- MODEL ATTRIBUTE --------------------------------------------

	@ModelAttribute("allStudents")
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}
	
	
	
	
}
	
	

