package pl.atest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.atest.entity.Teacher;
import pl.atest.repository.TeacherRepository;

public class TeacherConverter implements Converter<String, Teacher> {
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Override
	public Teacher convert(String source) {
		return teacherRepo.findById(Long.parseLong(source));
	}
}