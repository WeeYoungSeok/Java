# Array

배열

- 같은 타입 여러 개의 값을 효과적으로 관리하기 위한 객체
- 참조타입(mutable)으로 주소값을 가짐
- new 연산자를 사용하지 않아도 사용 가능
- 배열의 인덱스 번호는 항상 0부터 시작!



선언 방법

- 선언; 정의; 초기화;
- 선언 정의 초기화;
- 선언 초기화;

```java
public class A {
    public static void main(String[] args) {
        int[] a;
        a = new int[1];
        a[0] = 1; // 방법 1
        
        int[] arr = new int[5]; // 배열의 크기가 5개, 방법 2번
        arr[0] = 1; // 인덱스는 0번부터
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        
        int[] b = {1,2,3,4}; // 방법 3
        
        int[] c = new int[5] {1,2,3,4,5}; // 방법 2와 유사
        
        //출력
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        // arr.length는 arr배열의 크기, 길이를 말함 즉 5
        
    }
}
```



배열의 복사

- Shallow copy(얕은 카피)

  배열의 주소값을 카피 (복사본 변경 시 원본도 같이 변경됨)

- Deep copy(깊은 카피)

  배열의 인덱스의 값을 카피해서 새로운 객체에 넣어준다. (복사본 변경 시 원본에 영향 없음)

```java
public class A {
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        
        int[] copy = original; // reference 복사 (shallow copy)
        
        copy[1] = 6;
        // 이렇게 되면 original배열과 copy배열 1번지의 값이 둘다 6으로 변함
        // 그리고 항상 ==으로 비교하면 true가 나옴
        // 왜냐하면 주소값은 같기 때문
        
        int[] a = {1,2,3,4};
        int[] b = new int[a.length];
        
        for(int i = 0; i < a.length; i++) {
            a[i] = b[i]; 
        } // 인덱스의 값 복사 (deep copy)
        
        b[1] = 7;
        // 이렇게 되면 b의 배열의 1번지만 7로 변함
        // 주소값 비교시 항상 false
        
        // deep copy 두번째 방법
        int[] c = a.clone();
        //이렇게 해도 == 주소값 비교시 false
        
        	// System.arraycopy(
		//					원본 배열 객체(Object src),
		//					원본 시작 위치(int srcPos),
		//					복사 배열 객체(Object dest),
		//					복사 시작 위치(int destPos),
		//					복사 갯수(int Length)
		//					) 이것도 deep copy의 방법
        
        int[] d = new int[10];
        Arrays.fill(d, 100); // 모든 배열을 100으로 채운다 (그전에는 0으로 가득 참)
        
        System.arraycopy(a, 0, d, 2, 3);
        // a의 배열 0번지부터 3개의 값을 d의 배열 2번지부터 3개를 a의 배열로 바꾼다.
        // 출력은 100,100,1,2,3,100...
        // a부터 d까지 배열의 주소값 전부 다름
    }
```

