Ext.define('SXFJ.view.MyTree',{
	extend:'Ext.tree.Panel',
	alias:'widget.mytree',
	requires:['SXFJ.store.STree'],
	title:'企业树',
	width:200,
	height:400,
    useArrows:true,
	initComponent:function(){
		Ext.apply(this,{        
			store: Ext.create('SXFJ.store.STree'),
//			columns:[{
//				xtype:'treecolumn',dataIndex:'name',flex:1
//			}]
//			 root: {
//			        name: 'Root',
//			        //expanded: true,
//			        children: [
//			            {
//			                text: '节点1',
//			                leaf: true
//			            },
//			            {
//			                text: '节点2',
//			                leaf: true
//			            },
//			            {
//			                text: '节点3',
//			                expanded: true,
//			                children: [
//			                    {
//			                        text: '孙子节点',
//			                        leaf: true
//			                    }
//			                ]
//			            }
//			        ]
//			    }
		});
		this.callParent();
	}
});