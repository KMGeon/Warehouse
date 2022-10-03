package kr.or.ddit.basic;

/*
 문제) 호텔 객실을 관리하는 프로그램을 작성하시오.

 조건1)  호텔 객실을 나타내는 Room클래스는 방번호(int), 방종류, 투숙객이름 필드로 구성되어 있고			     
 방번호와 방종류는 다음과 같다.


 방종류
 - 201~209 : 싱글룸
 - 301~309 : 더블룸
 - 401~409 : 스위트룸

 조건2) 전체 객실 관리는 Map을 이용한다.
 (Map의 key값은 방번호로 하고 value값은 Room의 인스턴스로 한다.)
 생성자에서는 방번호와 방종류를 초기화한다.




 실행예시)

 *********************************************
 호텔문을 열었습니다. 어서오십시요.
 *********************************************


 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	1     <--- 입력

 ----------------------------------------------
 체크인 작업
 ----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
 ----------------------------------------------
 방 번호 입력 >> 101     <--- 입력
 101호 객실은 존재하지 않습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	1     <--- 입력

 ----------------------------------------------
 체크인 작업
 ----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
 ----------------------------------------------
 방 번호 입력 >> 201     <--- 입력
 누구를 체크인 하시겠습니까?
 이름 입력 >> 홍길동
 체크인이 완료되었습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	1     <--- 입력

 ----------------------------------------------
 체크인 작업
 ----------------------------------------------
 * 201~209 : 싱글룸
 * 301~309 : 더블룸
 * 401~409 : 스위트룸
 ----------------------------------------------
 방 번호 입력 >> 201     <--- 입력
 201호 객실은 이미 손님이 있습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	3     <--- 입력

 ----------------------------------------------
 현재 객실 상태
 ----------------------------------------------
 방 번호	 방 종류	 투숙객 이름
 ----------------------------------------------
 201	 싱글룸 	홍길동	
 202	 싱글룸 	  -	
 203	 싱글룸 	  -	
 204	 싱글룸 	  -	
 205	 싱글룸 	  -	
 206	 싱글룸 	  -	
 207	 싱글룸 	  -	
 208	 싱글룸 	  -	
 209	 싱글룸 	  -	
 301	 더블룸 	  -	
 302	 더블룸 	  -	
 303	 더블룸 	  -	
 304	 더블룸 	  -	
 305	 더블룸 	  -	
 306	 더블룸 	  -	
 307	 더블룸 	  -	
 308	 더블룸 	  -	
 309	 더블룸 	  -	
 401	스위트룸	  -	
 402	스위트룸	  -	
 403	스위트룸	  -	
 404	스위트룸	  -	
 405	스위트룸	  -	
 406	스위트룸	  -	
 407	스위트룸	  -	
 408	스위트룸	  -	
 409	스위트룸	  -	
 ----------------------------------------------

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	2    <--- 입력

 ----------------------------------------------
 체크아웃 작업
 ----------------------------------------------
 체크아웃 할 방 번호를 입력하세요.
 방번호 입력 >> 101    <--- 입력
 101호 객실은 존재하지 않습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	2    <--- 입력

 ----------------------------------------------
 체크아웃 작업
 ----------------------------------------------
 체크아웃 할 방 번호를 입력하세요.
 방번호 입력 >> 303    <--- 입력
 303호 객실에는 체크인 한 사람이 없습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	2    <--- 입력

 ----------------------------------------------
 체크아웃 작업
 ----------------------------------------------
 체크아웃 할 방 번호를 입력하세요.
 방번호 입력 >> 201    <--- 입력
 201호 객실의 홍길동님 체크아웃을 완료하였습니다.

 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	3    <--- 입력


 ----------------------------------------------
 현재 객실 상태
 ----------------------------------------------
 방 번호	 방 종류	 투숙객 이름
 ----------------------------------------------
 201	 싱글룸 	  -	
 202	 싱글룸 	  -	
 203	 싱글룸 	  -	
 204	 싱글룸 	  -	
 205	 싱글룸 	  -	
 206	 싱글룸 	  -	
 207	 싱글룸 	  -	
 208	 싱글룸 	  -	
 209	 싱글룸 	  -	
 301	 더블룸 	  -	
 302	 더블룸 	  -	
 303	 더블룸 	  -	
 304	 더블룸 	  -	
 305	 더블룸 	  -	
 306	 더블룸 	  -	
 307	 더블룸 	  -	
 308	 더블룸 	  -	
 309	 더블룸 	  -	
 401	스위트룸	  -	
 402	스위트룸	  -	
 403	스위트룸	  -	
 404	스위트룸	  -	
 405	스위트룸	  -	
 406	스위트룸	  -	
 407	스위트룸	  -	
 408	스위트룸	  -	
 409	스위트룸	  -	
 ----------------------------------------------


 -----------------------------------------------------------
 어떤 업무를 하시겠습니까?
 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료
 -----------------------------------------------------------
 선택>>	4    <--- 입력

 *********************************************
 호텔문을 닫았습니다.
 *********************************************
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DaedeokHotel {
	HashMap<Integer, Room> hotelMap;
	Scanner scan;

	// 생성자
	public DaedeokHotel() {
		hotelMap = new HashMap<>();
		scan = new Scanner(System.in);

		// 객실초기화
		for (int i = 2; i <= 4; i++) {
			String roomType = null;
			switch (i) {
			case 2:
				roomType = "싱글룸";
				break;
			case 3:
				roomType = "더블룸";
				break;
			case 4:
				roomType = "스위트룸";
				break;
			}

			for (int j = 1; j < 9; j++) {
				int roomNum = i * 100 + j; // 객실 번호 만들기
				Room r = new Room(roomNum, roomType); // Room 객체생성
				hotelMap.put(roomNum, r); // Map에 저장하기
			}
		}

	}

	// 시작 메서드
	public void hotelStart() {
		System.out.println();
		System.out.println(" ********************************");
		System.out.println("  호텔문을 열었습니다. 어서오십시요.  ");
		System.out.println(" *********************************");
		System.out.println();

		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // check in
				checkin();
				break;
			case 2: // check out
				checkout();
				break;
			case 3: // 객실상태
				showRoom();
				break;
			case 4: // 업무종료
				System.out.println("*************************");
				System.out.println(" 호텔문을 닫았습니다. ");
				System.out.println("*************************");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");

			}
		}
	}

	// 체크아웃 메서드
	private void checkout() {

		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("              체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");

		int num = scan.nextInt();

		// 입력한 값이 Map의 키값에 없으면 잘못 입력한 방번호이다.
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}

		// 입력받은 객실에 현재 투숙한 사람의 이름을 구해온다.
		String name = hotelMap.get(num).getGuestName();

		// 해당 객실에 투숙객이 없는지 검사
		// if(hotelMap.get(num).getGuestName()==null){}
		if (name == null) {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}

		// 투숙객 이름을 null로 변경해서 체크아웃을 진행한다.
		hotelMap.get(num).setGuestName(null);

		System.out.println(num + "호 객실의 " + name + "님 체크아웃을 완료했습니다.");
	}

	// 객실상태 출력하는 메서드
	private void showRoom() {
		System.out.println();

		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		// List에 넣은 후 정렬하여 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());
		Collections.sort(roomNumList);
		// 방번호를 오름차순으로 정렬

		System.out.println("----------------------------------------------");
		System.out.println("                  현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("  방 번호     방 종류      투숙객 이름");
		System.out.println("----------------------------------------------");
		
		// List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한
		// Room객체를 구해서 출력한다.
		for(int i = 0; i<roomNumList.size(); i++){
			Room r = hotelMap.get(roomNumList.get(i));
			
			String name = "-";
			if(r.getGuestName()!=null){
				name = r.getGuestName();
			}
			System.out.println(r.getRoomNumber() + "\t" + r.getRoomType() + "\t" + name);
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	//체크인 메서드
	private void checkin() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		
		int num = scan.nextInt();
	
		//입력한 값이 Map의 키값에 없으면 잘못 입력한 방번호이다.
		if(!hotelMap.containsKey(num)){
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		//해당 객실에 다른 투숙객이 이미 있는지 검사
		if(hotelMap.get(num).getGuestName() !=null){
			System.out.println(num + "호 객실에는 이미 다른 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력>> ");
		String name = scan.next();
		
		//입력받은 투숙객 이름을 해당 객실의 투숙객 명단에 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		System.out.println(name + "씨가 " + num + "호 객실에 체크인 되었습니다.");
	
	}
	
	// 메뉴 출력 및 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("----------------------------------------");

		int num = scan.nextInt();
		return num;
	}

	public static void main(String[] args) {
		new DaedeokHotel().hotelStart();
	}

}

class Room {
	private int roomNumber; // 방번호
	private String roomType; // 방종류
	private String guestName; // 투숙객 이름

	public Room(){
		super();
	}
	
	public Room(int roomNumber, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

}