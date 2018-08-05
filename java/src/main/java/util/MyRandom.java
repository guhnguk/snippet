package util;

import java.util.Random;

public class MyRandom {
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			int nextInt = new Random().nextInt(5);
			System.out.println(nextInt);
		}
		
		
		Random oRandom = new Random();

    // 1~10까지의 정수를 랜덤하게 출력
    int i = oRandom.nextInt(10) + 1;
    System.out.println(i);

    // 0.0f 에서 1.0f 까지의 실수를 랜덤하게 출력
    // 3.7670135E-5 라는 값이 나올 수도 있는데 이것은
    // 0.000037670135 입니다.
    float f = oRandom.nextFloat();
    System.out.println(f);

    // true(참), false(거짓) 중의 하나를 랜덤하게 출력
    Boolean b = oRandom.nextBoolean();
    System.out.println(b);
	}
}
