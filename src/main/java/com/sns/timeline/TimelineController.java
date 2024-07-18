package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	/**
	 * 타임라인 화면 view
	 * @param model
	 * @return
	 */
	// http://localhost:8080/timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView(
			@RequestParam("postId") int postId,
			Model model, HttpSession session) {
		
		// DB 조회
		List<PostEntity> postList = postBO.getPostEntityList();
//		List<PostEntity> post = postBO.getPostByPostId(postId);
		
		// model
		model.addAttribute("postList", postList);
		
		return "timeline/timeline";
	}
	
}
