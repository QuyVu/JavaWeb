<style>
input{
margin: 5px;}
</style>

<form action="forms" method="post">
  <fieldset>
    <legend>Personal information:</legend>
    First name: 
    <input type="text" name="firstname">
    <br>
    Last name: 
    <input type="text" name="lastname">
    <br>
    <input type="submit" value="Submit">
  </fieldset>
</form>

<div><h3>${fullname}</h3></div>