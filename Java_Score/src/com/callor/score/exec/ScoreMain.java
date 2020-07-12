package com.callor.score.exec;

import com.callor.score.service.ScoreService;
import com.callor.score.service.ScoreServiceImplV1;

public class ScoreMain {

	public static void main(String[] args) {
		
		ScoreService sS = new ScoreServiceImplV1();
		
		while(true) {
			if(!sS.inputScore()) {
				break;
			}
		}
		sS.calcSum();
		sS.calcAvg();
		sS.scoreList();
		sS.scoreSave();
		
	}
}
