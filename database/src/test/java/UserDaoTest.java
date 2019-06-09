import com.itacademy.stetsko.database.dao.UserDao;
import com.itacademy.stetsko.database.entity.User;
import com.itacademy.stetsko.database.entity.UserPosition;

import javax.jms.Session;
import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDaoTest {

    private UserDao userDao = UserDao.getInstance( );
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void initDb() {
        sessionFactory = new Configuration( ).configure( ).buildSessionFactory( );
        TestDataImporter.getInstance( ).importTestData(sessionFactory);
    }

    @AfterClass
    public static void finish() {
        sessionFactory.close( );
    }


    @Test
    public void testFindAll() {
        try (Session session = sessionFactory.openSession( )) {
            session.beginTransaction( );

            List<User> users = userDao.findAll(session);
            assertThat(users, hasSize(3));

            session.getTransaction( ).commit( );
        }
    }

    @Test
    public void testSave() {
        try (Session session = sessionFactory.openSession( )) {
            session.beginTransaction( );

            User save = getUser("Ivan", "ivan", UserPosition.USER);
            session.save(save);

            User user = userDao.findById(session, save.getId( ));
            assertThat(user.getLogin( ), equalTo("Ivan"));

            session.getTransaction( ).commit( );
        }
    }
}
