package in.health.model;

public class Feedback {

	/**
	 * @param args
	 */
	int health_issue_id;
	public int getHealth_issue_id() {
		return health_issue_id;
	}

	public void setHealth_issue_id(int health_issue_id) {
		this.health_issue_id = health_issue_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getPatient_mobile_number() {
		return patient_mobile_number;
	}

	public void setPatient_mobile_number(String patient_mobile_number) {
		this.patient_mobile_number = patient_mobile_number;
	}

	
	public Feedback(int health_issue_id, String question, String answer,
			int feedback_id, String patient_mobile_number, String doctor_id) {
		super();
		this.health_issue_id = health_issue_id;
		this.question = question;
		this.answer = answer;
		this.feedback_id = feedback_id;
		this.patient_mobile_number = patient_mobile_number;
		this.doctor_id = doctor_id;
	}
	String question ;
	String answer;
	int feedback_id;
	String patient_mobile_number;
	String doctor_id;
	
	
	
	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
