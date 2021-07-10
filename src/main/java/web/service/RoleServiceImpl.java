package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;

import java.util.Set;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void save(Role role) {
    }

    @Override
    public void delete(Role role) {

    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role getRoleByName(String rolename) {
        return null;
    }

    @Override
    public Set<Role> getRoleSet() {
        return roleDAO.getRoleSet();
    }

    @Override
    public Set<Role> getRoleSetForUser(String[] rolenames) {
        return roleDAO.getRoleSetForUser(rolenames);
    }
}
