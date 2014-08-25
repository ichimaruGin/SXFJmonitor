Ext.define('SXFJ.view.Logo',{
	extend:'Ext.panel.Panel',
	alias:'widget.logo',
	
	requires:['Ext.Img',
			  'Ext.toolbar.Toolbar',
	          'Ext.toolbar.TextItem',
			  'Ext.form.Label'],
	initComponent:function(){
		var me = this;
		Ext.apply(this,{
			frame:true,
			border:false,
			items:[{
			    xtype: 'toolbar',
				style:'width: 1200px;height: 24px;padding-left:0px;padding-right:10px; ',
			    items: ['','-',{
							xtype:'button',
							text:'主页',
							textAlign:'center',
						    handler: function(btn){  
						    	window.open("http://www.sxtmgc.com/cn/index.php");
						    },
						},
						'->',
						{xtype:'label',name:'currentTime'},
			    ]
			},{
				xtype:'image',
				src:'resources/images/logo1200.png',
				style:'width: 1200px;height: 115px;'
			}],
			listeners:{
				render:function(){
					var timeLabel = me.down('toolbar').down('label[name=currentTime]');
					config = {
							interval: 1000,
							run: function(){
								timeLabel.update(Ext.Date.format(new Date(),'Y-m-d H:i:s'));
							}
						};
					Ext.TaskManager.start(config);
				}
			}
		});
		this.callParent();
	}
});