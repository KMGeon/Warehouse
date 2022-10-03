package HighJava.src.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T07EqualsHashCodeTest {
	/*
	 * 해시함수(hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다 해시함수에 의해 얻어지는 값은 해시값
	 * , 해시코드 , 해시체크섬 또는 간단하게 해시라고 한다. hashset,hashmap,hashtable과 같은 객체들을 사용할 경우,객체가
	 * 서로 같은지를 비교하기 위해 equals() 메소드와 hashCode메소드를 호출한다. 그래서 객체가 서로 같은지 여부를 결정하려면 두
	 * 메서드를 재정의 해야 한다. 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	 * 
	 * -equals()메서드와 hashcode()메서드에 관련된 규칠 1.두 객체가 같으면 반드시 같은 해시코드를 가져야 한다. 2.두 객체가
	 * 같으면 equals()호출했을때 true를 반환해야 한다. 즉 . 객체a,b가 같다면 a.equals(b) = b.equals(a)둘다
	 * 참이여야 한다. 3.두 객체의 hashcode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다. 하지만 두 객체가 같으면 반드시
	 * hashcode가 같아야 한다. 4.equals()메소드를 반드시 override하면 반드시 hashcode()도 override해야
	 * 한다. 5, hashcode()는 기본적으로 힙메모리에 있는 각 객체에 대한 메모리 주소 매핑 정보기반으로 한 정수값을 반환한다.
	 * 그러므로, 클래스에hashcode()메서드를 오버라이드 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
	 *
	 */
	public static void main(String[] args) {
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");

		System.out.println("p1과 p2 비교: " + p1.equals(p2));
		System.out.println("p1==p2" + (p1 == p2));
		System.out.println(p1.getId() == p2.getId());
		System.out.println(p1.getName().equals(p2.getName()));

		// ----------------------------------------------------------------
		// 해시코드 충돌
//		System.out.println("해시코드 출력");
//		System.out.println("Aa".hashCode());
//		System.out.println("Bb".hashCode());

		Set<Person> set = new HashSet<Person>();

		set.add(p1);
		set.add(p2);
		System.out.print("p1,p2 등록 후 데이터->");

		Iterator<Person> it = set.iterator();
//		while(it.hasNext()) {
//			Person p = it.next();
//			System.out.println(p.getId()+","+p.getName());
//		}

		for (Person p : set) {
			System.out.print(p.getId() + ":" + p.getName());
		}
		// 한개만 넣은 이유
		// 1.hashcode비교하고 같을 수 있으나 이게 완벽하게 같은게 아니다. (충돌이 가능하기 때문에)
		// 2.그래서 hashcode를 equals를 통하여 완벽하게 같은지 판단.
		// set은 중복이 불가하기 때문에 같은 1,홍길동을 1번만 출력한다.

		System.out.println("add(p3) 성공여부: " + set.add(p3));
		System.out.println("add(p3)등록 후 데이터: ");
		for (Person p : set) {
			System.out.println(p.getId() + ":" + p.getName());
		}

		System.out.println("remove(p2)성공여부 :" + set.remove(p2));
		System.out.print("remove(p2) 후 데이터: ");

		for (Person p : set) {
			System.out.println(p.getId() + ":" + p.getName());
		}
	}

}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return String.format("%s %d", id, name);
//	}
//
//	@Override
//	public int hashCode() {
//		return (name + id).hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		Person p = (Person) obj;
//		return this.getId() == p.getId() && this.getName().equals(p.getName());
//	}

}