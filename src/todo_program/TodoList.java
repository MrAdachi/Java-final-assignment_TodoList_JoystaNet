package todo_program;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	
	List<TodoItem> todoItems;
	
	public TodoList() {
		this.todoItems = new ArrayList<TodoItem>();
	}
	
	public void AddItem(String title, int importance, boolean progress) {
		TodoItem todoItem = new TodoItem(title, importance, progress);
		this.todoItems.add(todoItem);
	}
	
	public void ItemChange(int index, String title, int importance, boolean progress) {
		TodoItem changeTodoItem = todoItems.get(index);
		changeTodoItem.setTitle(title);
		changeTodoItem.setImportance(importance);
		changeTodoItem.setProgress(progress);
	}
	
	public void DeleteItem(int index) {
		this.todoItems.remove(index);
	}
	
	public void getTodoList() {
		
		int sortTodoItemSize = this.todoItems.size();
		int indexNum = 0;
		
		/* 既存todoitemの並び替え＆todoitemsへの追加
		 * 拡張for文を使用するとConcurrentModificationException(オブジェクトの並行変更例外)が発生するので、
		 * わざとfor文で処理を実施しています。
		 */
		for(int i = 10; i >= 0; i--) {
			for(int todoItemNum = 0; todoItemNum < sortTodoItemSize; todoItemNum++) {
				if(this.todoItems.get(todoItemNum).getImportance() == i) {
					TodoItem sortTodoItem = new TodoItem(todoItems.get(todoItemNum).getTitle(),todoItems.get(todoItemNum).getImportance(),todoItems.get(todoItemNum).getProgress());
					this.todoItems.add(sortTodoItem);
				}
			}
		}
		
		// todoitemsからsort前のtodoitemを削除
		for(int deleteIndex = sortTodoItemSize - 1; deleteIndex >= 0; deleteIndex--) {
			this.todoItems.remove(deleteIndex);
		}
		
		// sort後のtodoltemsの表示
		for(TodoItem todoItem: this.todoItems) {
			
			if(todoItem.getProgress() == true) {
				System.out.println(indexNum + "…" + todoItem.getTitle() + "/ 重要度：" + todoItem.getImportance() + "/ 進捗：完了");
			} else {
				System.out.println(indexNum + "…" + todoItem.getTitle() + "/ 重要度：" + todoItem.getImportance() + "/ 進捗：未完了");
			}
			indexNum++;
		}
	}
}
