/*
<< 생성자메쏘드(constructor) >>
	0. 형태
		접근제한자 클래스이름(매개변수1,매개변수2...){
		
		}
	1. 클래스 이름과동일하며 리턴타입을 명시하지않는 메쏘드(???)
	2. 하나의 클래스에는 반드시 하나이상의 생성자메쏘드가 존재하여야한다.
	--> 생성자메쏘드를 하나도정의하지않을경우 컴파일러는 매개변수가하나도없는
	    생성자메쏘드(디폴트 생성자)를 자동으로 추가한다.    
	3. 객체생성시 최초로 단한번 호출되는 메쏘드(???)이다.
	4. 주로 객체멤버필드 초기화의 용도로 사용한다.
	5. 객체를 생성할려면 반드시 생성자메쏘드를 호출하여야한다.
	6. 생성자메쏘드를 여러개 정의할려면 오버로딩해야한다
		
		-형태: 
		 	public class Test{
		 		//생성자의 정의(선언)
		 	    public Test(){
		 	    	
		 	    }
		 	}
		 	
	    -사용: 
	           Test t = new Test(); 
		 	   클래스명 참조변수이름 = new 클래스명();
		 	   new 라는 연산자는 반드시 생성자호출 앞에있어야하며
		 	   이연산자에의해 객체를 생성한다.
*/
public class Constructor {
	private int member1;
	private int member2;
	private String member3;
	
	/*
	 * 객체 생성 후 최초로 단 한 번 호출되는 메서드(???)
	 */
	public Constructor() {
		System.out.println("public Constructor() 기본생성자 호출 " + this);
		/*
		 * 생성자 메서드 안에서는 생성된 객체의 self 참조변수 this 사용 가능
		 */
		
	}
	
	/*
	 * 생성자 오버로딩
	 */
	public Constructor(int member1) {
		System.out.println("public Constructor(int member1) 생성자 호출");
		this.member1 = member1;
	}
	
		
	public Constructor(int member1, int member2, String member3) {
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
	}

	public void print() {
		System.out.println("member1: " + member1);
		System.out.println("member2: " + member2);
		System.out.println("member3: " + member3);
	}


	
	
}
