package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class MemberController {

    private final MemberService memberService;

//    @Autowired //생성자 하나일 경우 생략 가능
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
