package kz.middle.taskservice.service.impl;

import kz.middle.taskservice.dto.UserDto;
import kz.middle.taskservice.feign.UserFeignClient;
import kz.middle.taskservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserFeignClient userFeignClient;

    @Override
    public List<UserDto> getUsers() {
        return userFeignClient.getUsers();
    }
}
