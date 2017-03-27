package org.manam.webapp.business;

import org.manam.webapp.dao.UserInfoRepository;
import org.manam.webapp.dao.domain.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserInfoRepository userInfoRepository;

    public UserService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Iterable<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }


    public Long createUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo).getId();
    }
}
