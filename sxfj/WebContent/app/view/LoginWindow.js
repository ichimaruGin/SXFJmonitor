Ext.define('SXFJ.view.LoginWindow',{
	extend:'Ext.window.Window',
	alias:'widget.loginwindow',
	requires:['Ext.form.Panel'],
//	alternateClassName: 'loginWindow',
//	singleton:true,
//	title: 'login',  //若定义在initComponent中，则会比Controller中onLaunch方法要迟，即会显示initComponent的结果
	closable: false,
	bodyPadding: 10,
	width: 350,
	height: 155,
	title: '登录窗口',
	initComponent:function(){
		var me = this;
		Ext.apply(this,{
			border: false,
			items:[{
				xtype:'form',
				defaultType: 'textfield',
				bodyStyle:'padding:5px',
				frame: true,
				border: false,
				defaults:{
					LabelWidth: 100,					
				},
				items:[{
					fieldLabel:'用户名',
					name:'username',
					allowBlank:false,
					emptyText:'请输入你的用户名'
				},{
					fieldLabel:'密码',
					name:'password',
					allowBlank:false,
					inputType: 'password',
					emptyText:'请输入你的密码'
				}],
				buttonAlign:'center',
				buttons: [{
					text: '登录',
					handler:function(btn){
						me.fireEvent('loginclick',me.down('form'));  //触发LoginWindow的自定义事件logincheck
					}
				},{
					text: '重置',       
					handler:function(){               	
						me.down('form').form.reset();
				    }
				}],
			}],
		});	
		this.addEvents('loginclick'); //为LoginWindow添加一个自定义事件
		this.callParent();

	}

});