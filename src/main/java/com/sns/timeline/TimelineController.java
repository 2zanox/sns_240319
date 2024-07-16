package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.post.bo.PostBO;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	// http://localhost:8080/timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		
		// DB 조회
		//List<Post> postList = postBO.;
		
		// model
		
		
		return "timeline/timeline";
	}
	
}
