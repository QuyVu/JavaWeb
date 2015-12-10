<#ftl encoding='UTF-8'>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/Exercise3">Start Bootstrap</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index">Index</a></li>
				<#include "/WEB-INF/view/HTML/HTMLmenu.ftl">
				<#include "/WEB-INF/view/CSS/CSSmenu.ftl">
				<#include "/WEB-INF/view/JS/JSmenu.ftl">
            </ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="about">About</a></li>
				<li><a href="help">Help</a></li>
        	</ul>
		</div>
	</div>
	<!-- /.container -->
</nav>