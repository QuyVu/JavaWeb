<!DOCTYPE html>
<html>
<head>
<title><@tiles.insertAttribute name="title" /></title>
</head>
<style type="text/css">
.header,.main,.footer {
 width: 960px;
 color: #665544;
 margin: 0px auto;
 clear: both;
}
.header,.footer,.leftPane,.rightPane {
 border: 1px solid gray;
}
.leftPane,.rightPane {
 float: left;
 margin: 10px;
 margin-left: 0px;
}

.leftPane {
 width: 100px;
 height: 200px;
}

.rightPane {
 width: 835px;
 height: 200px;
}

.leftMenu {
 list-style: none;
 padding: 0;
 margin: 10px;
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