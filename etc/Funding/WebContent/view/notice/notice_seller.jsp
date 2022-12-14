<%@page import="kr.or.funding.notice.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("boardList");
	int cnt = noticeList.size();
 
	//한 페이지에 출력될 글 수 
	int pageSize = 10;
	
	// 현 페이지 정보 설정
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	// 첫행번호를 계산
	int currentPage = Integer.parseInt(pageNum);	
	int startRow = (currentPage-1)*pageSize + 1;
 	int endRow = startRow + (pageSize -1);
	
 %>
 <%if(cnt != 0){ 
		////////////////////////////////////////////////////////////////
		// 페이징 처리
		// 전체 페이지수 계산
		int pageCount = cnt / pageSize + (cnt%pageSize==0?0:1);
		
		// 한 페이지에 보여줄 페이지 블럭
		int pageBlock = 10;
		
		// 한 페이지에 보여줄 페이지 블럭 시작번호 계산
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		
		// 한 페이지에 보여줄 페이지 블럭 끝 번호 계산
		int endPage = startPage + pageBlock-1;
		if(endPage > pageCount){
			endPage = pageCount;
		}	
	%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>funding</title>
    <link rel="stylesheet" href="../view/notice/css/reset.css">
    <link rel="stylesheet" href="../view/notice/css/common.css">
    <!-- common.css : header, footer 메인 페이지 -->
    <link rel="stylesheet" href="../view/notice/css/visual.css">
    <!-- visual.css : header 바로 밑 이미지 슬라이드 파트 -->
    <link rel="stylesheet" href="../view/notice/css/contents.css">
    <!-- header와 footer를 제외한 콘텐츠 메인 페이지 -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script defer src="../view/notice/js/common.js"></script>
    <script defer src="../view/notice/js/contents.js"></script>
    <script defer src="../view/notice/js/visual.js"></script>
    <link rel="shortcut icon" href="./img/favicon.png">
    <link rel="icon" href="./img/favicon.png">
    <link rel="stylesheet" href="../view/notice/css/admin_common.css">
    <link rel="stylesheet" href="../view/notice/css/admin_page_order_manage.css">
    <script src="../view/notice/js/admin_common.js"></script>
    <script src="../view/notice/js/admin_order_manage.js"></script>
    
    <style type="text/css">
    	table.notice_style{
			border-radius : 16px;
  			text-align: left;
  			line-height: 1.5;  	
  			font-family: 맑은고딕;
    	}
    	table.notice_style thead th{
    		font-size: x-large;
	   		padding: 10px;
			 font-weight: bold;
			 vertical-align: middle;
			 color: black;
			 border-bottom: 3px solid #036;
    	}
    	
    	table.notice_style tbody tr{
    		  font-size: large;
    		  width: 100px;
  			  padding: 10px;
			  font-weight: bold;
			  vertical-align: middle;
			  border-bottom: 1px solid #ccc;
			  background: #f3f6f7;
    	
    	}
    	
    	#pagenum{
    		font-size: medium;
    		font-family: 맑은고딕;
    		
    		
    	}

        
    </style>
</head>

<body>
    <div id="wrap">
        <div id="header">
            <div class="user_menu">

                <ul class="sign_menu">
                    <!--login class 추가-->
                    <li class="link">
                        <a href="../accounts/join.html" class="item after join">회원가입</a>
                    </li>
                    <li class="link">
                        <a href="../accounts/login.html" class="item after login_none">로그인</a>
                        <a class="item login login_check grade_comm">
                            <span class="ico_grade grade0">일반</span>
                            <span class="txt">
                                <span class="name"></span>
                                <span class="sir">님</span>
                            </span>
                        </a>
                        <ul class="sub">
                            <li class="list">
                                <a href="#" class="list_item">주문 내역</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">배송지 관리</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">개인 정보 수정</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">로그아웃</a>
                            </li>
                        </ul>
                    </li>
                    <li class="link">

                        <!-- 고객센터 hover 시 sub_menu 등장 -->
                        <ul class="sub_menu">
                            <li class="list">
                                <a href="#" class="list_item">공지사항</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">자주하는 질문</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">1:1 문의</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">상품 제안</a>
                            </li>
                            <li class="list">
                                <a href="#" class="list_item">에코포장 피드백</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- .sign_menu -->
            </div>
            <div class="header_logo">
                <h1 class="logo">
                    <a href="#" class="link_main">
                        <span class="gnb_logo_container"></span>
                        <img src="../img/logo.jpg" alt="로고" class="logo_img"
                            onclick="location.href='../main/main.html'">
                    </a>
                </h1>
            </div>
            <div class="gnb">
                <!-- gnb = global nav bar = 최상위 메뉴  -->
                <h2 class="blind">메뉴</h2>
                <ul class="gnb_menu">
                    <li class="list gnb_main">
                        <a href="#" class="link">
                            <span class="ico"></span>
                            <!-- ico는 css에서 bg url로 처리 -->
                            <span class="txt">전체 카테고리</span>
                        </a>
                        <div class="gnb_sub">
                            <ul class="menu">
                                <li class="current">
                                    <!-- hover나 active시 current가 옮겨가도록 설정해야 함 -->
                                    <a href="#" class="main_item">
                                        <span class="ico">
                                            <img src="https://img-cf.kurly.com/shop/data/category/icon_newyear_inactive_pc@2x.1609722514.png"
                                                alt="" class="ico off">
                                            <img src="https://img-cf.kurly.com/shop/data/category/icon_newyear_active_pc@2x.1609722514.png"
                                                alt="" class="ico on">
                                            <!--카테고리 별 아이콘은 직관적이게 img src로 바로 삽입 
                                                클릭X(off): 기본, 클릭(on): 보라색 아이콘-->
                                        </span>
                                        <span class="tit">
                                            <span class="txt">블라블라블라</span>


                                            <span class="ico_new" alt="new"></span>
                                            <!-- ico_nex: bg url로 처리 -->
                                        </span>
                                        <!-- tit: text + ico -->
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="list">
                        <a href="#" class="link">
                            <span class="txt">펀딩</span>
                        </a>
                    </li>
                    <li class="list">
                        <a href="#" class="link">
                            <span class="txt">공지사항</span>
                        </a>
                    </li>
                    <li class="list">
                        <a href="#" class="link">
                            <span class="txt">회사소개</span>
                        </a>
                    </li>
                    <div class="gnb_search">
                        <form action="">
                            <input type="text" id="keyword" value="건강 기원 새해맞이 보양식 레시피" title="검색어입력" class="inp_search">
                            <input type="image" src="https://res.kurly.com/pc/service/common/1908/ico_search_x2.png"
                                class="btn_search">
                            <div class="init">
                                <button type="button" id="search_init" class="btn_delete">검색어 삭제하기</button>
                            </div>
                        </form>
                    </div>

                </ul>
            </div>
        </div>

        <!-- 공지사항 넣기 -->
        <div id="main">
            <div id="content">
                <div class="page_aticle aticle_type2" style="boarder: 1px solid black">
                    <div id="snb" class="snb_my">
                        <h2 class="tit_snb">판매자 메뉴</h2>
                        <div class="inner_snb">
                            <ul class="list_menu">
                                <li>
                                    <a href="notice_seller.html">공지사항</a>
                                </li>
                                <li>
                                    <a href="faq.html">자주묻는질문</a>
                                </li>
                                <li>
                                    <a href="one_iq.html">1:1문의</a>
                                </li>
                               

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
        <div style="position: absolute; height:700px; width:750px; top:200px;left:35%">
            
            	<h2>공지사항 목록</h2><br>
            <table class="notice_style" style="width:100%;height: 200px">
            	<thead>
            	<tr>
            		<th>번호</th>
            		<th>제목</th>
            		<th>작성일</th>
            	</tr>
            	</thead>
            	<tbody>
            	<% for(int i = startRow; i<=endRow;i++){ 
            	if(noticeList.get(i).getNtClf() == 0){%>
            	<tr>
            		<td><%=i%></td>
            		<td><%=noticeList.get(i).getNtTit()%></td>
            		<td><%=noticeList.get(i).getNtWriteDt() %></td>
            	</tr>
            	
            	<%}};%>
            	</tbody>
            </table> <br>
              
    
	<% if(startPage>pageBlock){ %>
		<a id="pagenum" href="list.do?pageNum=<%=startPage-pageBlock%>">&nbsp;Prev</a>
	<%} %>
    
	<% for(int i=startPage;i<=endPage;i++){ %>
		<a id="pagenum" href="list.do?pageNum=<%=i%>"><%=i %>&nbsp;</a>
	<%} %>
    
	<% if(endPage<pageCount){ %>
		<a id="pagenum" href="list.do?pageNum=<%=startPage+pageBlock%>">&nbsp;Next</a>
	<%} %>
	<%} %>
        </div>
    

    <div id="footer">
        <div class="inner_footer">
            <div class="cc_footer">
                <!-- cc = company calls -->
                <h2 class="cc_tit">고객행복센터</h2>
                <div class="cc_view cc_call">
                    <h3>
                        <span class="tit">1644-1107</span>
                    </h3>
                    <dl class="list">
                        <dt>365고객센터</dt>
                        <dd>오전 7시 - 오후 7시</dd>
                    </dl>
                </div>
                <div class="cc_view cc_kakao">
                    <h3>
                        <a href="#" class="tit">카카오톡 문의</a>
                    </h3>
                    <dl class="list">
                        <dt>365고객센터</dt>
                        <dd>오전 7시 - 오후 7시</dd>
                    </dl>
                </div>
                <div class="cc_view cc_qna">
                    <h3>
                        <a href="#" class="tit">1:1 문의</a>
                    </h3>
                    <dl class="list">
                        <dt>24시간 접수 가능</dt>
                        <dd>고객센터 운영시간에 순차적으로 답변해드리겠습니다.</dd>
                    </dl>
                </div>
            </div>

            <div class="company_info">
                <ul class="list">
                    <li>
                        <a href="#" class="link">펀딩소개</a>
                    </li>
                    <li>
                        <a href="#" class="link">펀딩소개영상</a>
                    </li>
                    <li>
                        <a href="#" class="link">인재채용</a>
                    </li>
                    <li>
                        <a href="#" class="link">이용약관</a>
                    </li>
                    <li>
                        <a href="#" class="link">개인정보처리방침</a>
                    </li>
                    <li>
                        <a href="#" class="link">이용안내</a>
                    </li>
                </ul>
                <div class="spec_info">
                    법인명 (상호) : 주식회사 컬리
                    <span class="bar">I</span>
                    사업자등록번호 : 000-00-0000
                    <a href="#" class="link">사업자정보확인</a><br>
                    통신판매업 : 제 2018-서울강남-00000 호
                    <span class="bar">I</span>
                    개인정보보호책임자 : 000 <br>
                    주소 : 서울시 도산대로 16길 20, 이래빌딩 B1 ~ 4F
                    <span class="bar">I</span>
                    대표이사 : 000 <br>
                    입점문의 : <a href="#" class="link">입점문의하기</a>
                    제휴문의 : <a href="#" class="link">ghkdvnfld345@naver.com</a><br>
                    채용문의 : <a href="#" class="link">ghkdvnfld345@naver.com</a><br>
                    팩스 : 000 - 0000 - 0000
                    <span class="bar">I</span>
                    이메일 : <a href="#" class="link">ghkdvnfld345@naver.com</a><br>
                    <br>
                    <strong class="copy">© KURLY CORP. ALL RIGHTS RESERVED</strong>
                    <ul class="sns">
                        <li>
                            <a href="#" class="link_sns insta" target="_blank">
                                <img src="https://res.kurly.com/pc/ico/1810/ico_instagram.png" alt="마켓컬리 인스타그램 바로가기">
                            </a>
                            <!-- bg url 넣기 -->
                        </li>
                        <li>
                            <a href="#" class="link_sns fb" target="_blank">
                                <img src="https://res.kurly.com/pc/ico/1810/ico_fb.png" alt="마켓컬리 페이스북 바로가기">
                            </a>
                        </li>
                        <li>
                            <a href="#" class="link_sns naver_blog" target="_blank">
                                <img src="https://res.kurly.com/pc/ico/1810/ico_blog.png" alt="마켓컬리 네이버블로그 바로가기">
                            </a>
                        </li>
                        <li>
                            <a href="#" class="link_sns naver_post" target="_blank">
                                <img src="https://res.kurly.com/pc/ico/1810/ico_naverpost.png" alt="마켓컬리 포스트 바로가기">
                            </a>
                        </li>
                        <li>
                            <a href="#" class="link_sns yt" target="_blank">
                                <img src="https://res.kurly.com/pc/ico/1810/ico_youtube.png" alt="마켓컬리 유튜브 바로가기">
                            </a>

                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="link_footer">
            <div class="authentication">
                <a href="#" class="mark" target="_blank">
                    <img src="https://res.kurly.com/pc/ico/2001/logo_isms.png" alt="isms 로고" class="logo">
                    <p class="txt">
                        [인증범위] 마켓컬리 쇼핑몰 서비스 개발 · 운영<br>
                        [유효기간] 2019.04.01 ~ 2022.03.31
                    </p>
                </a>
                <a href="#" class="mark" target="_blank">
                    <img src="https://res.kurly.com/pc/ico/2001/logo_eprivacyplus.png" alt="eprivacy plus 로고"
                        class="logo">
                    <p class="txt">
                        개인정보보호 우수 웹사이트 ·<br>
                        개인정보처리시스템 인증 (ePRIVACY PLUS)
                    </p>
                </a>
                <a href="#" class="lguplus mark" target="_blank">
                    <img src="https://res.kurly.com/pc/service/main/2009/logo_payments.png" alt="payments 로고"
                        class="logo">
                    <p class="txt">
                        고객님의 안전거래를 위해 현금 등으로 결제 시 저희 쇼핑몰에서 가입한<br>
                        토스 페이먼츠 구매안전(에스크로) 서비스를 이용하실 수 있습니다.
                    </p>
                </a>
            </div>
        </div>
    </div>
    </div>
</body>

</html>