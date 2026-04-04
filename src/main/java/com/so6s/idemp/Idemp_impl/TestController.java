package com.so6s.idemp.Idemp_impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/")
  public String sayHello() {
    return "Hello world";
  }
}