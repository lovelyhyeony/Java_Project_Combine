package com.callor.score.service;

public interface ScoreService {

	// 성적 입력
	public boolean inputScore();
	
	// 총점 계산
	public void calcSum();
	
	// 평균 계산
	public void calcAvg();
	
	// 성적 일람표 출력
	public void scoreList();
	
	// 성적정보 파일 저장
	public void scoreSave();
}
