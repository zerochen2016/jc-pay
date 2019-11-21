function isEmpty(param){
	return param==null||typeof(param)=='undefined'||param=='';
}

function lengthLimit(param,min,max){
	if(param==null||typeof(param)=='undefined'){
		return false;
	}
	return (param.length>max||param.length<min)
}

function isPositiveInteger(param){
	if(param==null||typeof(param)=='undefined'||param.length<1){
		return false;
	}
	return (/^[0-9]*$/.test(param));
}

function isInteger(param){
	if(param==null||typeof(param)=='undefined'||param.length<1){
		return false;
	}
	return (/^(-)?[0-9][0-9]*$/.test(param));
}

function isFloat(param){
	if(param==null||typeof(param)=='undefined'||param.length<1){
		return false;
	}
	return (/^-?\d*\.\d+$/.test(param));
} 

function isPositiveFloat(param){
	if(param==null||typeof(param)=='undefined'||param.length<1){
		return false;
	}
	return (/^\d*\.\d+$/.test(param));
}

function isPrice(param){
	if(param==null||typeof(param)=='undefined'||param.length<1){
		return false;
	}
	return isPositiveFloat(param)||isPositiveInteger(param);
}

function alertSuccess(text){
	alert(text);
}

function alertFail(text){
	alert(text);
}
function alertConfirm(text){
	return confirm(text);
}

function pager(data, callback, pagerId){
	pagerId = pagerId || '#pager';
	$(pagerId).pager({
		pagenumber: data.page || 1,  //当前页面
		pagecount: data.pageCount || 1,   //总页数
		buttonClickCallback: function(p) {
			location.hash = p;
            data.page = p;
            if(callback){
				callback(data);
                $('html,body').animate({scrollTop:0}, 'fast');
			}
		}
	});
};
function init(page,pageSize,totalCount){
	var pageCount = 1;
	$("#totalCount").html(totalCount);
	if(totalCount%pageSize==0){
		pageCount =parseInt(totalCount/pageSize);
	}else{
		pageCount = parseInt(totalCount/pageSize)+1;
	}
	var data = {
		page: page,
		pageCount: pageCount,
	}
	pager(data);
	return data;
	
}
function uploadFile(id,url,fileType){
    var pictureArr = document.querySelector("#"+id).files;
    var file = pictureArr[0];
    var formData = new FormData();
    formData.append('file',file);
    formData.append('fileType',fileType);
    var ajaxResult = '';
	$.ajax({  
		url: url,
        type: 'POST',  
        data: formData,  
        async: false,
        cache: false, 
		dataType: "json",
        contentType: false,  
        processData: false,  
        success: function (result) {  
        	ajaxResult = result;
        },  
        error: function (result) {  
            ajaxResult = {
            	code: -1,
            	msg: "上传失败"
            };
        }  
   });
   return ajaxResult;  
}