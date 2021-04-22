package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import com.dto.Classes;
import com.dto.Student;
import com.dto.Subject;
import com.dto.Teacher;
import com.exep.Bexcep;


public class AcademyDaoImpl implements AcademyDao{
	private SessionFactory factory;
	
	
	public AcademyDaoImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
	}

	@Override
	public boolean userLogin(String username, String password) throws Bexcep {
        try(Session session  = factory.openSession())
        {
        Transaction txn = session.beginTransaction();
		String uname="admin";
		String pw="admin";
		if(uname.equals(username)&&pw.equals(password)) {txn.commit();return true;}
		else {
			throw new Bexcep("Username and Password dont match"); 
		}
        }catch(Exception e)
        {
        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
        }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> listSubject() throws Bexcep {
		   List<Subject> subjectlist = null;
	        try(Session session  = factory.openSession())
	        {
	        Transaction txn = session.beginTransaction();
	        String hql="FROM Subject";
	        TypedQuery<Subject> query = session.createQuery(hql);
	        subjectlist=query.getResultList();
	        txn.commit();
	        session.close();
	        return subjectlist;
	        }catch(Exception e)
	        {
	        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
	        }
	        
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> listClasses() throws Bexcep {
		List<Classes> classlist = null;
        try(Session session  = factory.openSession())
        {
        Transaction txn = session.beginTransaction();
        String hql="FROM Classes";
        TypedQuery<Classes> query= session.createQuery(hql);
        classlist=query.getResultList();
        txn.commit();
        //session.close();
        }catch(Exception e)
        {
        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
        }
        return classlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listTeacher() throws Bexcep {
		List<Teacher> teacherlist = null;
        try(Session session  = factory.openSession())
        {
        Transaction txn = session.beginTransaction();
        String hql="FROM Teacher ";
        TypedQuery<Teacher> query=session.createQuery(hql);
        teacherlist=query.getResultList();
        txn.commit();
        session.close();
        }catch(Exception e)
        {
        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
        }
        return teacherlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() throws Bexcep {
		List<Student> studentlist = null;
        try(Session session  = factory.openSession())
        {
        Transaction txn = session.beginTransaction();
        String hql="FROM Student";
        studentlist = session.createQuery(hql).getResultList();
        txn.commit();
        session.close();
        }catch(Exception e)
        {
        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
        }
        return studentlist;
	}

	@Override
	public boolean deleteSubject(Integer subjectID) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
	       txn = session.beginTransaction();
	        Subject subject= session.get(Subject.class, subjectID);
	        if (subject != null) {
	            session.delete(subject);
	            System.out.println("subject is deleted");
	            txn.commit();
		        session.close();
	            return true;
	        }
	        else {return false;}
	        
	        }catch (Exception e) {
	        	 
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
		
	}

	@Override
	public boolean deleteClass(Integer classID) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        Classes classes= session.get(Classes.class, classID);
	        if (classes != null) {
	            session.delete(classes);
	            System.out.println("class is deleted");
	            txn.commit();
		        session.close();
	            return true;
	        }
	        else {return false;}
	        }catch (Exception e) {
	        	
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
		
	}

	@Override
	public boolean deleteTeacher(Integer teacherID) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        Teacher teacher= session.get(Teacher.class, teacherID);
	        if (teacher != null) {
	            session.delete(teacher);
	            System.out.println("teacher is deleted");
	            txn.commit();
		        session.close();
	            return true;
	        }
	        else {return false;}
	        }catch (Exception e) {
	        	
	        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
		
	}

	@Override
	public boolean deleteStudent(Integer studentID) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
        txn = session.beginTransaction();
        Student student= session.get(Student.class, studentID);
        if (student != null) {
            session.delete(student);
            System.out.println("student is deleted");
            txn.commit();
	        session.close();
            return true;
        }
        else {return false;}
        }catch (Exception e) {
        	
			throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
			}
	}

	@Override
	public boolean addSubject(Subject subject) throws Bexcep {
			Transaction txn=null;
	        try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        
	        session.save(subject);
	        txn.commit();
	        session.close();
	        return true;
	        }catch (Exception e) {
	        	
	            
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
	}

	@Override
	public boolean addClass(Classes cls) throws Bexcep {
			Transaction txn=null;
		   try(Session session = factory.openSession()){
	       txn = session.beginTransaction();
	    
	        session.save(cls);
	        txn.commit();
	        session.close();
	        return true;
	        }catch (Exception e) {
	        
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
	}

	@Override
	public boolean addTeacher(Teacher teacher) throws Bexcep {
		Transaction txn=null;
		   try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        session.save(teacher);
	        txn.commit();
	        session.close();
	        return true;
	        }catch (Exception e) {
	        	
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
	}

	@Override
	public boolean addStudent(Student student) throws Bexcep {
			Transaction txn=null;
		   try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        session.save(student);
	        txn.commit();
	        session.close();
	        return true;
	        }catch (Exception e) {
	        	
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
	}

	@Override
	public boolean updSubject(Subject subject) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
	        txn = session.beginTransaction();
	        session.update(subject);
	        txn.commit();
	        session.close();
	        return true;
		}catch (Exception e) {
			
			throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
			}
		}

	@Override
	public boolean updTeacher(Teacher teacher) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
		        txn = session.beginTransaction();
		        session.update(teacher);
		        txn.commit();
		        session.close();
		        return true;
		      		}catch (Exception e) {
		      			
				throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
				}
			
	}
	@Override
	public boolean updStudent(Student student) throws Bexcep {
		Transaction txn=null;
		try(Session session = factory.openSession()){
	         txn = session.beginTransaction();
	        session.update(student);
	        txn.commit();
	        session.close();
	        return true;
	      		}catch (Exception e) {
	      			
			throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
			}
		}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> generateReport(Classes cls) throws Bexcep {
		
		List<Object> reportlist =new ArrayList<Object>();
		
		Transaction txn=null;
		

        try(Session session  = factory.openSession())
        {
        txn = session.beginTransaction();
        String hql="SELECT stID,StName FROM Student  WHERE classID="+cls.getClassID();
        TypedQuery<?> query= session.createQuery(hql);
        reportlist=(List<Object>) query.getResultList();
        
       
        String hql1="SELECT subID,subName,tID FROM Subject WHERE classID="+cls.getClassID();
        TypedQuery<?> query1=  session.createQuery(hql1);
        reportlist.add(query1.getResultList());
        

       
        String hql2="SELECT tID,tName FROM Teacher t WHERE t.tID IN (SELECT s.tID FROM Subject s WHERE s.classID="+cls.getClassID()+")";
        TypedQuery<?> query2=  session.createQuery(hql2);
        reportlist.add(query2.getResultList());
        
        
        txn.commit();
        session.close();
        return reportlist;
        }catch(Exception e)
        {
        	throw new Bexcep("Internal error occured kindly contact sysadmin with error message "+e);
        }
        
        
	
	}

}
