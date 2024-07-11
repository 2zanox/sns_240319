package com.sns.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	
	public List<Map<String, Object>> selectCommentListTest();
	
}
