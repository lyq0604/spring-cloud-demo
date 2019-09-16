package com.blade.system.service;

import com.blade.common.domain.JWT;
import com.blade.system.common.dtos.UserLoginDTO;
import com.blade.system.common.enums.UserResponseEnum;
import com.blade.system.common.exceptions.CustomUserException;
import com.blade.system.common.utils.ContextUtil;
import com.blade.system.entity.User;
import com.blade.system.feignClients.AuthClient;
import com.blade.system.feignClients.BlogClient;
import com.blade.system.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

/**
 * @author lyq
 * @create 6/21/19
 */
@Service
public class UserService {

    @Value("${security.oauth2.client.id}")
    private String client_id;

    @Value("${security.oauth2.client.client-secret}")
    private String client_secret;

    @Value("${security.oauth2.client.grant-type}")
    private String grant_type;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BlogClient blogClient;
    @Autowired
    private AuthClient authClient;
    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取用户列表
     *
     * @return
     */
    public List<User> selectList() {
        return userMapper.selectAll();
    }

    /**
     * 新增用户
     *
     * @param user
     */
    public void createUser(User user) {
        userMapper.insert(user);
    }

    /**
     * 根据主键删除
     *
     * @param id
     */
    public void deleteById(String id) {
        userMapper.deleteByPrimaryKey(id);
        blogClient.deleteBlogByKey("2");
    }

    /**
     * 根据主键更新用户
     *
     * @param user
     */
    public void updateById(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 根据主键获取用户实体
     *
     * @param id
     * @return
     */
    public User selectByKey(String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomUserException(UserResponseEnum.USER_NOT_FOUND);
        }
        return user;
    }

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    public UserLoginDTO login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        //TODO:数据库存放加密密码，数据库中的密码应与前台传递的密码加密后比较
        User dbUser = userMapper.getUserByUserName(username);
        if (dbUser == null) {
            throw new CustomUserException(UserResponseEnum.USER_NOT_FOUND);
        } else if (!StringUtils.equals(dbUser.getPassword(),password)) {
            throw new CustomUserException(UserResponseEnum.USER_AUTHENTICATION_ERROR);
        }
        JWT token = authClient.getToken(username, password, grant_type, client_id, client_secret);
        return new UserLoginDTO(token,dbUser);
    }
}
