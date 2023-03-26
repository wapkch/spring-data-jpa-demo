package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.context.spi.TenantIdentifierResolver;
import com.example.springdatajpademo.entity.Channel;
import com.example.springdatajpademo.entity.ChannelPermission;
import com.example.springdatajpademo.entity.Permission;
import com.example.springdatajpademo.entity.PermissionAssignment;
import com.example.springdatajpademo.entity.Role;
import com.example.springdatajpademo.entity.User;
import com.example.springdatajpademo.entity.UserAssignment;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Import(TenantIdentifierResolver.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
    "server.port=9000",
    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;NON_KEYWORDS=USER",
    "spring.h2.console.enabled=true",
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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ChannelRepository channelRepository;

//    @BeforeAll
//    public void setup() {
//        Channel channelToSave = new Channel();
//        channelToSave.setCode("channel1");
//        Channel channel = channelRepository.save(channelToSave);
//
//        User userToSave = new User();
//        userToSave.setName("john.doe");
//        User user = userRepository.save(userToSave);
//
//        Role roleToSave = new Role();
//        roleToSave.setName("Manager");
//        Role role = roleRepository.save(roleToSave);
//
//        UserAssignment ua = new UserAssignment();
//        ua.setUser(user);
//        ua.setRole(role);
//        user.setRoles(Lists.list(ua));
//        userRepository.save(user);
//
//        Permission permToSave = new Permission();
//        permToSave.setId("users.view");
//        Permission permission = permissionRepository.save(permToSave);
//
//        PermissionAssignment pa = new PermissionAssignment();
//        pa.setRole(role);
//        pa.setPermission(permission);
//        role.setPermissions(Lists.list(pa));
//        roleRepository.save(role);
//    }

    @Test
    public void test() {
        Channel channelToSave = new Channel();
        channelToSave.setCode("channel1");
        Channel channel = channelRepository.save(channelToSave);

        User userToSave = new User();
        userToSave.setName("john.doe");
        User user = userRepository.save(userToSave);

        Role roleToSave = new Role();
        roleToSave.setName("Manager");
        Role role = roleRepository.save(roleToSave);

        UserAssignment ua = new UserAssignment();
        ua.setUser(user);
        ua.setRole(role);
        user.setRoles(Lists.list(ua));
        userRepository.save(user);

        Permission permToSave = new Permission();
        permToSave.setId("users.view");
        Permission permission = permissionRepository.save(permToSave);

        PermissionAssignment pa = new PermissionAssignment();
        pa.setRole(role);
        pa.setPermission(permission);
        role.setPermissions(Lists.list(pa));
        roleRepository.save(role);

        ChannelPermission channelPermission = new ChannelPermission();
        channelPermission.setChannel(channel);
        channelPermission.setPermission(permission);
        channel.setPermissions(Lists.list(channelPermission));
        channelRepository.save(channel);
    }

}
