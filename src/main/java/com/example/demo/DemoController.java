package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller:
// URL에 따른 요청을 처리하는 메서드를 담아두는
// 클래스임을 나타낸다.
@Controller
public class DemoController {
    // DemoController는 HelloComponent를 사용한다.
    // Composition: 구성
    private HelloComponent component;

    // Spring의 IoC Container는 어떤 Bean 객체가 필요한 시점에
    // 의존성을 주입해준다.
    public DemoController(HelloComponent component) {
        this.component = component;
    }

    // @RequestMapping
    // 어떤 URL 요청에 대하여 실행되는 메서드임을
    // 나타낸다.
    @RequestMapping("home")
    public String home() {
        component.sayHello();
        return "home.html";
    }

    // /profile로 요청이 들어올때
    // profile.html을 응답하고 싶다.
    @RequestMapping("profile")
    public String profile() {
        return "profile.html";
    }

    // /hobbies로 요청이 들어오면
    // hobbies.html을 응답한다.
    @RequestMapping("hobbies")
    public String hobbies() {
        return "hobbies.html";
    }
}
