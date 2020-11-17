package demo;

import model.Course;
import model.Instructor;
import model.InstructorDetail;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int instructorId = 2;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve instructor based on the id: primary key
            System.out.println("\nGetting instructor with id: " + instructorId);

            Instructor myInstructor = session.get(Instructor.class, instructorId);

            System.out.println("Updating instructor...");
            myInstructor.setFirstName("Michael");
            myInstructor.setLastName("Jordan");


            // update email for all faculty
            System.out.println("Update email for all instructors");

            session.createQuery("update Instructor set email='changeEmail@itlize.com'")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
