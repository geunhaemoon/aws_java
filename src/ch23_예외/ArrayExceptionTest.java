package ch23_예외;

public class ArrayExceptionTest {
	
	public static void main(String[] args) {
		
		Integer[] nums =new Integer[] {10, 20, 30, 40, 50};
		
		for (int i = 0; i < nums.length + 1; i++) {
			//﻿try - 예외가 일어날 수 있는 부분, 예외가 발생시 catch로 넘김
			try {
				System.out.println("index[" + i + "]: "  + nums[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				// 매개변수 , String, Array 로 처리할 경우가 있음
				// RuntimeException 을 상속받아서 밑에처럼 표현 가능함 상속되어있는 순서라 순서 바꾸면 제일 높은곳에서 다 처리해버림 주의 !		
				System.out.println("배열의 크기를 벗어났습니다.");
				// 예외가 발생시 생길 동작을 이곳에 표현
			} catch(NullPointerException e) { 
			} catch(RuntimeException e) {
				System.out.println("나머지 모든 예외 처리");
			} catch (Exception e) {
				System.out.println("최종 예외 처리");
				//파이널은 모든 상황에서 사용 가능
			} finally {
				System.out.println("모든 상황에서 실행됨.");
			}
			
		}//for
		System.out.println("프로그램 정상 종료");
	}//main
}//class
