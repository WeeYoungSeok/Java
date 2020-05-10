#### class

<다형성>

- 부모타입으로 자식 생성
- 부모의 이름으로 자식대입
- 부모의 메서드를 통해 자식 메서드 호출
- 같은 부모를 갖고 있는 자식클래스는 컴파일 시, 형 변환 가능하지만 런타임시, ClassCastException 발생



상속

- 자식 클래스가 부모 클래스를 선택하여 상속 받는다.
- 부모 클래스의 필드와 메서드를 물려받는다.
- private를 갖는 필드나 메소드는 상속 불가능, 패키지가 다를 경우 defalult도 상속 불가능
- 자식 클래스는 1개의 부모 클래스만 상속 가능하다. (다중 상속 불가능)
- 부모 클래스는 여러개의 자식 클래스에게 상속이 가능하다.
- 장점 : 중복된 코드 감소, 유지보수 편리, 통일성과 다형성





# 추상 클래스

abstract

- 추상클래스

  하나 이상의 추상 메소드를 가진 클래스

  > new 연산자 사용 불가
  >
  > 상속 강요(상속받은 곳에서 반드시 구현해야 함)
  >
  > 상속 강요를 받기 싫으면 상속된 자식클래스도 추상클래스로 만들면 된다.
  >
  > 클래스 내에 abstract method가 한 개 이상 있으면 반드시 abstract class가 되어야 함

```java
public abstract class Animal {
    
    //추상 메소드 : body가 없음
    public abstract void bark();
    
}
```

```java
public class Cat extends Animal {
    
    // body가 없는 추상 메소드는 반드시 자식이 구현해야함
    // 자동 override가 됨
    @Override
    public void bark(){
        System.out.println("야옹");
    }
}
```



Singleton패턴 class

- 메모리(heap area)에 객체를 한번만 생성
- ex) 스마트폰의 달력

```java
public class Singleton { 
    private static Singleton singleton;
    
    // new 사용 못하게 함
    private Singleton() {
        System.out.println("Singleton instance 생성");
    }
    
    // 객체 생성 메서드
    // 객체 생성시 Singleton singleton = Singleton.getInstance();
    public static Singleton getInstance() {
        if(singleton == null) {
            System.out.println("new!!");
            singleton = new Singleton();
        }
        return singleton;
    }
}
```



interface

- 추상클래스

  > 모든 메소드가 추상 메소드
  >
  > 변수는 자동으로 상수화 됨
  >
  > private, protected 사용 불가능
  >
  > 실제 기능은 구현하지 않고, 정의(선언)만 함 (body가 없음)
  >
  > interface를 사용할 클래스에서 implements를 해주어야 하고, 해당 interface에 있는 메소드는 클래스에서 재정의 해주어야 한다.
  >
  > 다중 상속 가능

```java
public interface Animal {
    
    // 변수는 자동 상수화
    String KIND = "동물";
    
    
    // 모든 메소드가 추상 메소드 (body가 없음)
    public void bark();
    void eat(String feed);
}
```

```java
public class Cat implements Animal {
    
    public Cat() {
        // 기본 생성자
        System.out.println("고양이는 " + KIND + "입니다.");   
    }
    
    
    // 자식이 interface의 메소드를 구현해주어야함
    @Override
	public void bark() {
		System.out.println("야옹");
	}

	@Override
	public void eat(String feed) {
		System.out.println("고양이가 " + feed + " 먹는다.");
	}
}
```

