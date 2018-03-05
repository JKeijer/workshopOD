<!doctype html>
<html>
<head>
<link rel="shortcut icon" type="image/ico" href="favicon.ico">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="HandheldFriendly" content="True">


<link rel="stylesheet" type="text/css" media="screen"
	href="style/concise.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="style/login.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="style/webapp.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script src="js/concise.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>



</head>

<body>
	<header class="siteHeader container clearfix"> </header>
<body>

	<div class="siteContent container">
		<div class="container vertical-divider">
			<div class="column two-thirds">
				<div id="tfheader">
					<div id="msg"></div>
					<div id="tfheader">
						<%
						Object e = request.getAttribute("beginning");
						String letter = (String) e;
						if (letter != null) {
								%>

						<script>
					$(function(){
						 showText("#msg", "<%=letter%>" + "\n", 0, 40);
					});
					</script>

						<%
					} else { 
					    %>
						<script>
						$(function(){
							 showText("#msg", "please give input to start" + "\n", 0, 40);
						});
						</script>
						<% 
					}
					Object f = request.getAttribute("position");
					String posis = "";
					if (f == null) {
					    posis = "begin";
					} else {
					 	posis = (String) f;
					}
					Object t = request.getAttribute("clientToken");
					String tok = "";
					if (t != null) {
						tok = (String) t;
					}
					%>
					</div>
					<form id="tfnewsearch" method="POST" action="start">
						<input type="hidden" name="action" value="<%=posis%>" /> 
						<input type="hidden" name="token" value="<%=tok%>"/>
						<input type="text" id="textinput" class="tftextinput" name="q"
							height="10" size="50" maxlength="120" autocomplete="off"
							autofocus /> <input type="submit" id="textinputbutton"
							value="Enter" class="btn bg-small" />
					</form>
				</div>
			</div>
						<div class="column one-third">
			<%Object h = request.getAttribute("tried");
			if (h != null) {
			java.util.List<?> fsr = (java.util.List<?>) h;
			for (Object x : fsr) {
			%>
			<%= x %>
			<br><% 
			}
			}
			%>
		</div>
		</div>

	</div>

			<!-- <footer class="container">
				<div class="voetjes">
					<p>Copyright &copy; 2016 by Julik Keijer</p>
				</div>
			</footer> -->
			<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
			<script src="js/concise.min.js"></script>
			<script type="text/javascript" src="js/main.js"></script>
</body>
</html>