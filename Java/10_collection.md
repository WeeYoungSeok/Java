# Collection

Collection

- 자료(데이터, 객체)를 보다 쉽게 관리하기 위한 클래스
- 여러 타입, 여러 개의 값, 크기(용량)증가

|      | List | Set  |          Map           |
| :--: | :--: | :--: | :--------------------: |
| 순서 |  O   |  X   |           X            |
| 중복 |  O   |  X   | Key : X<br />Value : O |

---

List

- Vector

  > 과거에 사용한 대용량 처리 컬렉션
  >
  > 동기화 처리가 내부에서 자동으로 일어나, 성능은 좋지 않음
  >
  > toString이 내부적으로 overriding 되어 있음
  >
  > 배열처럼 사용가능(성장하는 배열 - 값이 넘치면 지정한만큼 최대 값이 증가)

- ArrayList

  > 검색이 빠르다
  >
  > 순차 접근이 필요할 때, 인덱스가 있어서 유용하다
  >
  > 정보의 추가/삭제는 느리다

- LinkedList

  > 다음 자료의 위치 정보를 가지며, 인덱스는 없다.
  >
  > 많은 정보의 추가/삭제 시 유용하지만, 검색은 느리다
  >
  > 인덱스가 없으므로 iterator를 이용



Set

- HashSet

  > 빠른 접근 속도, 순서는 알 수 없음

- LinkedHashSet

  > 추가된 순서로 접근 가능

- TreeSet

  > 정렬 방법 지정 가능



Map

- HashMap

  > 중복x, 순서x, null허용

- HashTable

  > HashMap보다 느리지만, 동기화 지원, null불가

- TreeMap

  > 정렬된 순서대로 저장되어 검색은 빠르지만, 요소 추가/삭제 시 성능이 좋지 않음

```java
public class A {
    public static void main(String[] args) {
        
        // System.out.print로 출력시 주소값이 안나오는 이유는
        // 내부적으로 toString이 overriding 되어 있기 때문
        List<String> list = new ArrayList<String>();
        list.add("AAA");
        list.add("BBB");
        System.out.println(list);
        
        // 순서가 있기때문에 for문 이용가능
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            
            
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("4");
        set.add("3");
            
            System.out.println(set);
            
            // 순서가 없으므로 향상된 for문(forEach)을 쓰거나
            // iterator 이용
            
            for(String element : set) {
                System.out.print(element + " ");  
            }
            // 보통 iterator는 여러타입을 가진 collection을 이용할 경우
            // 객체를 담아서 출력하기 편하므로 이용함
            
            Iterator<String> iterator = set.iterator();
            
            while(itertor.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
                
        }
        Map<Integer,String> map = new HashMap<Integer,String>();
        // key가 int형태 value가 string 형태
        map.put(111,"one");
        map.put(111,"AAA"); // key 중복시 후에 들어간 value로 덮어 씌운다
        map.put(222,"BBB");
        
        System.out.println(map);
        
        Collection<String> values = map.values(); // 벨류만 가져오기
		System.out.println(values);
		Collection<Integer> keys = map.keySet(); // 키들만 가져오기
		System.out.println(keys);
        
        // Map은 Collection을 상속 받고 있지 않기 때문에
        // iterator 사용 불가능
        // set에 담아서 사용
        Set<Map.Entry<Integer,String>> entry = map.entrySet();
        Iterator<Entry<Integer,String>> ir = entry.iterator();
        
        while(ir.hasNext()) {
            System.out.print(ir.next() + " ");
        }
    }
}
```



collection과 array의 차이점

- generic으로 타입을 관리하고, capacity(가변용량)이라는 차이가 있다.



generic

- 사용자가 특별히 선언하고 싶은 타입을 쓸때 이용한다.
- collection을 사용할때 타입을 정해준다.

```java
public class Emp<T> {
    
    private T empno; // 사용자가 정해주는 타입
    private String ename;
    
    public Emp() {
        // 기본 생성자
    }
    
    public Emp(T empno, String ename) {
        this.empno = empno;
        this.ename = enmae;
    }
}
```

```java
public class A {
    public static void main(String[] args) {
        // 객체 생성
        Emp<String> aCompany = new Emp<String();
        
        Emp<Integer> bCompany = new Emp<Integer>(777,"AAA");
        // T의 타입을 int의 타입으로 재정의 해줌
    }
}
```



정렬

- collection에서 정렬 메소드가 존재한다.

- Comparable<T> (compareTo), Comparator<T> (compare)

```java
public class A implements Comparable<A> {
    
    private int kor;
    
    public void setKor(int kor) {
		this.kor = kor;
	}

	public int getKor() {
		return kor;
	}
    
    public int compareTo(A other) {
        // 내림차순
        // 나 자신과 다른 것을 비교
        if(this.getkor() > other.getKor()) {
            // 나 자신에서 다른 것을 빼서 양수라는 뜻
            return 1;
        } else if(this.getKor() < other.getKor()) {
            // 나 자신에서 다른 것을 뺴서 음수라는 뜻
            return -1;
        } else {
            return 0;
        }
    }
}
```

```java
class A implements Comparator<String> {
    
    public int compare(String o1, String o2) {
        // 다른것과 다른것을 비교
        
        // 비교해줄것이 String 형태이기때문에 int로 형 변환
        int tmp01 = Integer.parseInt(o1);
        int tmp02 = Integer.parseInt(o2);
        
        if(tmp01 > tmp02) {
            return 1; //compareTo와 동일
        } else if(tmp01 < tmp02) {
            return -1;
        }
        return 0;
    }
}
```

