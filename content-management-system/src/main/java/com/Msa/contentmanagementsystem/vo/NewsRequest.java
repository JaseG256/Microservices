package com.Msa.contentmanagementsystem.vo;

import com.Msa.contentmanagementsystem.model.Category;
import com.Msa.contentmanagementsystem.model.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

    String title;

    String content;

    Set<Category> categories;

    Set<Tag> tags;
}
