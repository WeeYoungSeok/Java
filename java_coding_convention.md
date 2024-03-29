## java coding convention

- coding convention이란
  - 프로그래머 사이에서 약속한 코드 작성 양식이다.
    틀리면 프로그래밍 언어에서 컴파일 에러가 나는 문법 오류와 달리, 컨벤션은 지키지 않아도 오류가 나지 않는다.
  - coding convention의 장점
    - 가독성 증진
    - 일관된 코드 스타일 유지
  - IDE에서 제공해주는 경우가 많다. 그래도 알아두는 것이 좋다.



#### 소스파일 기본사항

- 파일 이름
  - java 파일 이름은 포함된 소스의 최상위 클래스의 이름과 .java 확장자로 구성한다.

- ENCODING
  - encoding은 UTF-8이 기본이다.
  
- 공백문자
  - 개행 문자를 제외하고, ASCII 코드 공백문자(0x20)는 소스 파일에서 유일한 공백무자이다. 두가지를 의미한다.
    - String이나 문자 리터럴에서 공백문자는 이스케이프 된다.
    - 탭 문자는 들여쓰기에 사용하지 않는다.
  
- 이스케이프 되는 문자

  - `\b`, `\t`, `\n`, `\f`, `\r`, `\"`, `\'`, `\\` 에 대해선 octal방식( `\012` )이나 유니코드(`\u000a` ) 보단 앞의 방식을 사용한다.

- ASCII 코드 외의 문자

  - 아스키코드가 아닌 문자는 유니코드 캐릭터  ( `∞` )나,  유니코드 이스케이프  ( `\u221e`)가 활용된다.
  - 가장 읽기 좋은 방식으로 선택하는 것이 좋다.
  - Example :

  ```java
  String unitAbbrev = "μs";  - Best
  
  String unitAbbrev = "\u03bcs"; // "μs" - 허락되지만 이렇게 할 이유가 없음
  
  String unitAbbrev = "\u03bcs"; // Greek letter mu, "s" - 허락되지만 이상해보이고, 오해를 살 여지가 있음
  
  String unitAbbrev = "\u03bcs"; - 최악, 이게 뭔지 알 도리가 없음
  ```


<br/>

#### 소스 파일의 구조

- 다음 순서로 구성된다
  - 라이센스 또는 저작권 정보(있을 경우)
  - package 명세
  - import 명세
  - 최상위 클래스 시작 그리고 각 섹션들은 하나의 빈 줄로 구분한다.
  
- 라이센스
  - 있는 경우에 적어주면 된다.
  
- 패키지 문
  - 보통 화면 최상단에 위치한 package문이다. 패키지 문은 개행하지 않고, 다른 내용에 적용되는 열 제한(최대 100자)는 패키지문에는 적용되지 않는다.(최대 길이로 적는다.)
  
- import 문
  - 와일트 카드 (ex. java.util.* 처럼 아스테리스크로 하위 클래스를 다 적용하는 방식)으로는 가져오지 않는다.
    - 이유
      1.  중요한 문제는 아니지만, 성능 이슈가 생길 수도 있다. Wildcard import는 컴파일 할 때 실제 클래스를 찾기 위해 해당 패키지의 클래스를 전부 탐색해서 시간이 더 소요된다. 하지만 파일 몇개를 탐색한다고 차이가 더 날지는 사실 의문이다. 또한 많은 어플리케이션이 사전에 컴파일된 jar나 war를 사용하는 경우가 많으므로 크게 중요하지 않다.
      2.  별고의 두 패키지를 Wildcard import했는데, 두 패키지 모두에 있는 동일한 이름의 클래스를 활요하는 경우이다. 이 때 참조할 클래스를 결정할 수 없으므로 컴파일 할 수 없는 상황이 발생한다. 단순히 클래스를 import했는데 소스코드를 수정해야 하므로 바람직하지 못하다.
  - import문도 패키지문과 마찬가지로 길다고 개행하지 않는다. 열제한(최대 100자) 또한 적용하지 않는다.
  - static import 와 non-static import는 따로 모아서 블록을 만든다. 블록의 순서는 static, non static이다. 블록 사이에는 1줄의 개행을 넣는다. 각 블록 내에서의 정렬 순서는 ASCII 코드 정렬 순서이다.
  
  ❗ 상위 클래스를 import 할 때 포함되므로 스태틱 inner class를 위해 static import하지 않는다.

<br/>

#### Class 정의

- 소스 내에서 최상의 클래스는 단 하나여야 한다.
- 클래스 맴버들간의 순서는 정답이 없지만, 논리적 순서를 갖추는게 중요하다.
- 비슷한 역할을 하는 메소드끼리 뭉쳐놓고, 추상화 단계에서 따라 배치하자.
  - overload된 메소드들은 흩어놓지 않는다.

<br/>

#### 포맷

- 중괄호 { } (brace)
- 괄호는 if, else, for, do 및 while문에 코드가 없거나 단 하나라도 생략하지 않습니다.
  - 한줄 코드는 괄호 생략이 더 깔끔하다고 많이 생각하지만, 가이드에서는 오히려 가독성이 안좋다고 말하고 있다.
- { 의 경우
  - 여는 중괄호 전에는 개행하지 않는다.
  - 여는 중괄호 뒤에서는 개행한다.
- } 의 경우
  - 닫는 괄호 앞에서 개행한다.
  - 닫는 괄호 뒤의 개행은, 중괄호가 끝나거나 생성자, 메소드, 클래스가 끝날 때 개행한다. 그러므로, else나 *,*앞에서는 개행하지 않는다.

```java
return () -> {
  while (condition()) {
    method();
  }
};

return new MyClass() {
  @Override public void method() {
    if (condition()) {
      try {
        something();
      } catch (ProblemException e) {
        recover();
      }
    } else if (otherCondition()) {
      somethingElse();
    } else {
      lastThing();
    }
  }
};
```

#### 비어있는 블록

- 빈 블록은 개행하거나, 개행하지 않거나 상관없다. 하지만 멀티 블록일 경우 개행해주어야한다.

  ```java
  // This is acceptable
    void doNothing() {}
  
    // This is equally acceptable
    void doNothingElse() {
    }
  
  // This is not acceptable: No concise empty blocks in a multi-block statement
    try {
      doSomething();
    } catch (Exception e) {}
  ```


#### 블록의 들여쓰기 (indent)

- 블록 들여쓰기는 2공백이다.
- 즉 새로운 블록이 시작하면 2공백을 추가해서 작성하다가, 블록이 끝나면 들여쓰기를 끝내면된다.
  - 이 공백은 업체마다 개발자마다 조금씩 다르다. 컨벤션을 안지키는 경우가 많다.

#### 한 줄의 하나의 상태

- 각 상태가 끝나면 개행을한다. 상태가 끝나는 것은? *;*을 적은 후다.

#### 열 제한

- 하나의 문장은 최대 100글자로 제한한다.
- 문자는 모든 유니코드 포인트를 의미한다.
- 아래 예외 경우를 제외하고 줄바꿈 규직에 의거해 줄바꿈을 해야한다.
  1. 열 제한을 따를 수 없는 행 (예 : javadoc의 긴 URL 또는 긴 JSNI 메소드 참조)
  2. 패키지 및 임포트 문
  3. 주석에서, 쉘에 붙여 넣을 수 있는 command line 내용

#### 줄바꿈 (line-wrapping)

- 한 줄을 차지할 수 있는 코드를 여러줄로 나누는 것을 줄바꿈이라고 한다.
- 줄 바꿈도 여러 방식이 존재한다.
- 보톤 줄 바꿈을 하는 이유는 열 제한(100자)을 초과하지 않기 위해서지만, 열 제한을 넘지 않아도 가독성을 위해 줄바꿈을 한다.

***메소드나 지역변수를 생성함으로써 줄바꿈 없이 열제한을 해결할 수 있다.***

#### 줄바꿈 규칙

- 줄바꿈의 더 높은 구문 수준 (**higher syntactic level**)에서 끊어주는 것을 원칙으로 한다.
  1. 연산자 가은 상징들 (operatior-like-symbol)들 앞에서 끊어준다. 
     - operator-like-symbol
       - .
       - 람다의 : :
       - <T extemds Foo & Bar>와 같은 타입에서의 &
       - catch(FooException | BarException e) 같은 캐치 블록에서의 |
  2. , 는 앞에 오는 토근의 뒤에 적는다.

#### 줄바꿈 시 들여쓰기

- 줄바꿈을 하고 나면 최초 행보다 최소 4자를 들여쓰기 한다.

#### 빈줄 넣기

- 세로

  1. 멤버 변수, 생성자 메소드, 이너 클랫, 초기화 사이 사이에는 항상 하나의 빈 줄을 넣는다.

     - 예외
       1. 두 개의 연속된 필드 사이에 빈 줄은 옵션이다. 필드 간의 논리적 그룹을 만드는데 활용하면 된다.
       2. 열거형 상수(enum) 사이의 빈 줄은 허용된다.

     ```java
     private enum Answer {
     YES {
       @Override public String toString() {
         return "yes";
       }
     },
     
     NO,
     MAYBE
     }
     ```

  2. if, for, catch와 여는 괄호 ( 사이에 공백
  
  3. else, catch에 앞에 오는 닫는 중과호 } 사이에 공백
  
  4. { 중괄호 앞
  
     - 예외
       1. @SomeAnnotation({a,b})
       2. String[][] x = {{"foo"}} 처럼 {{ 사이에 공백이 필요없다.
     
  5. 이항 연산자 및 삼항 연산자의 앞 뒤, "operator-like" symbol도 마찬가지
  
     - 타입 영역 사이에 & <T extends Foo & Bar>
     - multi catch 사이에 | catch (FooException | BarException e)
     - foreach문 : for (String bar : foo)
     - 람다의 화살표 (String str) -> str.length()
     - 하지만 :: 와 . 은 앞뒤로 공백을 넣지 않는다.
