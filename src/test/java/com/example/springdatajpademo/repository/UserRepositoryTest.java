package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.TenantIdentifierResolver;
import com.example.springdatajpademo.entity.User;
import com.example.springdatajpademo.entity.UserAssignment;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Import(TenantIdentifierResolver.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;NON_KEYWORDS=USER",
    "spring.jpa.properties.hibernate.format_sql=true",
    "spring.jpa.properties.hibernate.show_sql=true",
    "logging.level.org.hibernate.type.descriptor.sql=TRACE",
    "logging.level.org.hibernate.internal=trace",
    "logging.level.org.hibernate.engine.transaction.internal=trace",
    "logging.level.com.zaxxer.hikari=trace",
    "logging.level.org.springframework.orm.jpa.JpaTransactionManager=trace",
})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void setup() {
        User user = new User();
        User save = userRepository.save(user);

        UserAssignment ua = new UserAssignment();
        ua.setUser(user);

        save.setRoles(Lists.list(ua));
        userRepository.save(save);
    }

    @Test
    @Transactional
    public void test() {
        List<User> all = userRepository.findAll();
        List<UserAssignment> roles = all.get(0).getRoles();
    }

}
