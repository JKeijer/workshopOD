<!doctype html>
<%@page import="core.UserServlet"%>
<%@page import="core.User"%>
<html>
<head>
<link rel="shortcut icon" type="image/ico" href="favicon.ico">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="HandheldFriendly" content="True">

<title>&Uuml;ber-coaching</title>

<link rel="stylesheet" type="text/css" media="screen"
	href="style/concise.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="style/webapp.css" />

<script type="text/javascript">
	function logOut() {
		var logOut = confirm("Are you sure you want to log out ?");
		if (logOut == true) {
			location.href = "start";
		} else {
			location.href = "#";
		}
		return false;
	}
</script>
</head>

<body>
	<header class="siteHeader container clearfix">
		<a href="webapp"> <img class="logo" src="images/Ubercoaching.png"
			alt="Ubercoaching">
		</a>
		<nav class="nav">
			<ul>
				<a href="webapp" class="buttonlink" href=""><li>Personal
						Home</li></a>
				<a href="InAbout" class="buttonlink" href=""><li>About</li></a>
				<a href="InContact" class="buttonlink" href=""><li>Contact</li></a>
				<a href="#" class="buttonlink" onclick="logOut()"><li>Log
						Out</li></a>
			</ul>
		</nav>
	</header>

	<main class="siteContent container"> <%
 	core.User user = null;
 	if (request.getSession().getAttribute("user") != null) {
 		user = core.User.fromIdUser(((core.User) request.getSession()
 				.getAttribute("user")).getIdUser());
 	}
 	double bmi = 0;
 	double vet = 0; 		
 	

	searches.Goal goal = user.getGoal();
	String username = user.getUsername();
			
			
 	if (user != null) {
 		System.out.println("user is not null");
 		if (user.getUserBMI() != null) {
 			bmi = user.getUserBMI().getBMI();
 			System.out.println("BMI is written" + bmi);
 		} else {
 			bmi = -1;
 			System.out.println("BMI is -1");
 		}
 		if (user.getUserVet() != null) {
 			vet = user.getUserVet().getVPT();
 		} else {
 			vet = -1;
 		}
 	} %> Welcome, "<%=username %>" Your current <b>BMI</b>: <%=bmi%></p>

	Your current <b>fat-percentage</b>: <%=vet%> Your current <b>goal</b>:
	<%=goal%>

	Your </main>

	<footer class="siteFooter container">
		<p>Copyright &copy; 2015 by &Uuml;ber-coaching</p>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/concise.min.js"></script>
</body>
</html>