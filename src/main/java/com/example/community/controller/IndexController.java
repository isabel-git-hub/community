package com.example.community.controller;

import com.example.community.com.Search;
import com.example.community.config.BoardTypeConstants;
import com.example.community.dto.*;
import com.example.community.service.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postService;
    private final ProductService productService;
    private final BoardService boardService;
    private final EventService eventService;
    private final NoticeService noticeService;

    @GetMapping({"/", "/index"})
    public String indexPage(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("greeting", "안녕하세요, " + loggedInUser + "님");
        }

        // 상품 목록 데이터 추가
        List<FileDto> products = productService.getLatestProducts();
        model.addAttribute("products", products);

        // 출석체크 데이터 추가
        List<BoardDto> boards = boardService.getBoardsByTypeWithPaging(BoardTypeConstants.WELCOME, new Search(1, 5)).getContent();
        model.addAttribute("boards", boards);

//        System.out.println("boards : " + boards);
//        System.out.println("Products Added to Model: " + products); // 디버깅 로그 추가
//        System.out.println("Boards Added to Model: " + boards);

        // 이벤트 데이터 추가
        List<EventDto> events = eventService.getAllEvents();
        model.addAttribute("events", events);

        // 공지사항 데이터 추가
        List<NoticeDto> notices = noticeService.getAllNotices();
        model.addAttribute("notices", notices);

        // 홈 페이지로 이동
        return "index";  // index.html을 반환
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(value = "query", defaultValue = "") String query,
//                         @RequestParam(value = "page", defaultValue = "1") int page,
//                         @RequestParam(value = "size", defaultValue = "10") int size, Model model) {
//        int offset = (page - 1) * size;
//        // 각 서비스에서 키워드 기반 검색 수행
//        List<PostDto> posts = postService.searchPostsByKeyword(query, size, offset);
//        List<FileDto> products = productService.searchProductsByKeyword(query, size, offset);
//        List<EventDto> events = eventService.searchEventsByKeyword(query, size, offset);
//        List<NoticeDto> notices = noticeService.searchNoticesByKeyword(query, size, offset);
//
//        int totalPosts = postService.getTotalPostCountByKeyword(query);
//        int totalProducts = productService.getTotalProductCountByKeyword(query);
//        int totalEvents = eventService.getTotalEventCountByKeyword(query);
//        int totalNotices = noticeService.getTotalNoticeCountByKeyword(query);
//
//        int totalPagesPosts = (int) Math.ceil((double) totalPosts / size);
//        int totalPagesProducts = (int) Math.ceil((double) totalProducts / size);
//        int totalPagesEvents = (int) Math.ceil((double) totalEvents / size);
//        int totalPagesNotices = (int) Math.ceil((double) totalNotices / size);
//
//        // 검색 결과를 모델에 추가
//        model.addAttribute("posts", posts);
//        model.addAttribute("products", products);
//        model.addAttribute("events", events);
//        model.addAttribute("notices", notices);
//        model.addAttribute("query", query);
//        model.addAttribute("page", page);
//        model.addAttribute("size", size);
//        model.addAttribute("totalPagesPosts", totalPagesPosts);
//        model.addAttribute("totalPagesProducts", totalPagesProducts);
//        model.addAttribute("totalPagesEvents", totalPagesEvents);
//        model.addAttribute("totalPagesNotices", totalPagesNotices);


//        return "index";  // 검색 결과 페이지로 이동
//    }
//    @GetMapping("/")
//    public String redirectToIndex() {
//        // 루트 URL로 접근 시 /index로 리다이렉트
//        return "redirect:/index";
//    }
}



//    @GetMapping("/login")
//    public String loginPage(Model model) {
//        model.addAttribute("page", "login");
//        model.addAttribute("title", "로그인");
//        return "login";
//    }

//    @GetMapping("/join")
//    public String joinPage(Model model) {
//        model.addAttribute("page", "join");
//        model.addAttribute("title","회원가입");
//        return "index";
//    }

