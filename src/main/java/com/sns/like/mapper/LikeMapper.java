package com.sns.like.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
	
	public int selectLikeCountByPostIdUserId(int postId, int userId);
	
}
