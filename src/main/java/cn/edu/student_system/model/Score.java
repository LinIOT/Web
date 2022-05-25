package cn.edu.student_system.model;


public class Score {
    private Integer sid;
    private Integer cid;
    private String time;
    private int  score;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
