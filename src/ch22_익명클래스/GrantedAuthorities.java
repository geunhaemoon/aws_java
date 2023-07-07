package ch22_익명클래스;

@FunctionalInterface // 메소드는 하나만 있어야한다
public interface GrantedAuthorities {
	public String getAuthority();

}
