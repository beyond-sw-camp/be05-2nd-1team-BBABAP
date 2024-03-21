package com.encore.bbabap.dto;


import com.encore.bbabap.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {//회원 정보를 필드로 정의
    private Integer user_tbl_id;
    private Integer car_tbl_id;
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_nickname;
    private Enum user_delete_YN;

    public static UserDTO userDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_tbl_id(userEntity.getUser_tbl_id());
        userDTO.setCar_tbl_id(userEntity.getCar_tbl_id());
        userDTO.setUser_id(userEntity.getUserId());
        userDTO.setUser_pwd(userEntity.getUserPwd());
        userDTO.setUser_name(userEntity.getUserName());
        userDTO.setUser_nickname(userEntity.getUserNickName());
        userDTO.setUser_delete_YN(userEntity.getUserDeleteYN());
        return userDTO;
    }
}
