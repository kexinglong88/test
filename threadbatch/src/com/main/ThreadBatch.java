package com.main;

import java.util.ArrayList;
import java.util.List;

import com.domain.User;
import com.utils.ListUtils;

class ThreadTask extends Thread {
	private List<User> users;

	public ThreadTask(List<User> users) {
		this.users = users;
	}

	@Override
	public void run() {
		for (User user : users) {
			System.out.println(getName() +"======="+ user.toString());
		}
	}
}

/**
 * @desciption: 多线程分批处理数据
 * @author: kexl
 * @date: 2020-08-21
 */
public class ThreadBatch {

	public static void main(String[] args) {
		// 1.初始化数据量
		List<User> userList = initUsers();

		// 2.定义每一个线程跑多少数据量
		int pageSize = 2;
		// 3.计算所需线程数目 并且计算每个线程跑哪些数据
		List<List<User>> groupList = ListUtils.splitList(userList, pageSize);
		for (int i = 0; i < groupList.size(); i++) {
			List<User> users = groupList.get(i);
			ThreadTask threadTask = new ThreadTask(users);
			threadTask.start();

		}
		// 4.定义子线程分批异步处理数据

	}

	public static List<User> initUsers() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 11; i++) {
			users.add(new User(i, "name" + i));
		}
		return users;

	}

}
