package in.health.model;

public class HealthIssue {

	
	public int getHealth_issue_id() {
		return health_issue_id;
	}

	public void setHealth_issue_id(int health_issue_id) {
		this.health_issue_id = health_issue_id;
	}

	public String getRecording_url() {
		return recording_url;
	}

	public void setRecording_url(String recording_url) {
		this.recording_url = recording_url;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	int health_issue_id;
	String recording_url;
	String mobile;
	String solution;
	int solved;
	
	/**
	 * @param args
	 */
	
	public HealthIssue(	int health_issue_id,String recording_url,String mobile,String solution,int solved){
		
		this.health_issue_id=health_issue_id;
		this.recording_url=recording_url;
		this.mobile=mobile;
		this.solution=solution;
		this.solved=solved;
		
		
	}
	
	public String toString(){
		String s= this.getHealth_issue_id()+","+this.getMobile()+","+this.getRecording_url()+","+this.getSolution()+","+this.getSolved();
		
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
