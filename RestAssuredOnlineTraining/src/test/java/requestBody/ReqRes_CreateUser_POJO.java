package requestBody;

public class ReqRes_CreateUser_POJO {

	private String name;
	private String job;
	
	public ReqRes_CreateUser_POJO(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	public ReqRes_CreateUser_POJO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}	
}
