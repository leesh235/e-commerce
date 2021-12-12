package com.ecommerce.server.controller;

import com.ecommerce.server.dto.PostDetailDto;
import com.ecommerce.server.service.PostDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostDetailController {

    private final PostDetailService postDetailService;

    @GetMapping("/detail")
    public ResponseEntity<?> detail(@RequestParam("postId") PostDetailDto.postRequestDto dto){
        return ResponseEntity.ok().body(postDetailService.getPost(dto));
    }

    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody PostDetailDto.writeDto dto){
        postDetailService.writePost(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody PostDetailDto.modifyDto dto){
        postDetailService.modifyPost(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody PostDetailDto.deleteDto dto){
        postDetailService.deletePost(dto);
        return ResponseEntity.ok().build();
    }

}
