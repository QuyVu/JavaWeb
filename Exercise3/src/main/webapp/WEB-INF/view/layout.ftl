
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><@tiles.insertAttribute name="title" /></title>
</head>
<style type="text/css">
.header,.footer {
 width: 960px;
 margin: 0px auto;   
 background-color:black;
 color:white;
 padding:1px;
}

.leftMenu {
background-color: #f1f1f1;
 list-style: none;
 padding: 10px;
}

.main {
        width: 960px;
        overflow: hidden;
        margin: 0px auto;
    }

.leftPane, .rightPane {
        padding-bottom: 1000px;
        margin-bottom: -1000px;
	float: left;
}

.leftPane {
background-color: #f1f1f1;
	width: 160px;
	height:100%;
	min-height: 400px;
}

.rightPane {
	padding-left: 10px;
	width: 776px;
	height:100%;
	min-height: 400px;
}

</style>
<body>
<@tiles.insertAttribute name="header" />
 <div class="main">
  <@tiles.insertAttribute name="menu" />
  <div class="rightPane">
   <@tiles.insertAttribute name="body" />
  </div>
 </div>
<@tiles.insertAttribute name="footer" />
 
</body>
</html>