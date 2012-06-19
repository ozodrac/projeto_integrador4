$(document).ready(function(){
	$("#zone-bar li").mouseover(function() {
		console.log("hover");
		var hidden = $(this).children("ul").is(":hidden");
		$("#zone-bar>ul>li>ul").hide();
		$("#zone-bar>ul>li>a").removeClass();
		if (hidden) {
			console.log($(this), $(this).children("ul"));
			$(this).children("ul").toggle().parents("li").children("a").addClass("zoneCur");
		}
	});
});