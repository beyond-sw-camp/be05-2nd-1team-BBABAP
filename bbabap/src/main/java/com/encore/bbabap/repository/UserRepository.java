package com.encore.bbabap.repository;

import com.encore.bbabap.dto.UserDTO;
import com.encore.bbabap.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {//첫번째 인자 : 어떤 Entity인지, 두번째 인자 : pk 어떤 타입인지
    //아이디로 회원 정보 조회(SELECT * FROM user WHERE user_id=?)
    public Optional<UserEntity> findByUserId(String userId);
}
