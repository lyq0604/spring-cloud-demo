package com.blade.system.service;

import com.blade.common.base.BaseService;
import com.blade.common.domain.JWT;
import com.blade.common.utils.TreeUtil;
import com.blade.system.common.enums.UserResponseEnum;
import com.blade.system.common.exceptions.CustomUserException;
import com.blade.system.common.utils.ContextUtil;
import com.blade.system.entity.Menu;
import com.blade.system.entity.Permission;
import com.blade.system.entity.Role;
import com.blade.system.entity.User;
import com.blade.system.feignClients.AuthClient;
import com.blade.system.feignClients.BlogClient;
import com.blade.system.mapper.UserMapper;
// import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.blade.system.mapper.UserRoleMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.blade.system.common.vo.UserInfoVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyq
 * @create 6/21/19
 */
@Service
public class UserService extends BaseService<UserMapper,User>{

    @Value("${security.oauth2.client.id}")
    private String client_id;

    @Value("${security.oauth2.client.client-secret}")
    private String client_secret;

    @Value("${security.oauth2.client.grant-type}")
    private String grant_type;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private AuthClient authClient;
    @Autowired
    private BlogClient blogClient;

    /**
     * 用户登录获取token
     * @param user
     * @return
     */
    public String login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        //TODO:数据库存放加密密码，数据库中的密码应与前台传递的密码加密后比较
        User dbUser = mapper.getUserByUserName(username);
        if (dbUser == null) {
            throw new CustomUserException(UserResponseEnum.USER_NOT_FOUND);
        } else if (!StringUtils.equals(dbUser.getPassword(),password)) {
            throw new CustomUserException(UserResponseEnum.USER_AUTHENTICATION_ERROR);
        }
        JWT token = authClient.getToken(username, password, grant_type, client_id, client_secret);
        return token.getAccess_token();
    }

    @Transactional(rollbackFor = Exception.class)
    // @LcnTransaction
    public void test() {
        // 本地事务
        User user = new User();
        user.setName("txTest");
        user.setPassword("txTest");
        user.setUsername("txTest");
        mapper.insert(user);
        // 远程调用事务
        blogClient.insertTestBlog();
    }

    public UserInfoVO getUserInfo() {
        String userId = ContextUtil.getCurrentUserId();
        UserInfoVO vo = new UserInfoVO();
        //用户信息
        User user = mapper.selectByPrimaryKey(userId);
        vo.setName(user.getName());
        //角色信息
        List<Role> roleList = userRoleMapper.getRolesByUserId(userId);
        List<String> roles = roleList.stream().map(Role::getRoleCode).distinct().collect(Collectors.toList());
        vo.setRoles(roles);
        //权限信息
        List<Permission> permissionList = mapper.getPermissionsByUserId(userId);
        List<String> permissions = permissionList.stream().map(Permission::getPermissionCode).distinct().collect(Collectors.toList());
        vo.setPermissions(permissions);
        //菜单信息
        List<Menu> menuList = mapper.getMenuByUserId(userId);
        List<Menu> menus = TreeUtil.build(menuList, "-1");
        vo.setMenus(menus);
        return vo;
    }
}
