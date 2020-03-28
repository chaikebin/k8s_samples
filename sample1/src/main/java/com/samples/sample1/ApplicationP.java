package com.samples.sample1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApplicationP {

  private List<byte[]> oom = new ArrayList<>();

  public static void main(String[] args) {
    SpringApplication.run(ApplicationP.class, args);
  }

  @RequestMapping(value="/oom")
  public void oom(){
    List<byte[]> l = new LinkedList<>();
    while (true) {
      l.add(new byte[1024*1024]);
      System.out.println("free memory="+Runtime.getRuntime().freeMemory());
    }
  }
}
