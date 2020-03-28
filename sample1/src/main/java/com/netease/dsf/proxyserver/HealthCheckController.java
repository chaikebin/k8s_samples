package com.netease.dsf.proxyserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HealthCheckController {

  private static ResponseEntity<Object> successResponse = new ResponseEntity<Object>(HttpStatus.OK);
  private static ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
  private volatile boolean alive = false;

  @RequestMapping("status")
  public ResponseEntity<Object> status() {
    if (alive) {
      return successResponse;
    } else {
      return errorResponse;
    }
  }

  @RequestMapping("online")
  public ResponseEntity<Object> online() {
    alive = true;
    return successResponse;
  }

  @RequestMapping("offline")
  public ResponseEntity<Object> offline() {
    alive = false;
    return successResponse;
  }

  @RequestMapping("check")
  public ResponseEntity<Object> check() {
    return successResponse;
  }


}
