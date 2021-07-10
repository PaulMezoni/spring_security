package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserDAO userDAO;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public void save(User user, String[] roles) {
        user.setRoles(roleService.getRoleSetForUser(roles));
        userDAO.save(user);
    }

    @Override
    public void update(User user, String[] roles) {
        user.setRoles(roleService.getRoleSetForUser(roles));
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    //UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getUserByName(username);
    }
}
