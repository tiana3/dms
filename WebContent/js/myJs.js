	  //点击功能后权限验证的方法  
    function powerJump(url){
    	//想要跳转到那个功能，就会传入哪个功能的url， 后面的function就匿名函数，成功后会调用里面的代码
    	$.post(url,function(data){
    		//先把服务端的json的字符串转成json对象
    		var json = JSON.parse(data);
    		//取出是否具有权限，约定0是没有权限，1是有权限
    		var valid = json.valid;
    		if(0==valid) {
    			var msg = json.message;
    			//没有权限的话，会有信息，说明是不具有哪个具体的权限
    			layer.msg(msg,{icon:4,time:1500});
    		}else if(1==valid){
    			//如果有权限的话，会有跳转的url，就直接跳转
                var url = json.url;
    			location.replace(url);
    		}
    	})
    }