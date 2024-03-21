package com.encore.bbabap.entity;


import com.encore.bbabap.dto.UserDTO;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user")
public class UserEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto_increment
    private Integer user_tbl_id;
    @Column(name = "car_tbl_id")
    private Integer car_tbl_id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_pwd")
    private String userPwd;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_nickname")
    private String userNickName;
    @Column(name = "user_delete_YN")
    private Enum userDeleteYN;
    public static UserEntity userEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        //userEntity.setUser_tbl_id(userDTO.getUser_tbl_id());
        //userEntity.setCar_tbl_id(userDTO.getCar_tbl_id());
        userEntity.setUserId(userDTO.getUser_id());
        userEntity.setUserPwd(userDTO.getUser_pwd());
        userEntity.setUserName(userDTO.getUser_name());
        userEntity.setUserNickName(userDTO.getUser_nickname());
        //userEntity.setUser_delete_YN(userDTO.getUser_delete_YN());
        return userEntity;
    }

}
