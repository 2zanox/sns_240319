package com.sns.like.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
	
//	public int selectLikeCountByPostIdUserId(
//			@Param("postId") int postId,
//			@Param("userId") int userId);
	
//	public int selectLikeCountByPostId(int postId);
	
	// 위에 있는 두 count 쿼리를 하나로 합친다.
	public int selectLikeCountByPostIdOrUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	public void deleteLikeByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	public void deleteByPostId(int postId);
	
}
