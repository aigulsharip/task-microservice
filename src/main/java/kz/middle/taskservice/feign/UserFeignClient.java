package kz.middle.taskservice.feign;

import kz.middle.taskservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "${user.feign.client.url}")

public interface UserFeignClient {

    @GetMapping (value = "/user")
    List<UserDto> getUsers();

    @GetMapping (value = "/user/{id}")
    UserDto getUser(@PathVariable(name = "id") Long id);
}
