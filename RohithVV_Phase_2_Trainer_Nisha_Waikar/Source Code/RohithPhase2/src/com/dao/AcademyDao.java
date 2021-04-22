package com.dao;

import java.util.List;

import com.dto.Classes;
import com.dto.Student;
import com.dto.Subject;
import com.dto.Teacher;
import com.exep.Bexcep;

public interface AcademyDao {
	public boolean userLogin(String username, String password) throws Bexcep;
	public List<Subject> listSubject() throws Bexcep;
	public List<Classes> listClasses() throws Bexcep;
	public List<Teacher> listTeacher() throws Bexcep;
	public List<Student> listStudents() throws Bexcep;
	public boolean deleteSubject(Integer subjectID) throws Bexcep;
	public boolean deleteClass(Integer classID) throws Bexcep;
	public boolean deleteTeacher(Integer teacherID) throws Bexcep;
	public boolean deleteStudent(Integer studentID) throws Bexcep;
	public boolean addSubject(Subject subject) throws Bexcep;
	public boolean addClass(Classes cls) throws Bexcep;
	public boolean addTeacher(Teacher teacher) throws Bexcep;
	public boolean addStudent(Student student) throws Bexcep;
	public boolean updSubject(Subject subject) throws Bexcep;
	public boolean updTeacher(Teacher teacher) throws Bexcep;
	public boolean updStudent(Student student) throws Bexcep;
	public List<Object> generateReport(Classes cls) throws Bexcep;
}
