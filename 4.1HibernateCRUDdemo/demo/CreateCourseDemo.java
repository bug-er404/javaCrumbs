package demo;

import model.Course;
import model.Instructor;
import model.InstructorDetail;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

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

            // create a course object
            System.out.println("Creating new course object...");
            Course tempCourse = new Course(
                    "Artificial Intelligence");

            // get instructor by primary key / id
            int theId = 2;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);


            // course can only exist with an instructor
            if (tempInstructor != null) {
                //associate instructor with course
                tempCourse.setInstructor(tempInstructor);
                // save the student object
                System.out.println("Saving the course...");
                session.save(tempCourse);
            }
            else
                System.out.println("No eligible instructor found with ID:"+theId);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}
