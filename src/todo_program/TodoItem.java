package todo_program;

public class TodoItem {
	
	private String title;
	private int importance;
	
	public TodoItem(String title, int importance) {
		this.title = title;
		this.importance = importance;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getImportance() {
		return this.importance;
	}
}
