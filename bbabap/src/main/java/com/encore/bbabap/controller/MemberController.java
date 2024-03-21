package com.encore.bbabap.controller;

import com.encore.bbabap.dto.UserDTO;
import com.encore.bbabap.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    //생성자 주입 @AutoWired생략가능
    private final MemberService memberService;

    //회원가입 페이지 출력
    @GetMapping("/user/signUp")
    public String signUpPage() { return "signUp"; }

    //@ModelAttribute = 사용자가 요청시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션
    @PostMapping("/user/signUp")
    public String saveUserInfo(@ModelAttribute UserDTO userDTO) {
        System.out.println("debug >>> MemberController.save");
        System.out.println("debug >>> UserDTO = " + userDTO);
        memberService.save(userDTO);
        return "index";
    }

    //로그인 페이지 출력(index초기화면)
    @GetMapping("/user/login")
    public String loginPage(){ return "index"; }

    //로그인 메서드
    @PostMapping("/user/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        UserDTO loginResult = memberService.login(userDTO);
        System.out.println(session);
        if(loginResult != null) {//로그인 성공
            session.setAttribute("loginId", loginResult.getUser_id());
            return "main";
        }else{//로그인 실패
            return "index";
        }//if-else end
    }

}//class end