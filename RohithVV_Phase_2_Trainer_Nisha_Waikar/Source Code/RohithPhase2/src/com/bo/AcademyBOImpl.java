package com.bo;

import java.util.List;

import com.dao.AcademyDaoImpl;
import com.dto.Classes;
import com.dto.Student;
import com.dto.Subject;
import com.dto.Teacher;
import com.exep.Bexcep;

public class AcademyBOImpl implements AcademyBO{

	@Override
	public boolean userLogin(String username, String password) throws Bexcep {
		 
		//System.out.println("user "+username+username.isEmpty()+" pwd "+password+password.isEmpty());
		if(!username.isEmpty() && !password.isEmpty()){
			if(username.matches("^[A-Za-z0-9._]+$") && password.matches("^[A-Za-z0-9]+$")) {
				AcademyDaoImpl obj=new AcademyDaoImpl();
				obj.userLogin(username, password);
				return true;
			}
			else {throw new Bexcep("Invalid Credentials");}
			
		}
		else {throw new Bexcep("Username or Password Cannot be Null");}
	}

	@Override
	public List<Subject> listSubject() throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		List<Subject> subjectList=obj.listSubject();
		return subjectList;
	}

	@Override
	public List<Classes> listClasses() throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		List<Classes> classlist=obj.listClasses();
		return classlist;
	}

	@Override
	public List<Teacher> listTeacher() throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		List<Teacher> teacherlist=obj.listTeacher();
		return teacherlist;
	}

	@Override
	public List<Student> listStudents() throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		List<Student> studentlist=obj.listStudents();
		return studentlist;
	}

	@Override
	public boolean deleteSubject(Integer subjectID) throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		return obj.deleteSubject(subjectID);
		
	}

	@Override
	public boolean deleteClass(Integer classID) throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		return obj.deleteClass(classID);
	}

	@Override
	public boolean deleteTeacher(Integer teacherID) throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		return obj.deleteTeacher(teacherID);
		
	}

	@Override
	public boolean deleteStudent(Integer studentID) throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
		return obj.deleteStudent(studentID);
		
	}

	@Override
	public boolean addSubject(Subject subject) throws Bexcep {
		if(subject.getSubName().isEmpty()) {
			throw new Bexcep("Subject Name Cannot be Empty");
		}
		else {
			if(subject.getSubName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.addSubject(subject);
			}
			else {
				throw new Bexcep("Subject Name should only have alphabets and spaces");
			}
			
		}
		
	}

	@Override
	public boolean addClass(Classes cls) throws Bexcep {
		if(cls.getStd()==null || cls.getDiv().isEmpty()) {
			throw new Bexcep("Subject Name or Language Cannot be Empty");
		}
		else {
			if(cls.getStd()>0||cls.getStd()<12) {
				
				if(cls.getDiv().matches("[A-D]{1}")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.addClass(cls);
				
				}
				else {
					throw new Bexcep("only choose a division from A,B,C,D");
				}

			}
			else {
				throw new Bexcep("Standard Should be betweeen 1 and 12");
			}
			
		}
		
	}

	@Override
	public boolean addTeacher(Teacher teacher) throws Bexcep {
		if(teacher.gettName().isEmpty()) {
			throw new Bexcep("Teacher Name Cannot be Empty");
		}
		else {
			if(teacher.gettName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.addTeacher(teacher);
			}
			else {
				throw new Bexcep("Teacher Name should only have alphabets and spaces");
			}
			
		}
		
	}

	@Override
	public boolean addStudent(Student student) throws Bexcep {
		if(student.getStName().isEmpty()) {
			throw new Bexcep("Student Name Cannot be Empty");
		}
		else {
			if(student.getStName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.addStudent(student);
			}
			else {
				throw new Bexcep("Student Name should only have alphabets and spaces");
			}
			
		}
		
	}

	@Override
	public boolean updSubject(Subject subject) throws Bexcep {
		if(subject.getSubName().isEmpty()) {
			throw new Bexcep("Subject Name Cannot be Empty");
		}
		else {
			if(subject.getSubName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.updSubject(subject);
			}
			else {
				throw new Bexcep("Subject Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public boolean updTeacher(Teacher teacher) throws Bexcep {
		if(teacher.gettName().isEmpty()) {
			throw new Bexcep("Teacher Name Cannot be Empty");
		}
		else {
			if(teacher.gettName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.updTeacher(teacher);
			}
			else {
				throw new Bexcep("Teacher Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public boolean updStudent(Student student) throws Bexcep {
		if(student.getStName().isEmpty()) {
			throw new Bexcep("Student Name Cannot be Empty");
		}
		else {
			if(student.getStName().matches("^[A-Za-z\\S]+$")) {
					AcademyDaoImpl obj=new AcademyDaoImpl();
					return obj.updStudent(student);
			}
			else {
				throw new Bexcep("Student Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public List<Object> generateReport(Classes cls) throws Bexcep {
		AcademyDaoImpl obj=new AcademyDaoImpl();
			return obj.generateReport(cls);
	}

}
