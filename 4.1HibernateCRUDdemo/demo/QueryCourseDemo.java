package demo;

import model.Course;
import model.Instructor;
import model.InstructorDetail;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryCourseDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List<Course> courses = session.createQuery("from Course ").getResultList();

            // display the students
            displayCourses(courses);

            // query students: lastName='wang'
            courses = session.createQuery("from Course course where course.title like 'artificial%'").getResultList();

            // display the students
            System.out.println("\n\nCourse with Artificial in their title");
            displayCourses(courses);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayCourses(List<Course> courses) {
        for (Course tempCourse : courses) {
            System.out.println(tempCourse);
        }
    }

}
