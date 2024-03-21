package com.example.kakaomaptest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/babap")
public class TestController {

    @GetMapping(value = "/maptest")
    public String mymap(){
        System.out.println("카카오 맵 API 테스트");
        return "address2";
    }

}//class end
