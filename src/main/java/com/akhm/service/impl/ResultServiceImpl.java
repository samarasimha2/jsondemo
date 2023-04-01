package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.dto.UsersDTO;
import com.akhm.service.AlbumService;
import com.akhm.service.CommentsService;
import com.akhm.service.PostsService;
import com.akhm.service.ResultService;
import com.akhm.service.TodosService;
import com.akhm.service.UserService;

@Service
public class ResultServiceImpl implements ResultService {
	@Autowired
	private UserService userService;
	@Autowired
	private TodosService todosService;
	@Autowired
	private PostsService postsService;
	@Autowired(required = false)
	private CommentsService commentsService;
	@Autowired(required = false)
	private AlbumService albumService;
	@Override
	public List<UsersDTO> getUsers() {
		List<UsersDTO> usersList = new ArrayList<>();
		try {
			List<User> users = userService.getUsers();
			List<Todos> todos=todosService.getTodos();
			List<Posts> posts=postsService.getPosts();
			List<Comments> comments=commentsService.getComments();
			List<Albums> albums=albumService.getAlbums();
			for(User user:users)
			{
				UsersDTO usersDTO=new UsersDTO();
				//usersDTO.setId(user.getId());
				BeanUtils.copyProperties(user, usersDTO);
				List<Todos> userTodos=todos.stream().filter(t->t.getUserId()==user.getId()).collect(Collectors.toList());
				usersDTO.setTodosCount(userTodos.size());
				List<Todos> pendingTodos=userTodos.stream().filter(t->t.isCompleted()==false).collect(Collectors.toList());
				List<Todos> completedTodos=userTodos.stream().filter(t->t.isCompleted()==true).collect(Collectors.toList());
				usersDTO.setPendingTodosCount(pendingTodos.size());
				usersDTO.setCompletedTodosCount(completedTodos.size());
				List<Posts> usersPosts=posts.stream().filter(p->p.getUserId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setPostsCount(usersPosts.size());
				List<Comments> userComments=comments.stream().filter(c->c.getPostId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setAlbumsCount(userComments.size());
				List<Albums> userAlbums=albums.stream().filter(a->a.getUserId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setCommentsCount(userComments.size());
				usersList.add(usersDTO);
				
				
				
				
				
			}
		} catch (Exception e) {

		}
		return usersList;

	}

}
