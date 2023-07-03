package ch19_제네릭;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
					// <> 제네릭이라 함.
public class Response<T> { //형태가 고정이 아닌게 제네릭이다.?
	private int statusCode;
	private T data;
	//		오브젝트를 쓰게되면 캐스팅 과정이 포함되어서 제네릭보다 더 귀찮음
	//		제네릭으로 타입을 잡아 쓰는게 좋다.
	

}
