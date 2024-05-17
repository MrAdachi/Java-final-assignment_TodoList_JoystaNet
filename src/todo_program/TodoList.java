package todo_program;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	
	List<TodoItem> todoitems;
	
	public TodoList() {
		this.todoitems = new ArrayList<TodoItem>();
	}
	
	public void AddItem(String title, int importance) {
		TodoItem todoitem = new TodoItem(title, importance);
		todoitems.add(todoitem);
	}
	
	public void ImportanceChange(int index, int importance) {
		TodoItem changetodoitem = todoitems.get(index);
		changetodoitem.setImportance(importance);
	}
	
	public void DeleteItem(int index) {
		todoitems.remove(index);
	}
	
	public void getTodoList() {

		for(TodoItem todoitem :todoitems) {
			System.out.println(todoitem.getTitle() + "/ 重要度：" + todoitem.getImportance());
		}

	}

}
