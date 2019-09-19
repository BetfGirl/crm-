function myconfirm(title,fn){
	layer.confirm(title, {
		btn : [ '确认', '取消' ]
	}, fn);
}
function closeFrame(){
	 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	  parent.layer.close(index); 
}
//最大 operator使用
function openFrame(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['860px','340px', '70%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  closeBtn: 1,
		  content: url
		}); 
}

function openFrameR(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['660px','340px', '70%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  closeBtn: 1,
		  content: url
		}); 
}


//比较小 product用
function openFramep(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['350px','300px', '60%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  content: url
		}); 
}

//比较小 
function openFrames(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['350px','400px', '60%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  content: url
		}); 
}
//clienttype
function openFrametype(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['350px','180px', '40%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  content: url
		}); 
}
//超小workGroup
function openFramexs(url,title,area){
	if(!title) title="编辑";
	if(!area)area=['350px','180px', '40%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  skin: 'layui-layer-molv',
		  content: url
		}); 
}
function reload(tabid,data,startpage) {
	if(!startpage)startpage=1;
	if(!data)data={};
	layui.table.reload(tabid, {
		page : {
			curr : startpage
		},
		where : data
	}, 'data');
}

function fresh(id){
	layui.table.reload(id);
}


function getlist(url,data,selector,def_id){
		$.post(url,data, function(json) {
			var s=$(selector).empty();
			s.append($("<option value=''></option>"))
			for(var i=0;i<json.length;i++){
				var ss="";
				if(json[i].id==def_id) ss="selected='selected'";
				s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].name+"</option>"))
			}
			layui.form.render('select');
		},"json");
}

function getarray(url,data,selector,def_index){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(i==def_index) ss="selected='selected'";
			s.append($("<option value='"+i+"' "+ss+" >"+json[i]+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function render(filter,data){
layui.form.val(filter, data);
layui.form.render();
}
