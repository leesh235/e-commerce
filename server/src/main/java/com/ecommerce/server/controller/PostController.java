package com.ecommerce.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    @GetMapping("/allList")
    public ResponseEntity<?> allList(){
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/newList")
    public ResponseEntity<?> newList(){
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/popularList")
    public ResponseEntity<?> popularList(){
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/categoryList")
    public ResponseEntity<?> categoryList(@RequestParam("category") String st){
        return ResponseEntity.ok().body("");
    }

}
