package com.callor.score.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.config.Lines;
import com.callor.score.config.Position;
import com.callor.score.domain.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {

	private List<ScoreVO> scrList;
	private String filename;

	public ScoreServiceImplV1() {
		scrList = new ArrayList<ScoreVO>();
		filename = "src/com/callor/score/data/student.txt";
		this.loadScore();
	}

	// 중복검사
	// 매개변수로 학번을 받고
	// scVO의 getNum의 값이랑 num의 값이 같으면
	// 객체를 반환하고 아니면 null을 보냄
	private ScoreVO containNum(String num) {
		for (ScoreVO scVO : scrList) {
			if (scVO.getNum().equals(num)) {
				return scVO;
			}
		}
		return null;
	}

	@Override
	public boolean inputScore() {

		Scanner scan = new Scanner(System.in);

		System.out.print("학번 (END : ) : ");
		String strNum = scan.nextLine();

		if (strNum.equals("END")) {
			return false;
		}

		// strNum을 containNum에 보내서 검사를 시키고
		ScoreVO sVO = containNum(strNum); // 조회는 containNum 너가해! 조회된 값은 나한테 알려줘
		boolean bool = false;
		// 만약 sVO가 null이 아니면
		if (sVO != null) {
			// 학생정보를 수정하기.
			bool = true;
			System.out.println("이미 있는 학생정보입니다. 수정해주세요 :)");
			// 값이 있으면 객체를 생성(초기화)해서 값을 저장.
		} else {
			sVO = new ScoreVO();
		}

		// 3항연산자로 표현해보기
		// 하지만 효율은 좋지 않음
		// 위 코드가 더 낫다.
		// ScoreVO sVO = (containNum(strNum)) != null) ? containNum(strNum) : new
		// ScoreVO() ;
		// if(sVO != null ) System.out.println("이미 있는 학생정보입니다. 수정해주세요 :)");

		sVO.setNum(strNum);

		// 국어
		System.out.print("국어 (END : ) : ");
		String strKor = scan.nextLine();

		if (strKor.equals("END")) {
			return false;
		}

		int intKor = 0;
		try {
			intKor = Integer.valueOf(strKor);
		} catch (Exception e) {
			System.out.println("점수는 숫자만 가능 :( " + " 다시 입력해주세요 :)");
			return true;
		}

		sVO.setKor(intKor);

		// 영어
		System.out.print("영어 (END : ) : ");
		String strEng = scan.nextLine();

		if (strEng.equals("END")) {
			return false;
		}

		int intEng = 0;
		try {
			intEng = Integer.valueOf(strEng);
		} catch (Exception e) {
			System.out.println("점수는 숫자만 가능 :( " + " 다시 입력해주세요 :)");
			return false;
		}

		sVO.setEng(intEng);

		// 수학
		System.out.print("수학 (END : ) : ");
		String strMath = scan.nextLine();

		if (strMath.equals("END")) {
			return false;
		}

		int intMath = 0;
		try {
			intMath = Integer.valueOf(strMath);
		} catch (Exception e) {
			System.out.println("점수는 숫자만 가능 :( " + " 다시 입력해주세요 :)");
			return true;
		}

		sVO.setMath(intMath);
		
		if(!bool) scrList.add(sVO);
		
		return true;
	} // >>>> inputScore method 종료

	@Override
	public void calcSum() {

		int sum = 0;
		for (ScoreVO sVO : scrList) {
			sum = sVO.getKor();
			sum += sVO.getEng();
			sum += sVO.getMath();

			sVO.setSum(sum);
		}
	}

	@Override
	public void calcAvg() {

		float avg = 0f;
		int sub = 3;
		for (ScoreVO sVO : scrList) {
			avg = (float) sVO.getSum() / sub;

			sVO.setAvg(avg);
		}

	}

	@Override
	public void scoreList() {

		System.out.println(Lines.dLine);
		System.out.println("성적일람표");
		System.out.println(Lines.dLine);
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균");
		System.out.println(Lines.sLine);

		for (ScoreVO sVO : scrList) {

			System.out.print(sVO.getNum() + "\t");
			System.out.print(sVO.getKor() + "\t");
			System.out.print(sVO.getEng() + "\t");
			System.out.print(sVO.getMath() + "\t");
			System.out.print(sVO.getSum() + "\t");
			System.out.printf("%.2f\n",sVO.getAvg());
		}
		System.out.println(Lines.dLine);
	}

	@Override
	public void scoreSave() {

		PrintStream pStream = null;

		try {

			pStream = new PrintStream(filename);

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어서 새로 생성합니다.");
		}

		for (ScoreVO sVO : scrList) {
			pStream.printf("%s:", sVO.getNum());
			pStream.printf("%d:", sVO.getKor());
			pStream.printf("%d:", sVO.getEng());
			pStream.printf("%d:", sVO.getMath());
			pStream.printf("%d:", sVO.getSum());
			pStream.printf("%.2f\n", sVO.getAvg());
		}

		pStream.close();

	} // >>> save method 종료 :)

	public void loadScore() {

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {

			fileReader = new FileReader(this.filename);
			buffer = new BufferedReader(fileReader);

			String reader = "";

			while (true) {
				reader = buffer.readLine();

				if (reader == null) {
					break;
				}

				String[] scores = reader.split(":");

				ScoreVO scVO = new ScoreVO();

				scVO.setNum(scores[Position.SC_NUM]);
				scVO.setKor(Integer.valueOf(scores[Position.KOR]));
				scVO.setEng(Integer.valueOf(scores[Position.ENG]));
				scVO.setMath(Integer.valueOf(scores[Position.MATH]));
				scVO.setSum(Integer.valueOf(scores[Position.SUM]));
				scVO.setAvg(Float.valueOf(scores[Position.AVG]));

				scrList.add(scVO);
			}

			buffer.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다!");
		}
	}

}
