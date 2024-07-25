package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sns.comment.bo.CommentBO;
import com.sns.common.FileManagerService;
import com.sns.like.bo.LikeBO;
import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;

	// input: X
	// output: List<PostEntity>
	public List<PostEntity> getPostEntityList() {
		return postRepository.findByOrderByIdDesc();
	}

	// input: 4개의 파라미터
	// output: PostEntity
	public PostEntity addPost(int userId, String userLoginId, String content, MultipartFile file) {

		// 업로드 후 imagePath를 받아옴
		String imagePath = fileManagerService.uploadFile(file, userLoginId);
		
		return postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.content(content)
				.imagePath(imagePath)
				.build());
	}
	
	// input: postId, userId
	// output: X
	@Transactional
	public void deletePostByPostIdUserId(int postId, int userId) {
		// 기존글 조회
		PostEntity post = postRepository.findById(postId).orElse(null);
		if (post == null) {
			log.info("[글 삭제] post is null. postId:{}, userId:{}", postId, userId);
			return;
		}
		
		// DB delete
		// 글 삭제
		postRepository.delete(post);
		
		// 파일 삭제
		fileManagerService.deleteFile(post.getImagePath());
		
		// 댓글 삭제
		commentBO.deleteCommentByPostId(userId);
		
		// 좋아요 삭제
		likeBO.deleteByPostId(postId);
	}

}
