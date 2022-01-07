package com.ecommerce.server.service;

import com.ecommerce.server.common.security.SecurityUtil;
import com.ecommerce.server.dao.PostDetailDao;
import com.ecommerce.server.dto.PostDetailDto;
import com.ecommerce.server.dto.PostOptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDetailService {

    private final PostDetailDao postDetailDao;

    public PostDetailDto.postResponseDto getPost(PostDetailDto.postRequestDto dto){
        PostDetailDto.postResponseDto post = postDetailDao.findId(dto.getPostId());
        List<PostOptionDto.getPostOptionDto> optionList = new ArrayList<>(postDetailDao.findOptionId(dto.getPostId()));

        PostDetailDto.postResponseDto result = PostDetailDto.postResponseDto.builder()
                .amount(post.getAmount())
                .category(post.getCategory())
                .createdDate(post.getCreatedDate())
                .postId(post.getPostId())
                .postUrl(post.getPostUrl())
                .term(post.getTerm())
                .postOptionList(optionList)
                .price(post.getPrice())
                .title(post.getTitle())
                .build();

        return result;
    }

    public boolean writePost(PostDetailDto.writeDto dto){
        PostDetailDto.writeDto post = PostDetailDto.writeDto.builder()
                .category(dto.getCategory())
                .postUrl("fileServer")
                .userId(SecurityUtil.getCurrentMemberId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .amount(dto.getAmount())
                .term(dto.getTerm())
                .build();

        postDetailDao.save(post);

        List<PostOptionDto.createPostOptionDto> optionArr = new ArrayList<>();

        for(int i = 0; i < dto.getPostOptionList().size(); i++){
            PostOptionDto.createPostOptionDto option = PostOptionDto.createPostOptionDto.builder()
                    .postId(post.getPostId())
                    .optionName(dto.getPostOptionList().get(i).getOptionName())
                    .optionPrice(dto.getPostOptionList().get(i).getOptionPrice())
                    .optionAmount(dto.getPostOptionList().get(i).getOptionAmount())
                    .build();
            optionArr.add(option);
        }

        if(postDetailDao.saveOption(optionArr) > 0){
            return true;
        }else{
            return false;
        }

    }

    public void modifyPost(PostDetailDto.modifyDto dto){
        postDetailDao.modify(dto);
    }

    public void deletePost(PostDetailDto.deleteDto dto){
        postDetailDao.delete(dto);
    }

}
