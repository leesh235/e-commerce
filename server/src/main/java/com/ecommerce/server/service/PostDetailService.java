package com.ecommerce.server.service;

import com.ecommerce.server.common.security.SecurityUtil;
import com.ecommerce.server.dao.PostDetailDao;
import com.ecommerce.server.dto.PostDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDetailService {

    private final PostDetailDao postDetailDao;

    public PostDetailDto.postResponseDto getPost(PostDetailDto.postRequestDto dto){
        return postDetailDao.findId(dto.getPostId());
    }

    public void writePost(PostDetailDto.writeDto dto){
        PostDetailDto.writeDto post = PostDetailDto.writeDto.builder()
                .category(dto.getCategory())
                .postUrl("fileServer")
                .writer(postDetailDao.findWriter(SecurityUtil.getCurrentMemberId()).getWriter())
                .userId(SecurityUtil.getCurrentMemberId())
                .title(dto.getTitle())
                .build();

       postDetailDao.save(post);
    }

    public void modifyPost(PostDetailDto.modifyDto dto){
        postDetailDao.modify(dto);
    }

    public void deletePost(PostDetailDto.deleteDto dto){
        postDetailDao.delete(dto);
    }

}
