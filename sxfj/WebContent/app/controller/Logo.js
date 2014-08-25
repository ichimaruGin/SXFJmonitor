Ext.define('SXFJ.controller.Logo',{
	extend: 'Ext.app.Controller',
	views: ['Logo'],

	refs:[{
		selector:'logo',
		ref:'loGo'
	}],

	init:function(){
		this.control({
			'logo':{
				//render:this.showCurrentDate,
			}
		});
	},
	
	onLaunch:function(){
	
	},
	
	showCurrentDate:function(){
		var dateLabel = this.getLoGo().down('toolbar').down('label[name=currentTime]');
		config = {
			interval: 1000,
			run: function(){
				dateLabel.update('当前时间:'+Ext.Date.format(new Date(),'Y-m-d H:i:s'));
			}
		},
		Ext.TaskManager.start(config);
		
	}
});