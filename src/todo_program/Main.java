package todo_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("********TodoApp********");
		System.out.println("Todoは1件もありません。");
		
		TodoList todolist = new TodoList();
		
		int operation = 0;
		int importance = 0;
		int index = 0;
		
		while(true) {
			
			System.out.println("——————操作を入力してください。——————");
			System.out.print("1/登録 2/重要度変更 3/削除 4/終了 > ");
			operation = Integer.parseInt(br.readLine());
			
			if (operation == 1) {
				System.out.println("新規Todoを作成します。");
				System.out.print("Todo内容を入力してください > ");
				String title = br.readLine();
				System.out.print("重要度を1～10(最大)で入力してください > ");
				importance = Integer.parseInt(br.readLine());
				
				// 新規登録
				todolist.AddItem(title, importance);
				
			} else if (operation == 2) {
				System.out.print("重要度を変更します。番号を入力してください。 0 ～ " + (todolist.todoitems.size() - 1) + " > ");
				index = Integer.parseInt(br.readLine());
				System.out.print("重要度を再設定してください。 > ");
				importance = Integer.parseInt(br.readLine());
				
				
				// Todoリストの内容変更
				todolist.ImportanceChange(index, importance);
				
			} else if (operation == 3) {
				System.out.print("Todoを削除します。番号を入力してください。 0 ～ " + (todolist.todoitems.size() - 1) + " > ");
				index = Integer.parseInt(br.readLine());
				// Todoリストの削除
				todolist.DeleteItem(index);
				System.out.println("1件削除しました。");
				
			} else if (operation == 4) {
				break;
				
			} else {
				
			}
			
			// Todoリストの内容取得
			todolist.getTodoList();
		}
		
		System.out.println("アプリケーションを終了します。");
	}

}
