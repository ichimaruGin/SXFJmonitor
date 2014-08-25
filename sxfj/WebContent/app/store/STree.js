Ext.define('SXFJ.store.STree',{
	extend: 'Ext.data.TreeStore',
//	fields: [{
//		name:'id',type:'int'
//	},{
//		name:'text',type:'string'
//	}],
//	proxy:{
//		type:'ajax',
//		api:{
//			read:'/sxfj/query/?tree',
//		}
//	},
	proxy:{
		type:'ajax',
		url: '/sxfj/query/?tree',
		reader:{
			type:'json'
		}		
	},
    root: {
        text: 'People',
        expanded: true
    }
});