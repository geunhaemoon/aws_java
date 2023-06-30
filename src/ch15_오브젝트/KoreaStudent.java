package ch15_오브젝트;

import java.util.Objects;

public class KoreaStudent {
	private String studentCode;
	private String name;
	
	
	public KoreaStudent(String studentCode, String name) {
		super();
		this.studentCode = studentCode;
		this.name = name;
	}
	
//	@Override //@어노테이션 (특별한 기능은 없고 재정의했단것을 표시하는 역할)
//	public boolean equals(Object obj) {
//		KoreaStudent koreaStudent = (KoreaStudent)obj;
//		boolean equlsFlag = this.studentCode.equals(koreaStudent.studentCode)
//				&& this.name.equals(koreaStudent.name);
//		return equlsFlag;
//		
//	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, studentCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //클래스 타입이 다르면 false로 바꿔라
			return false;
		KoreaStudent other = (KoreaStudent) obj; //다운캐스팅 , 해야 접근가능
		return Objects.equals(name, other.name) && Objects.equals(studentCode, other.studentCode);
		//		'Objects' 객체를 다루는 도구
	}

	
	
	public String getStudentCode() {
		return studentCode;
	}

	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println("학번: " + studentCode);
		System.out.println("이름: " + name);
		System.out.println("=================");
	}

	@Override
	public String toString() {
				  //변수명처럼생각해도됨
		return "KoreaStudent [studentCode=" + studentCode + ", name=" + name + "]";
	}
	

	
	
	//스트링 오버레이? 
	//위기
//	@Override
//	public String toString() {
//		return super.toString(koreaStudent.toString());
//	}

}
