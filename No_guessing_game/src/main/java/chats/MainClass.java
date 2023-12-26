package chats;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

import org.hibernate.annotations.CreationTimestamp;

@Entity
class Chats {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String gNum;
	private String eNum;
	@CreationTimestamp
	private Date date;
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public String getgNum() {
		return gNum;
	}

	public void setgNum(String gNum) {
		this.gNum = gNum;
	}

	public String geteNum() {
		return eNum;
	}

	public void seteNum(String eNum) {
		this.eNum = eNum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

public class MainClass {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("whats");
		EntityManager m = f.createEntityManager();
		EntityTransaction t = m.getTransaction();

		Random r = new Random();
		int arr[] = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = r.nextInt(10);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your name");
		String name = sc.next();

		int score = 0;

		int arr1[] = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("guess the num");
			arr1[i] = sc.nextInt();

			if (arr[i] == arr1[i]) {
				score += 10;
				System.out.println("great keep it up");
			} else {
				System.out.println("oops wrong guess");
			}
		}

		System.out.println("generatred num =>" + Arrays.toString(arr));
		System.out.println("enterd num =>" + Arrays.toString(arr1));
		System.out.println("totl score" + score);

		Chats c = new Chats();

		c.setName(name);
		c.setgNum("generatred num =>" + Arrays.toString(arr));
		c.seteNum("enterd num =>" + Arrays.toString(arr1));
		c.setScore(score);

		t.begin();
		m.persist(c);
		t.commit();

	}

}
