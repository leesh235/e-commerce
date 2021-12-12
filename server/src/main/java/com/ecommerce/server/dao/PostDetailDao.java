package com.ecommerce.server.dao;

import com.ecommerce.server.dto.PostDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostDetailDao {

    //게시글 불러오기
    PostDetailDto.postResponseDto findId(long postId);

    //게시글 작성
    int save(PostDetailDto.writeDto dto);

    //게시글 수정
    int modify(PostDetailDto.modifyDto dto);

    //게시글 삭제
    int delete(PostDetailDto.deleteDto dto);



}
