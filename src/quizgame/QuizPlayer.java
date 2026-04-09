/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizgame;

/**
 *
 * @author Tlpczdqp
 */
public class QuizPlayer extends Player{
    private int answeredQuestion;
    
    // Calls Player(name, 0, 3)  sets name, score=0, hearts=3
    // make this as settings later 
    public QuizPlayer(String name) {
        super (name, 0, 3);
        this.answeredQuestion = 0;
    }
    
    public void addScore(int points) {
        setScore(getScore() + points);
    }
    
    public void loseHp(){
        setHp(getHp() - 1);
    }
    
    public boolean isAlive() {
        return getHp() > 0;
    }
    
    
    public void plusAnsweredQuestion() {
        this.answeredQuestion++;
    }
    
    public int getAnsweredQuestion() {
        return answeredQuestion;
    }
    
    public void setAnsweredQuestion (int answeredQuestion) {
        this.answeredQuestion = answeredQuestion;
    }
    
    public void reset() {
        setScore(0);
        setHp(3);
        setAnsweredQuestion(0);
    }
    
}
