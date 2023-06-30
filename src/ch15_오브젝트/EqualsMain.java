package ch15_오브젝트;

public class EqualsMain {
	
	public static void main(String[] args) {
		KoreaStudent koreaStudent1 = new KoreaStudent("20230001", "변정민");
		KoreaStudent koreaStudent2 = new KoreaStudent("20230002", "정가영");
		KoreaStudent koreaStudent3 = new KoreaStudent("20230003", "정혜성");
		KoreaStudent koreaStudent4 = new KoreaStudent("20230001", "변정민");
		//자료가 동일한지 다른지 구분하는법 객체의 주소 , 데이터의 값
		
		//메모리 주소 비교
		System.out.println(koreaStudent1 == koreaStudent4);
		//데이터(값) 비교
		System.out.println(koreaStudent1.getStudentCode() == koreaStudent4.getStudentCode()
				&& koreaStudent1.getName() == koreaStudent4.getName());
		
		//오버로딩 기존에 있는 것을 상속받아서 자식클래스에 수정하는것 재정의
		
		//오버라이딩 그대로 들고와서 껍데기는 그대로고 안에만 바꾸는것
		
		
		System.out.println(koreaStudent1.equals(koreaStudent4));
		
	
	}
	
}
