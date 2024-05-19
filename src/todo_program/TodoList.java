package todo_program;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	
	List<TodoItem> todoitems;
	
	public TodoList() {
		this.todoitems = new ArrayList<TodoItem>();
	}
	
	public void AddItem(String title, int importance, boolean progress) {
		TodoItem todoitem = new TodoItem(title, importance, progress);
		this.todoitems.add(todoitem);
	}
	
	public void ItemChange(int index, String title, int importance, boolean progress) {
		TodoItem changetodoitem = todoitems.get(index);
		changetodoitem.setTitle(title);
		changetodoitem.setImportance(importance);
		changetodoitem.setProgress(progress);
	}
	
	public void DeleteItem(int index) {
		this.todoitems.remove(index);
	}
	
	public void getTodoList() {
		
		int sort_todoitem_size = this.todoitems.size();
		int index_num = 0;
		
		/* 既存todoitemの並び替え＆todoitemsへの追加
		 * 拡張for文を使用するとConcurrentModificationException(オブジェクトの並行変更例外)が発生するので、
		 * わざとfor文で処理を実施しています。
		 */
		for(int i = 10; i >= 0; i--) {
			for(int todoitem_num = 0; todoitem_num < sort_todoitem_size; todoitem_num++) {
				if(this.todoitems.get(todoitem_num).getImportance() == i) {
					TodoItem sort_todoitem = new TodoItem(todoitems.get(todoitem_num).getTitle(),todoitems.get(todoitem_num).getImportance(),todoitems.get(todoitem_num).getProgress());
					this.todoitems.add(sort_todoitem);
				}
			}
		}
		
		// todoitemsからsort前のtodoitemを削除
		for(int delete_index = sort_todoitem_size - 1; delete_index >= 0; delete_index--) {
			this.todoitems.remove(delete_index);
		}
		
		// sort後のtodoltemsの表示
		for(TodoItem todoitem: this.todoitems) {
			
			if(todoitem.getProgress() == true) {
				System.out.println(index_num + "…" + todoitem.getTitle() + "/ 重要度：" + todoitem.getImportance() + "/ 進捗：完了");
			} else {
				System.out.println(index_num + "…" + todoitem.getTitle() + "/ 重要度：" + todoitem.getImportance() + "/ 進捗：未完了");
			}
			index_num++;
		}
	}
}
