package com.samples.sample1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("classpath*:/META-INF/spring/app-*.xml")
@RestController
@RequestMapping("/api")
public class ApplicationP {

  private List<byte[]> oom = new ArrayList<>();

  public static void main(String[] args) {
    SpringApplication.run(ApplicationP.class, args);
  }

  @RequestMapping(value = "/testString/string/{string}", method = RequestMethod.GET)
  public String testString(@PathVariable("string") String string) {
    return "ApplicationP:"+string;
  }

  @RequestMapping(value="/oom")
  public String oom(){
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        oom.add(new byte[1024*1024*1024]);
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t.setName("oom");
    t.start();
    return "done";
  }
}
