package kz.middle.taskservice.feign;

import kz.middle.taskservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "http://localhost:8001")

public interface UserFeignClient {

    @GetMapping (value = "/user")
    List<UserDto> getUsers();
}
