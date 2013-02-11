package in.health.model;

public class Opinion {
	int opinion_id;
	public int getOpinion_id() {
		return opinion_id;
	}
	public void setOpinion_id(int opinion_id) {
		this.opinion_id = opinion_id;
	}
	public int getHealth_issue_id() {
		return health_issue_id;
	}
	public void setHealth_issue_id(int health_issue_id) {
		this.health_issue_id = health_issue_id;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	int health_issue_id;
	String opinion;
	String doctor_id;
	
	public Opinion(int opinion_id, int health_issue_id, String opinion, String doctor_id){
		this.opinion=opinion;
		this.opinion_id=opinion_id;
		this.health_issue_id=health_issue_id;
		this.doctor_id=doctor_id;
		
	}

}
