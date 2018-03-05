package com.project.moviebooking.repository;


import com.project.moviebooking.config.mongo.MongoConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoConfig.class})
public class UserRepositoryTest {
    // autowired

    @Autowired
    UserRepository userRepository;

    // test case 1 : testFindById
//    @Test
//    public void testFindById() {
//        List<User> johns = userRepo.findAllByUserName("john");
//        assertTrue(johns.size() == 2);
//        logger.info(johns.toString());
//    }
//    @Test
//    public void testFindAll() {
//        List<User> users = userRepo.findAll();
//        assertTrue(users.size() == 5);
//    }
//    @Test
//    public void testNoFindById() {
//        User user = userRepo.findOne(99L);
//        assertNull(user);
//    }
//    @Test
//    public void testCreate() {
//        User diana = DBInitializer.buildUser("diana.ross@pet.com");
//        diana.setPassword("test");
//        diana = userRepo.save(diana);
//        assertNotNull(diana.getId());
//    }
}
