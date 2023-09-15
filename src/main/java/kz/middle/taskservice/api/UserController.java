package kz.middle.taskservice.api;

import kz.middle.taskservice.dto.UserDto;
import kz.middle.taskservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    List<UserDto> getUsers () {
        return userService.getUsers();
    }


}
