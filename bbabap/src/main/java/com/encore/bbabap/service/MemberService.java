package com.encore.bbabap.service;

import com.encore.bbabap.dto.UserDTO;
import com.encore.bbabap.entity.UserEntity;
import com.encore.bbabap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    //생성자 주입
    private final UserRepository userRepository;
    //
    public void save(UserDTO userDTO){//repository의 메서드 호출
        UserEntity userEntity = UserEntity.userEntity(userDTO);
        //Repository의 save메서드 호출(조건 entity의 객체를 넘겨줘야함.)
        userRepository.save(userEntity);
    }
    //
    public UserDTO login(UserDTO userDTO){
        Optional<UserEntity> byUserId = userRepository.findByUserId(userDTO.getUser_id());
        if(byUserId.isPresent()){
            //조회 결과가 있다면
            UserEntity userEntity = byUserId.get();//Optional에서 꺼냄
            if(userEntity.getUserPwd().equals(userDTO.getUser_pwd())){
                //비밀번호 일치
                //entity를 DTO로 변환 후 리턴
                UserDTO dto = UserDTO.userDTO(userEntity);
                return dto;
            }else{
                //비밀번호 불일치
                return null;
            }
        }else{
            //아이디 조회 결과가 없다
            return null;
        }
    }

}
