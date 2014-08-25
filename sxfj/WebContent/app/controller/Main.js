Ext.define('SXFJ.controller.Main', {
    extend: 'Ext.app.Controller',
	views:['LoginWindow'],
	refs:[{
		selector:'loginwindow',
		ref:'loginWindow'
	}],
	//refs中定义的内容，对于Ext.window.Window这种没有直接渲染的组件，需要自己先new一个
	init:function(){
		this.control({
		});
	},
	onLaunch:function(){

//		var login = Ext.create('SXFJ.view.LoginWindow',{
//
//		});
//		login.show();
	}

	
});
