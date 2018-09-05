window.onload = function() {
	
	//获得元素对象
	var searchInput = document.getElementById('searchInput');
	var searchTips = document.getElementById('searchTips');
	var tipsItem = document.getElementsByTagName('li');
	
	//选中元素的索引
	var keyIndex = -1;
	
	//文本框获得焦点显示提示内容
	searchInput.onfocus = function(e) {
		searchTips.style.display = 'block';
	}
	
	//文本框阻止单击事件冒泡
	searchInput.onclick = function(e) {
		e = window.event || e;
		e.stopPropagation?e.stopPropagation():e.cancelable=true;
	}
	
	//document单击事件隐藏提示内容
	document.onclick = function() {
		resetTips();
	}
	
	//遍历li循环添加事件
	for (var i = 0;i < tipsItem.length - 1;i ++) {
		
		//li单击事件
		tipsItem[i].onclick = function() {
			
			searchInput.value = this.getElementsByTagName('span')[0].innerText;
			
		}
		
		//li中的a删除单击事件
		var a = tipsItem[i].getElementsByTagName('a')[0];
		
		a.onclick = function(e) {
			
			e = window.event || e;
			e.stopPropagation?e.stopPropagation():e.cancelable=true;
			
			searchTips.removeChild(this.parentNode);
			
		}
	}
	
	//document键盘按下识别
	document.onkeydown = function(e) {
		
		//判断提示框是否显示
		if(searchTips.style.display != 'block') {
			return;
		}
		
		e = window.event || e;
		
		//ESC键隐藏提示的内容
		if (e.keyCode == 27) {
			resetTips();
			searchInput.blur();
		}
		
		//下箭头
		if (e.keyCode == 40) {
			
			keyIndex ++;
			
			if (keyIndex > tipsItem.length - 2) {
				keyIndex = 0;
			}
			
			//调用高亮函数
			highlightItem(keyIndex);
		}
		
		//上箭头
		if (e.keyCode == 38) {
			
			keyIndex --;
			
			if (keyIndex < 0) {
				keyIndex = tipsItem.length - 2;
			}
			
			//调用高亮函数
			highlightItem(keyIndex);
		}
		
		//回车键
		if (e.keyCode == 13) {
			searchInput.value = tipsItem[keyIndex].getElementsByTagName('span')[0].innerText;
			resetTips()
		}
	}
	
	//高亮函数
	function highlightItem(index) {
		
		//去掉所有高亮
		for (var i = 0;i < tipsItem.length - 1;i ++) {
			tipsItem[i].className = '';
		}
		if (index != -1) {
			tipsItem[index].className = 'active';
		}
	}
	
	//重置提示框函数
	function resetTips() {
		searchTips.style.display = 'none';
		keyIndex == -1;
		highlightItem(-1);
	}
}