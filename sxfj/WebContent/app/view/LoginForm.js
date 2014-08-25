Ext.define('SXFJ.view.LoginForm',{
	extend: 'Ext.form.Panel',
	alais: 'widget.loginform',
	title: '登录验证',
	style:'margin-left:auto;margin-right:auto;margin-top:10%',
    
    frame:true,     //true ,会有浅的背景色及圆边角
	
	layout:'anchor',
	defaults:{		
		width:150,
		anchor:'95%',
		allowBlank:false, //默认不许空白
	},
	labelWidth: 30, // 标签的宽度
	defaultType:'textfield',
	initComponent:function(){
		var me = this;
		Ext.apply(this,{
			items:[{					
				fieldLabel:'用户名',
				name:'username',
				emptyText:'请输入用户名',
				blankText:'请务必输入用户名',
			    enableKeyEvents:true,
			    listeners:{
			        	keypress:{
			        		fn:function(self,e){		
			    				if(e.getKey() == 13){
						        	if(me.isValid())  //信息格式验证正确，提交表单，验证信息内容
						        		me.fireEvent('loginaction'); //触发自定义的事件 
						        	else{
						        		 Ext.Msg.alert('提示','     输入信息格式错误           ');	            		
						        	}
			    				}
			        		}
			        	}
			   }
			},{
				fieldLabel:'密码',
				name:'password',
				emptyText:'请输入密码',
				blankText:'请务必输入密码',
				inputType: 'password' ,
		        enableKeyEvents:true,
		        listeners:{
		        	keypress:{
		        		fn:function(self,e){		
		    				if(e.getKey() == 13){
					        	if(me.isValid())  //信息格式验证正确，提交表单，验证信息内容
					        		 me.fireEvent('loginaction'); //触发自定义的事件
					        	else{
					        		 Ext.Msg.alert('提示','     输入信息格式错误           ');	            		
					        	}
		    				}
		        		}
		        	}
		        }
			}],			
			buttonAlign:'center',
		    buttons: [{
		        text: '重置',       
		        handler:function(){               	
		        	me.form.reset();
		        }
		    },{
		        text: '登录',
		        itemId:'login',
		        handler:function(){
		        	if(me.isValid())  //信息格式验证正确，提交表单，验证信息内容
		        		me.fireEvent('loginaction'); //触发自定义的事件;
		        	else{
		        		 Ext.Msg.alert('提示','     输入信息格式错误           ');	            		
		        	}
		        }
		    }]
		});
		this.addEvents('loginaction');//自定义登录验证事件
		this.callParent();
	}
	
});
