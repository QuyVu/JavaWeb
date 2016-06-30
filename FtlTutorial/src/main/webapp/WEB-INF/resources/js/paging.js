function Paging(curPage, nextPage, offset, from, to, total) {
	this.curPage = curPage;
	this.nextPage = nextPage;
	this.offset = offset;
	this.from = from;
	this.to = to;
	this.limit = 10;
	this.total = total
}

Paging.prototype.setCurPage = function(curPage) {
	this.curPage = parseInt(curPage);
}

Paging.prototype.setNextPage = function(curPage) {
	this.nextPage = parseInt(curPage+1);
}

Paging.prototype.setOffset = function(curPage) {
	this.offset = parseInt((curPage-1)*this.limit);
}

Paging.prototype.setFrom = function(curPage) {
	this.from = parseInt((curPage-1)*this.limit + 1);
}

Paging.prototype.setTo = function(nextPage) {
	this.to = parseInt((nextPage-1)*this.limit);
}

Paging.prototype.setTotal = function(total) {
	this.total = total;
}