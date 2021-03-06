package com.tanhua.server.service;
import com.tanhua.domain.db.User;
import com.tanhua.dubbo.api.UserApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 * 用户管理业务层
 */
@Service //【注意】，这是消费者，不能使用dubbo的
public class UserService {
    @Reference
    private UserApi userApi;

    /**
     * 根据手机号查询用户
     * @param mobile
     * @param password
     * @return
     */
    public ResponseEntity findByMobile(String mobile) {
        User user = userApi.findByMobile(mobile);
        return ResponseEntity.ok(user);
    }

    /**
     * 新增用户
     * @param mobile
     * @return
     */
    public ResponseEntity saveUser(String mobile, String password) {
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        userApi.save(user);
        return ResponseEntity.ok(null);
    }
}