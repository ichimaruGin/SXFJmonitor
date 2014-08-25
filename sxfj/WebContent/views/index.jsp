<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
    <!-- <x-compile> -->
        <!-- <x-bootstrap> -->
            <link rel="stylesheet" href="bootstrap.css">
            <link rel="stylesheet" href="resources/css/cls.css">
            <script src="ext/ext-dev.js"></script>
            <script src="bootstrap.js"></script>
        <!-- </x-bootstrap> -->
		<script src="ext/locale/ext-lang-zh_CN.js"></script>
    <!-- </x-compile> -->
</head>
<body >
	<div id="appLoadingIndicator">
		<div ></div>
		<div ></div>
		<div ></div>
	</div>
	<script>
		Ext.require(['SXFJ.view.Logo',
		             'SXFJ.view.LoginWindow',
		             'SXFJ.view.LoginForm',
		             'Ext.container.Viewport']);
		Ext.onReady(function(){
			var logo = Ext.create('SXFJ.view.Logo');
			var loginform = Ext.create('SXFJ.view.LoginForm',{
				width:300
			});
			//var loginWindow = Ext.create('SXFJ.view.LoginWindow');
			var mainPanel = Ext.create('Ext.panel.Panel',{
				name:'mainpanel',
				width:1200,
				border:true,
				overflowY:'auto',
				bbar: ['->',
				       { xtype: 'label',
						 html:'<a href="http://www.sxtmgc.com/cn/index.php" style="text-decoration:none;text-align:center;color:black;" target="_blank" title="点击链接到绍兴纺机集团主页">copyright @2014 绍兴纺机集团 </a>'},
						'->'
				     ],
				items:[logo,loginform]
			});
			
			Ext.create('Ext.container.Viewport',{
				layout:{
					type:'hbox',
					align:'stretch',
					pack:'center'
				},
				items:[mainPanel]
			});
			loginform.addListener('loginaction',function(){
				Ext.Ajax.request({
					url: '/sxfj/?logincheck',
					method: 'post',
					params: loginform.getValues(),
					success: function(response){
						console.log(response.responseText);
						var res = Ext.decode(response.responseText, false);
						if(res.result == true){
							Ext.Msg.show({
								title: '用户登录',
								msg: '登录成功---正在跳转...',
								closable: false,
								icon: Ext.Msg.INFO,
							});
							setTimeout(function(){
								Ext.Msg.close();		
								location.href = '/sxfj/?loginin'
							}, 500);
							
						}else if(res.result == false){
							Ext.Msg.show({
								title: '用户登录',
								msg: '用户名或密码错误',
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
			});
			
			//loginWindow.show();			
			var appLoadingIndicator = document.getElementById('appLoadingIndicator');
			document.body.removeChild(appLoadingIndicator);
		});		
	</script>
</body>
	<style type="text/css">
		 html{
            height: 100%;       
            background-color: gray
        }

        #appLoadingIndicator {
            position: absolute;
            top: 50%;
            margin-top: -15px;
            text-align: center;
            width: 100%;
            height: 30px;
            -webkit-animation-name: appLoadingIndicator;
            -webkit-animation-duration: 1.0s;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-direction: linear;
        }

        #appLoadingIndicator > * {
            background-color: #FFFFFF;
            display: inline-block;
            height: 30px;
            -webkit-border-radius: 15px;
            margin: 0 5px;
            width: 30px;
            opacity: 0.8;
        }

        @-webkit-keyframes appLoadingIndicator{
            0% {
                opacity: 0.8
            }
            50% {
                opacity:  0
            }
            100% {
                opacity: 0.8
            }
        }
        
	</style>
</html>