package org.manam.webapp.business;

import org.manam.webapp.dao.domain.UserInfo;
import org.manam.webapp.rest.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoTransformer {

    public List<UserDTO> transform(Iterable<UserInfo> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserInfo userInfo : users) {
            UserDTO transform = transform(userInfo);
            userDTOList.add(transform);
        }
        return userDTOList;
    }

    public UserDTO transform(UserInfo userInfo) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userInfo.getId());
        userDTO.setFirstName(userInfo.getFirstName());
        userDTO.setLastName(userInfo.getLastName());
        userDTO.setMailId(userInfo.getMailId());
        userDTO.setCreatedTime(userInfo.getCreatedTime());
        return userDTO;
    }

    public UserInfo transform(UserDTO userDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userDTO.getId());
        userInfo.setMailId(userDTO.getMailId());
        userInfo.setPassword1(userDTO.getPassword1());
        userInfo.setFirstName(userDTO.getFirstName());
        userInfo.setLastName(userDTO.getLastName());
        userInfo.setCreatedTime(userDTO.getCreatedTime());
        return userInfo;
    }
}
