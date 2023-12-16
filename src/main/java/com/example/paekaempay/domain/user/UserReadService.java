package com.example.paekaempay.domain.user;

import com.example.paekaempay.common.annotation.ReadService;
import com.example.paekaempay.common.exception.CustomApiException;
import com.example.paekaempay.common.exception.ResponseCode;
import com.example.paekaempay.domain.user.dto.UserInformation;
import com.example.paekaempay.domain.user.entity.User;
import com.example.paekaempay.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;

@ReadService
@RequiredArgsConstructor
public class UserReadService {

    private final UserRepository userRepository;

    public UserInformation getUserInfo(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomApiException(ResponseCode.USER_NOT_FOUND));

        return UserInformation.from(user);
    }
}
