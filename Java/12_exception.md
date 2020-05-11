# Exception

exception

```java
try{
    // 예외가 발생할 수 있는 명령;
} catch {
    // 예외가 발생했을 때, 실행할 명령;
} finally {
    // 예외와 상관없이 마지막에 무조건 실행하는 명령;
}
```



- 코드에서 발생함 (우리가 고칠 수 있음)

  > checked exception : 컴파일 단계에서 확인된다. 꼭 처리해야함.
  >
  > runtime exception : 실행단계에서 확인 (사용자의 부주의로 발생하는 것이 대부분)
  >
  > error : 기본적으로 jvm에서 발생 (본인이 고칠 수 없음)



```java
public class A {
    // 숫자/숫자 프로그램
    private int inputNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        int n = sc.nextInt();
        return n;
    }
    
    public int calculation() {
        int res = 0;
        
        while(true) {
            try {
                res = inputNum() / inputNum();
                break;
            } catch (InputMismatchException e) {
                // e.printStackTrace(); 예외가 어디서부터 발생했는지 찾아보기
                System.out.println("숫자가 아닌 다른 값은 입력하실 수 없습니다.");
                System.out.println("다시 입력해 주세요....")
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
                System.out.println("다시 입력해 주세요....")
            } finally {
                System.out.println("이용해 주셔서 감사합니다."); // 정상종료
                // 예외발생 유무랑 상관없이 무조건 실행하는 명령
            }
        }
        return res;
    }
}
```

