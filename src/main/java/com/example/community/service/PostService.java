package com.example.community.service;

import com.example.community.com.Search;
import com.example.community.dto.PostDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    void createPost(PostDto postDto);

    void updatePost(PostDto postDto);

    void deletePost(Long id);

    void incrementHitCount(Long id);

    Page<PostDto> searchPosts(Search search);

    int getTotalPostCountByKeyword(String keyword);

//    List<PostDto> searchPostsByKeyword(String keyword, int size, int offset);
}
