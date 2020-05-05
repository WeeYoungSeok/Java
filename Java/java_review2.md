# 총정리 

String

- 문자열을 관리하는 클래스
- 문자형들의 집합
- 캐릭터 형태지만 ""이걸로 묶어줌



char[] 대신 "" 상수를 관리

한 번 생성된 문자열은 CRUD(creat, read, update, delete) 불가 (immutable)



특징

- 참조타입 중 유일하게 기본타입의 특징을 가지고 있다.
- 값이 변하면 새로운 객체를 생성(hash코드가 변하는 것을 볼 수 있다.)

```java
String s = "안녕하세요";

System.out,println(s.hashCode()); // 
s = s + " 저는";
s = s + " 위영석 입니다.";
System.out.println(s.hashCode()); // 위의 hashCode와 동일
System.out.println(s);

s.replace("안녕하세요","하이"); //이때는 immutable 특성때매 변하지 않음 hashCode도 안변함

s=s.replace("안녕하세요","하이");
System.out.println(s); //s로 새롭게 다시 선언을 하여 새롭게 참조를 해야 바뀜
// 이때는 hashCode도 바뀜

```



String Concatenation : 문자열을 만나면 문자열이 된다. - 중요하다

```java
int i = 1;
String s = "101";
System.out.println(s+i); // int형이 String 문자열을 만나서 문자열로 변하여
// 1011이 출력
```



String의 기능

```java
private static String str = "The,String,class,represents,character,strings.";


System.out.println(str.substring(4,10)); // 4번 인덱스부터 10번 인덱스 전까지

String[] tmp = str.split(","); // ,기준으로 잘라서 배열에 담음

for(int i = 0; i < tmp.length; i++){
    System.out.println(i + "번지 : " + tmp[i])
}
    
```

```java
StringBuffer sb = new StringBuffer();
sb.append("저장한거 날라갔다!!!");
System.out.println(sb);
// StringBuffer는 String의 immutable의 성질이 없다
// 변경이 가능하다
// 하지만 값을 변경해도 주소값이 변경되지 않는다.
```

```java
private static String str = "The,String,class,represents,character,strings.";

StringTokenier st = new StringTonkenizer(str,",");
// , 기준으로 나눠준다

while(st.hasMoreElements()){
    // 처음에는 The기준으로 T앞에 커서가 생기고
    // 커서가 String쪽으로 넘어가면서 값이 있냐고 물어보는 것이다.
    System.out.println(st.nextToken()); // 출력
}
```



### Class

OOP(Object Oriented Programming) : 기능별로 객체를 나눈다.



- 추상화 : 여러 객체들을 하나의 추상적인 큰 개념으로 묶는다.
- 캡슐화 : 객체의 기능을 사용만 한다. (코드는 온닉)
- 상속 : 상위 객체를 하위 객체가 물려받는다.
- 다형성 : 같은 형태로 다른 행위를 한다.



##### JAVA는 객체 지향 프로그램이다.



메모리



- 객체를 생성할때 부모객체를 먼저 생성
- 부모의 메소드가 먼저 생성되고 자식의 메소드 생성
- 생성되 주소는 부모의 주소
- 메모리에 공개되어 있는 메소드만 사용 가능(중요)



Java VM 실행시 윈도우가 메모리를 할당 해준다.

###### 3칸으로 나눔

- static area : 클래스와 메소드들
- stack area : 변수또는 연산자
- heap area : 값(객체)



#### <생성자>

- 클래스 이름과 동일하되, 리턴타입은 없고, 객체 생성은 접근자 public

```java
public class AAA{
    public AAA(){
        // super(); (object 기본 생성자 호출)
        // 기본 생성자
    }
}
```



- 생성자는 객체 생성을 하는 new 연산자와 함께 사용되며 생성시 단 한번만 호출된다.

```java
Test t1 = new Test(); // 기본 생성자 호출
```



- 생성자는 메소드처럼 객체 및 클래스명으로 호출할 수 없다.

```java
t1.Test(); // 불가능
```



- overload 할 수 있다.

```java
public class CCC{
    public CCC(){
        
    }
    public CCC(int a){
        
    }
    public CCC(int b, int c){
        
    }
}
```



- 생성자를 명시하지 않으면 기본 생성자가 제공되며 필드를 초기화 하고, 생성자를 명시하면 명시한 생성자만 호축되고 기본 생성자는 제공되지 않는다.(자주 까먹음)

```java
public class AAA{
    // 이 상태에서 AAA aaa = new AAA(); 호출 가능
}
public class BBB{
    public BBB(int a){
        // 이 상태에서 BBB bbb = new BBB(); 호출 불가능
    }
}
```



- 생성자는 상속되지 않는다.
- 생성자는 내부 호출 할 수 있다.(this)
- 생성자의 목적 : 객체 생성, 필드 초기화



#### setter, getter

- setter 메소드의 파라미터를 통해 클래스의 전역변수를 초기화해서 getter 메소드로 리턴 받을 수 있다.
- 실무에서 자주 사용하는 메소드이므로 항상 기억해두자.

```java
private int kor; // instance variable

public void setKor(int kor){
    this.kor=kor; // 전역변수 초기화
}
public int getKor(){
    return kor; // setKor로 초기화 시킨 kor을 getKor() 메소드로 리턴
}
```



#### object의 toStirng

- object 클래스의 toString을 재정의해서 사용한 것이다.
- 객체 생성 이후 System.out.println으로 변수를 출력시 toString의 리턴값을 출력해준다.

```java
public String toString(){
    return "국어 점수 : " + getKor();
}
```



#### 추상 클래스

- Abstrat class : 하나 이상의 추상 메소드를 가진 클래스
- new 연산자 사용 불가 : 객체 생성 불가
- 자식클래스가 반드시 구현되어야 한다. (상속 강요)
- 추상 메소드를 자식클래스에서 반드시 구현해주어야 한다. 그렇지 않을 경우 자식도 추상 클래스가 되어야한다(중요)
- 추상 메소드 : body가 없음
- 상속은 extends로 함
- 다중상속 불가능

```java
 public abstract class Animal { // 추상 클래스
     
     public abstract void bark(); // 추상 메소드
     
     public void eat(String feed) {
         System.out.println(feed + "먹는다.");
     }
 }
```

```java
public class Dog extends Animal{
    
    public void bark(){
        System.out.println("멍멍");
    }
    @Override
    public void eat(String feed) {
        System.out.println("강아지가 " + feed + " 먹는다.");
    }
}
```



#### Singleton 클래스

- 메모리(heap)에 객첼을 한번만 생성
- ex) 스마트폰의 달력
- new 연산자 사용 못하도록 private로 사용 (외부사용 차단)
- getInstance()는 Singleton으로 되어있다고 생각하면 된다.

```java
public class Singleton {
    
    // 객체를 확인할 주소(reference) 선언
    private static Singleton singleton;
    
    // 외부에서 new연산자 사용 못하게 하도록 private
    private Singleton{
        System.out.println("Singleton instance 생성");
    }
    
    // 객체 생성 메서드
    public static Singleton getInstance(){
        if(singleton == null){
            System.out.println("new!!");
            singleton = new Singleton();
        }
        return singleton;
    }
}
```

```java
// singleton 호출
Singleton sigleton = Singleton.getInstance();
```



#### Interface

- 모든 메소드가 추상 메소드
- 변수는 자동으로 상수화
- private, protected 사용 불가능
- 추상 메소드이므로 body가 없음
- 상속은 implements로 함
- 다중상속 가능

```java
public interface Animal {
    
    String KIND = "동물";
    
    public void bark();
    void eat(String feed);
}
```

```java
public class Cat implements Animal {
    
    public Cat(){
        System.out.println("고양이는 " + KIND + "이다.");
        // 여기서 KIND는 static과 final이 동시에 존재
        // interface에서는 변수선언을 하면 자동 static final이 됨
    }
    @Override
    public void bark(){
        System.out.println("야옹");
    }
    @Override
    public void eat(String feed){
        System.out.println("고양이가 " + feed + "먹는다.");
    }
}
```



#### Collection

- Collections에는 Set, List, Map이 있다.
- List는 순서가 있고, 중복도 가능하다.
- Set은 순서가 없고, 중복이 불가능하다.
- Map은 순서가 없고, Key와 Value의 형태를 가진다.



- Collection과 Array의 차이점 : type의 관리와 가변용량의 차이가 있다.



- List에는 ArrayList, Vector, LinkedList가 있다

##### Vector

- 과거에 사용한 대용량 처리 컬렉션
- 동기화 처리가 내부에서 자동으로 일어나, 성능은 좋지 않다.
- toString이 내부적으로 Override 되어 있다.
- 배열처럼 사용가능(성장하는 배열-값이 넘치면 지정한 만큼 최대값이 증가함)

```java
Vector<Integer> vector = new Vector<Integer>(10,5); // <> : Generic
// 10칸짜리의 배열이고 10칸이 넘쳤을 경우 5칸만큼 늘려줌
System.out.println(v.size() + " : " + v.capacity()); // 0:10
// Vector는 Array와 다르게 0으로 값이 채워지지 않고 빈 칸임
// 순서가 있으므로 for문을 통해 인덱스에 값 넣을 수 있음
for(int i = 0; i < 9; i++){
    v.add(i);
}
System.out.println(v); // 원래는 주소값이 나와야되는데 toString이 자동 override 되어 있음
for(int i = 0; vector.size(); i++){
    System.out.print(vector.get(i) + " ");
}// 순서가 있어서 인덱스가 존재하므로 이렇게도 사용 가능
// get의 파라미터는 int index이다.

for(Integer element : vector){
    System.out.print(element + " ");
} // 이렇게도 출력가능 vector의 덩어리들을 element라는 변수에 하나씩 담아주는 것이다.
// forEach문 향상된 for문이다.
// forEach문은 중간에 값이 변경되거나 삭제되면 에러가 발생한다.
// 하나의 값만 변경하고 싶을때는 if문으로 변경한뒤 break로 빠져나오는 방식이 있다.
```



##### ArrayList

- 검색이 빠르다.
- 순차 접근이 필요할 때, 인덱스가 있으므로 유용하다.
- 정보의 추가/삭제는 느리다.

```java
List<String> list = new ArrayList<String>();

for(int i = 0; i <= 10; i++){
    list.add(i + "");
} // 중요한것이 i가 int형인데 String의 특성으로 
// 문자열과 숫자가 더해지면 문자열이 되므로 저런식으로 사용가능
// String.toString으로도 가능하지만 저렇게 간단히도 사용가능
System.out.println(list);

Collections.shuffle(list); // list의 배열의 순서를 마구잡이로 석어줌

Collections.sort(list); // 정렬해줌 근데 이때!!
// 1다음 10이 나옴 그리고 2가나옴
// 이때 1다음 2가 나오게하려면 Compare라는 메소드를 사용해주어야한(정렬메소드)
```



##### LinkedList

- 다음 자료의 위치 정보를 가지며, 인덱스는 없다.
- 많은 정보의 추가/삭제시 유용하지만, 검색이 느리다.
- 인덱스가 없으므로 iterator를 사용하여야 한다.



- Set에는 HashSet, LikedHashSet, TreeSet이 있다.

##### HashSet

- 빠른 접근 속도, 순서를 알 수 없음

```java
Set<String> set = new HashSet<String>();
set.add("1");
set.add("2");
set.add("2");
set.add("4");
set.add("3");

System.out.println(set); // [1, 2, 3, 4] 출력됨 중복 없애주고 꺼내오는건 자기 맘대로

for(String element : set){
    System.out.print(element + " "); // 1 2 3 4 
}
```



##### LinkedHashSet

- 추가된 순서로 접근 가능

##### TreeSet

- 정렬 방법 지정 가능

