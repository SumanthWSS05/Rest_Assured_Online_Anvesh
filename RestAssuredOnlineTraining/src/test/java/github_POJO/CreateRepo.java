package github_POJO;

public class CreateRepo {

	private String name;
	private String description;
	private boolean private_ ;
	
	public CreateRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public CreateRepo(String name, String description, boolean private_) {
		super();
		this.name = name;
		this.description = description;
		this.private_ = private_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPrivate_() {
		return private_;
	}

	public void setPrivate_(boolean private_) {
		this.private_ = private_;
	}
}
