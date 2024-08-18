package com.example.community.service;

import com.example.community.dto.FileDto;

import java.util.List;

public interface ProductService {
    List<FileDto> getAllProducts();

    FileDto getProductById(Long id);

    void addProduct(FileDto fileDto);

    void updateProduct(FileDto fileDto);

    List<FileDto> getLatestProducts();

//    List<FileDto> searchProductsByKeyword(String keyword, int size, int offset);
//
//    int getTotalProductCountByKeyword(String keyword);
}
