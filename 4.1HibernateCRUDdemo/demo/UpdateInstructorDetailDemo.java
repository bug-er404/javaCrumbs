package demo;

import model.Course;
import model.Instructor;
import model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructorDetailDemo {
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
            // start a transaction
            session.beginTransaction();

            // Instructor ID check
            int theId =2;
            InstructorDetail tempInstructor =
                    session.get(InstructorDetail.class, theId);

            // create the objects
            System.out.println("Updating instructor detail object...");
            tempInstructor.setHobby("swimming");
            tempInstructor.setYoutubeChannel("youtube/itlize");


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
