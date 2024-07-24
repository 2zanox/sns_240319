package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.comment.bo.CommentBO;
import com.sns.post.bo.PostBO;
import com.sns.timeline.bo.TimelineBO;
import com.sns.timeline.domain.CardView;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private TimelineBO timelineBO;
	
	/**
	 * 타임라인 화면 view
	 * @param model
	 * @return
	 */
	// http://localhost:8080/timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model, HttpSession session) {
		
		// session 가져오기
		Integer userId = (Integer)session.getAttribute("userId");
		
		// DB 조회
//		List<PostEntity> postList = postBO.getPostEntityList();
//		List<Comment> commentList = commentBO.getCommentList();
		List<CardView> cardViewList = timelineBO.generateCardViewList(userId); // 위에있는 데이터들을 CardView로 담아서 출력
		
		// model
//		model.addAttribute("postList", postList);
//		model.addAttribute("commentList", commentList);
		model.addAttribute("cardViewList" ,cardViewList);
				
		return "timeline/timeline";
	}
	
}
