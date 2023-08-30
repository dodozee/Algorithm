import java.io.*;
import java.text.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String currentTimeStr = br.readLine();
        String startTimeStr = br.readLine();

        // 시간 형식 지정
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        // 문자열을 Date 객체로 변환
        Date currentTime = sdf.parse(currentTimeStr);
        Date startTime = sdf.parse(startTimeStr);

        // 시간 간격 계산
        long timeDifference = startTime.getTime() - currentTime.getTime();
        if (timeDifference < 0) {
            timeDifference += 24 * 60 * 60 * 1000; // 하루의 밀리초 수를 더해주어 음수를 양수로 변환
        }

        // 밀리초를 시간, 분, 초로 변환
        int hours = (int) (timeDifference / (60 * 60 * 1000));
        int minutes = (int) ((timeDifference % (60 * 60 * 1000)) / (60 * 1000));
        int seconds = (int) (((timeDifference % (60 * 60 * 1000)) % (60 * 1000)) / 1000);

        // 결과 출력
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }
}
