# String

String

- 문자열을 관리하는 클래스
- 문자형들의 집합
- 캐릭터 형태이지만서도 ""이것으로 관리
- char[] 대신 ""상수를 관리
- 한 번 생성된 문자열은 CRUD(create, read, update, delete) 불가 (immutable)



특징

- 참조타입 중 유일하게 기본타입의 특징을 가지고 있다.
- 값이 변하면 새로운 객체를 생성 (hashcode가 변하는 것을 볼 수 있다.)
- 기본타입처럼 선언시 heap area에 있는 String pool에 값을 저장

```java
public class A {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc"); // string 객체를 String pool말고 생성
        
        System.out.println(a==b); // true 주소값을 비교
        System.out.println(a==c); // false
        System.out.println(a.equals(c)); // true 값을 비교
        
    }
}
```





String Concatenation

- 문자열을 만나면 문자열이 된다. - 정말 중요하다.

```java
public class A {
    public static void main(String[] args) {
        int i = 10;
        String s = "1";
        
        System.out.println(i + a); // 101 출력
        System.out.println(i + "" + 1); // 101출력
    }
}
```



StringBuffer

- mutable한 문자열
- 값을 변경 가능하며, 변경해도 hashcode가 변하지 않는다.

```java
public class A {
    public static void main(String[] args) {
    	StringBuffer s = new StringBuffer("abc");
        s.append("d")
        .append("e")
        .append("f");
        
        // 이 경우에는 hashcode가 변하지 않는다
        // 출력시 abcdef가 나온다 (mutable)
        
        s.replace(0, 3, "F");
        // String 처럼 새롭게 담아주거나 출력문안에 안써줘도 바뀜
        
        s.reverse(); 
        // 거꾸로 출력
    }
}
```



String의 기능

```java
public class A {
	
	private static String str = "The,String,class,represents,character,strings.";
	
	public static void main(String[] args) {
        
        System.out.println(str.substring(4,10));
        // String 출력됨
        
        String[] tmp = str.split(",");
        // tmp를 배열처럼 출력시
        // ,기준으로 짤려서 배열에 담겨짐
        // 0번지 The 이런식
        
        StringTokenizer st = new StringTokenizer(str,",");
        // ,기준으로 배열로 만듬
        while(st.hasMoreElements()){
            // 처음에 커서가 The 앞에 있음 The에서 S로 넘어간뒤
            // 토큰 즉 값이 있었냐 물어보는 것
            
            System.out.println(st.nextToken());
            // 있으면 그 값을 출력해라
        }
    }
}
```



String의 기능은 더 많으니 찾아서 공부하자!