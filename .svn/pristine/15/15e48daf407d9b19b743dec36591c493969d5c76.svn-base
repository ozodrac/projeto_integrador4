$.fn.navMenu = function(opt){
	var init = {
		layout 		    : 'menu-layout',
		styleDefault    : 'menu-default',
		styleHover 	    : 'menu-hover',
		styleDefaultSub : 'submenu-default',
		styleHoverSub   : 'submenu-hover'		
	}
	var opt = $.extend(init, opt);
	var id  = '#'+this.attr('id');
	$(id+' li:first').addClass('ui-corner-left');
	$(id+' li:last').addClass('ui-corner-right');	
	$(this).addClass(opt.layout);
	
	var IDlargura = $(id).width();
	// Efeito Hover no "menu" e mostrar o "submenu"
	$(this).children('li').addClass(opt.styleDefault).hover(function(){
		$(this).removeClass(opt.styleDefault).addClass(opt.styleHover);
		var submenu = $(this).children('ul').addClass('submenu');
		if(submenu[0]){
			submenu.addClass('ui-corner-bottom').show(100);
		}
	},function(){
		$(this).removeClass(opt.styleHover).addClass(opt.styleDefault).children('ul').hide(100);	
	});
	
	
	// Efeito hover no "submenu" e mostrar o "submenuItem"
	$(id+' li').children('ul').addClass('ui-corner-all').children('li').hover(function(){
		$(this).removeClass(opt.styleDefaultSub).addClass(opt.styleHoverSub);
		var submenuItem = $(this).children('ul').addClass('submenuItem');
		if(submenuItem[0]){
			submenuItem.css('margin-top','-20px');	
		}
		if($(this).parent('ul.submenuItem')[0]){	
			subLarguraItemTotal = submenuItem.width()*3; // 600px	
			if(IDlargura<=subLarguraItemTotal){
				submenuItem.css('left','-'+$(this).parent('ul').width()+'px')
			}else{
				submenuItem.css('left',$(this).parent('ul').width()-20+'px')
			}				
		}else{
				submenuItem.css('left',$(this).parent('ul').width()-20+'px')
		}
		submenuItem.show(100);
	
	},function(){
		$(this).removeClass(opt.styleHoverSub).addClass(opt.styleDefaultSub).children('ul').hide(100);
	});
}