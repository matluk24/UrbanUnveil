package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import java.util.LinkedList;

@Service
public class ManagerService{
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	
	public ManagerService(int id, RoleName role, String description) {
		
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


