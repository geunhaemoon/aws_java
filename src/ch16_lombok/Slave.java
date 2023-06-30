package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
//@NoArgsConstructor 밑에꺼로 포함가능?(?)
@RequiredArgsConstructor // private final, 파이널을 달아줘야 사용가능
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
public class Slave {
	private final String name;
//	@Getter
	private int age;
}
