package kz.middle.taskservice.service;

import kz.middle.taskservice.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers ();
}
