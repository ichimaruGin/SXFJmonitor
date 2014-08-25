Ext.define('SXFJ.controller.LoginWindow',{
	extend: 'Ext.app.Controller',
	views: ['LoginWindow'],
	
	refs:[{
		selector: 'loginwindow',
		ref: 'loginWindow'
	},{
		selector: 'main-panel',
		ref: 'mainPanel'
	}],
	
	init:function(){
		this.control({
			'loginwindow':{
				loginclick: this.login,
			}
		});
	},
	
	onLaunch:function(){
		
	},
	login:function(loginForm){	
		var me = this;  //me为loginwindow的引用
		Ext.Ajax.request({
			url: '/sxfj/?login',
			params: loginForm.getValues(),
			method: 'post',
			success: function(response){
				var res = Ext.decode(response.responseText, true);
				if(res.result == 'success'){
					Ext.Msg.show({
						title: '用户登录',
						msg: '登录成功---正在跳转...',
						closable: false,
						icon: Ext.Msg.INFO,
					});
					setTimeout(function(){
						me.getLoginWindow().hide();
						Ext.Msg.close();		
						me.getMainPanel().query('panel[region=west]')[0].show();
					}, 500);
					
				}else if(res.result == 'userError'){
					Ext.Msg.show({
						title: '用户登录',
						msg: '用户名错误',
						closable: false,
						icon: Ext.Msg.INFO,
						buttons: Ext.Msg.OK
					});
				}else if(res.result == 'passwdError'){
					Ext.Msg.show({
						title: '用户登录',
						msg: '密码错误',
						closable: false,
						icon: Ext.Msg.INFO,
						buttons: Ext.Msg.OK
					});
				}else{
					
				}
			},
			failure: function(response){
				var res = Ext.decode(response.responseText, true);
				Ext.Msg.show({
					title: '用户登录',
					msg: res,
					icon: Ext.Msg.INFO,
					closable: false,
					buttons: Ext.Msg.OK
				});
			}
		});
	}
});