package com.example.paekaempay.presentation.api;

import com.example.paekaempay.domain.user.UserReadService;
import com.example.paekaempay.domain.user.dto.UserInformation;
import com.example.paekaempay.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserReadService userReadService;

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserDto.UserInfo> getUserInfo(@PathVariable("userId") Long id) {
        UserInformation user = userReadService.getUserInfo(id);

        return ResponseEntity.ok(UserDto.UserInfo.from(user));
    }
}
