<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>project</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
				<th>User ID</th>
				<th>Company Name</th>
				<th>Person Name</th>
				<th>Details</th>
				<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.company.name}</td>
						<td>${user.name} </td>
						<td>
							<table>
								<tr>
									<td>name:</td>
									<td>${user.name} </td>
								</tr>
								<tr>
									<td>userName:</td>
									<td>${user.userName}</td>
								</tr>
								<tr>
									<td>email:</td>
									<td>${user.email}</td>
								</tr>
								<tr>
									<td>street:</td>
									<td>${user.address.street}</td>
								</tr>
								<tr>
									<td>suite:</td>
									<td>${user.address.suite}</td>
								</tr>
								<tr>
									<td>city:</td>
									<td>${user.address.city}</td>
								</tr>
								<tr>
									<td>zip code:</td>
									<td>${user.address.zipcode}</td>
								</tr>
								<tr>
									<td>latitude:</td>
									<td>${user.geo.latitude}</td>
								</tr>
								<tr>
									<td>longitude:</td>
									<td>${user.geo.longitude}</td>
								</tr>
								<tr>
									<td>phone:</td>
									<td>${user.phone}</td>
								</tr>
								<tr>
									<td>web site:</td>
									<td>${user.website}</td>
								</tr>
								<tr>
									<td>catchPhrase:</td>
									<td>${user.company.catchPhrase}</td>
								</tr>
								<tr>
									<td>bs:</td>
									<td>${user.company.bs}</td>
								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr>
									<td>
										<a href="userposts/${user.id }">Posts(${postsCount} 10)</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="usercomments/${user.id }">Comments(${commentsCount} 17)</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userstodos?id=${user.id }">Todos(${todosCount} 24)</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userspendingtodos/${user.id }">PendingTodos(${pendingTodosCount} 1)</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="userscompletedtodos/${user.id }">CompletedTodos(${completedTodosCount} 5)</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="useralbums/${user.id }">Albums(${albumsCount} 12)</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>