package com.matzip.server.domain.user.repository;

import com.matzip.server.domain.user.dto.UserDto;
import com.matzip.server.domain.user.model.User;
import org.springframework.data.domain.Slice;

public interface UserRepositoryCustom {
    User findMeById(Long id);
    Slice<User> searchUsersByUsername(UserDto.SearchRequest searchRequest);
}
