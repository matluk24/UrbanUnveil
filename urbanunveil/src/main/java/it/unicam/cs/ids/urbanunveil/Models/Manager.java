package it.unicam.cs.ids.urbanunveil.Models;

import java.util.List;
import java.util.LinkedList;


public class Manager extends Role {
	
	private List<UserNode>userList;
	
	
	public Manager(int id, RoleName role, String description) {
		super(id,role,description); 
		this.getDBList();
	}
	
	private void getDBList() {
		//TODO select user list from DB
				List<User> users = null;// data from db stored
				for(User user: users) {
					List<RoleName> roleNames = this.getRoleNames(user.getId());
					this.userList.add(new UserNode(user,null));
				}
	}

	private LinkedList<RoleName> getRoleNames(Long id){
		//TODO select role name list from DB by Id
				LinkedList<RoleName> roleNames = new LinkedList<RoleName>();
				return roleNames;
	}
	private void upload() {
		//TODO upload information suddenly changed
	}
	
	private User getUser(Long id) {
		for (UserNode node : userList) {
			if(node.getUser().getId() == id) {
				return node.getUser();
			}
		}
		return null;
	}
	
	public List<UserNode> getList(){
		return this.userList;
	}
	private class UserNode{
		private User user;
		private List<RoleName> roleNames;
		
		public UserNode(User user, List<RoleName> roleNames) {
			this.user =user;
			this.roleNames = roleNames;
		}
		
		public User getUser() {
			return this.user;
		}
		public List<RoleName> getRoleNames(){
			return this.roleNames;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public void setRoleNames(List<RoleName> roleNames) {
			this.roleNames = roleNames;
		}
	}
}


