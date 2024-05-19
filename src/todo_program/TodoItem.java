package todo_program;

public class TodoItem {
	
	private String title;
	private int importance;
	private boolean progress;
	
	public TodoItem(String title, int importance, boolean progress) {
		this.title = title;
		this.importance = importance;
		this.progress = progress;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	public void setProgress(boolean progress) {
		this.progress = progress;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getImportance() {
		return this.importance;
	}
	
	public boolean getProgress() {
		return this.progress;
	}
}
