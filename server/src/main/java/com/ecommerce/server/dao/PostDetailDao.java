package com.ecommerce.server.dao;

import com.ecommerce.server.dto.PostDetailDto;
import com.ecommerce.server.dto.PostOptionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostDetailDao {

    //작성자 불러오기
    PostDetailDto.writeDto findWriter(long userId);

    //게시글 불러오기
    PostDetailDto.postResponseDto findId(long postId);

    List<PostOptionDto.getPostOptionDto> findOptionId(long postId);

    //게시글 작성
    int save(PostDetailDto.writeDto dto);

    //옵션 작성
    int saveOption(List<PostOptionDto.createPostOptionDto> dto);

    //게시글 수정
    int modify(PostDetailDto.modifyDto dto);

    //게시글 삭제
    int delete(PostDetailDto.deleteDto dto);

}
