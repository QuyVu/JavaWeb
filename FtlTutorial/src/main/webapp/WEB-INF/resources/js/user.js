function User(id, name, password) {
	this.id = id, this.name = name, this.password = password
}

User.prototype.setUser = function(id, name, password) {
	this.id = id;
	this.name = name;
	this.password = password;
}

User.prototype.setId = function(id) {
	this.id = id;
}

User.prototype.setName = function(name) {
	this.name = name;
}

User.prototype.setPassword = function(newPassword) {
	this.password = newPassword;
}