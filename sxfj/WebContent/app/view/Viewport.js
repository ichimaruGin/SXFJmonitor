Ext.define('SXFJ.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires:[
        'Ext.layout.container.Fit',
        'SXFJ.view.Main'
    ],

	layout:{
		type:'hbox',
		//align:'stretch',
		pack:'center'
	},

    items: [{
        xtype: 'main-panel',
    }]
});
