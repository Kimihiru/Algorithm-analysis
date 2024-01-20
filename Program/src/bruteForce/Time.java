package bruteForce;
import java.text.SimpleDateFormat;
import java.util.*;
public class Time {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long mills = sc.nextLong();
        Date date = new Date(mills);
        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
        System.out.println(ft.format(date));
		sc.close();
	}

}
