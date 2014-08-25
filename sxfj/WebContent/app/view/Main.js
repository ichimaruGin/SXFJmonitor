Ext.define('SXFJ.view.Main', {
    extend: 'Ext.panel.Panel',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border',
		'SXFJ.view.Logo',
		'SXFJ.view.MyTree',
		'Ext.layout.container.Accordion'
    ],
    
    alias:'widget.main-panel',

    layout: {
        type: 'border'
    },
    width:1200,
    height:'100%',
    autoflowY:'auto',
    items: [{
		region: 'north',
		xtype: 'logo',
	},{
        region: 'west',
        xtype: 'panel',
        title: '导航栏',
		border: 1,
		//hidden:true,
		width:300,
		layout:{
			type:'accordion',
		    titleCollapse: true,//不一定要点+或-就选中
		    animate: true,
		    align:'stretch',// 各子组件的宽度拉伸至与容器的宽度相等
		    fill:true,
		    multi:false
		},
		items: [{
		    xtype:'mytree',
		},{
		    
		},{
		    title: 'Panel 3',
		    html: 'Panel content!<br/>Panel content!<br/>Panel content!<br/>'
		}]	    
    },{
        region: 'center',
        xtype: 'tabpanel',		
        items:[{
            title: '菜单1',
			itemId: 'main_1_id',
			html:'<h1 class="x-panel-header">welcome1</h1>'
        },{
			title: '菜单2',
			itemId: 'main_2_id',
			html:'<b>welcome2</b>'
		}],
		//hidden:true,
    }],
	bbar: ['->',
	       { xtype: 'label',
			 html:'<a href="http://www.sxtmgc.com/cn/index.php" style="text-decoration:none;text-align:center;color:black;" target="_blank" title="点击链接到绍兴纺机集团主页">copyright @2014 绍兴纺机集团 </a>'},
			'->'
	     ],
});