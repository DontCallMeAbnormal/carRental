var indexVehicle;//首页的车程信息
var userInfo; //用户的相关信息

$(document).ready(function(){
	getindexVehicle();
	testUser();//检查用户是否登录
})

function testUser(){

	$.ajax({
		type: "GET",
		url: "getUser",
		success: function (response) {
			console.log(response);
			if(response!=''){
				userInfo=response;
				console.log("用户已登录");
				logined();
			}else{
				console.log("用户未登录");
				login();
			}

		}
	});

}



//获取汽车数据
function getindexVehicle(){
	$.get("userQueryVehicleNew/6",function(data,status){
		indexVehicle=data;
	    console.log(indexVehicle);
	    write();
	  });
}

//想页面写入数据
function write() {
	if(indexVehicle==null){
		console.log("最新车品数据为空");
	}else{
		var productbox=$("#latest_product_box");
		var html01='<div class="col-sm-6 showpanel"><div class="thumbnail">';
		/*<img src="static/photo/20200114031040.png" alt="null">
		<div class="caption">
			<h4>宝马 2019
				<p>
					<small>2016-8-31|1.2万公里|跑车</small>
				</p>
			</h4>
			<div class="brand_footer">
				<h4 class="price_lefttext"><span class="price_color">100</span>元/天</h4>
				<button onclick="placeorder(i)" class="btn btn-success">下单</button>
				<button onclick="details(i)" class="btn btn-info">详情</button>
			</div>
		</div>*/
		var html02='</div></div>';
		
		var str='';
		for(let i=0;i<indexVehicle.length;i++){
			let data=indexVehicle[i];
			
			let vehcile_base_photo=indexVehicle[i].base.base_photo;
			let vehcile_base_brand=indexVehicle[i].base.base_brand;
			let vehcile_base_produced=indexVehicle[i].base.base_produced;
			let vehcile_mileage=indexVehicle[i].vehicle_mileage;
			let vehcile_base_type=indexVehicle[i].base.base_type;
			let vehicle_price=indexVehicle[i].vehicle_price;
			let vehicle_base_model=indexVehicle[i].base.base_model;
			let vehicle_id=indexVehicle[i].vehicle_id;
			str+=html01;
			str+='<img src="'+vehcile_base_photo+'" alt="null">'+
					'<div class="caption">'+
					'<h4>'+vehcile_base_brand+'  '+vehicle_base_model+
						'<p><small>'+vehcile_base_produced+'|'+vehcile_mileage+'万公里| '+vehcile_base_type+'</small></p></h4>'+
					
					'<div class="brand_footer">'+
					'<h4 class="price_lefttext"><span class="price_color">'+vehicle_price+'</span>元/天</h4>'+
					'<button onclick="placeorder('+i+')" class="btn btn-success">下单</button>'+
					'<button onclick="details('+vehicle_id+')" class="btn btn-info">详情</button></div></div>';
			
			
			str+=html02;
						
		}
		productbox.html(str);
		
		
	}
	
}





//点击详情后
function details(id){
	//info_vehicle_id=indexVehicle[i].vehicle_id;//将该车的数据传往后台
	window.location='details/'+id;
}


/**
 * 下单函数
 * @param {i} 车辆的id序号 
 */
function placeorder(i){

	if(userInfo=='' || userInfo == null){
		login_modal();//若用户未登录则调出登录模态框
	
		return;
	}
	var vehcile=indexVehicle[i];
	console.log(vehcile);
	/**
	 * 写到这
	 *	在前台计算好金额显示,传送日期和天数到后台,后台生成订单
	 * 	然后在跳转页面让用户查看订单
	 *  下一步写订单生成
	 * 
	 */
	$('#pay_modal').modal();

	$("#order_brand").text(vehcile.base.base_brand);
	$("#order_type").text(vehcile.base.base_type);
	$("#order_disp").text(vehcile.base.base_displacement+' L');
	$("#order_speed").text(vehcile.base.base_speed+' km/h');
	$("#order_mileage").text(vehcile.vehicle_mileage+'万公里');
	$("#order_condition").text(vehcile.vehicle_condition+'成');
	$("#order_price").text(vehcile.vehicle_price);
	
	//如果支付成功,则提交到后台
	if(pay()){


	}

}

/**
 * 支付接口,测试阶段默认返回字符成成功
 */
function pay(){



	return true;
}







/**
 * 快速查询的提交方法
 * @returns
 */
function submitSelect() {
	var vehicle_base_brand = $("#vehicle_base_brand").val();
	var vehicle_price = $("#vehicle_price").val();
	var vehicle_base_type = $("#vehicle_base_type").val();
	var vehicle_base_displacement = $("#vehicle_base_displacement").val();
	var vehicle_mileage = $("#vehicle_mileage").val();
	
	var formstr="";
	if(vehicle_base_brand!=-1){
		formstr += '<input name="base.base_brand" value='+vehicle_base_brand+'>'
	}
	if(vehicle_base_type!=-1){
		formstr += '<input name="base.base_type" value='+vehicle_base_type+' >';
		
	}
	if(vehicle_base_displacement!=-1){
		formstr +='<input name="base.base_displacement" value='+vehicle_base_displacement+' >';
	}
	if(vehicle_price!=-1){
		formstr +='<input name="vehicle_price" value='+vehicle_price+' >';
	}
	if(vehicle_mileage!=-1){
		formstr +='<input name="vehicle_mileage" value='+vehicle_mileage+' >';
	}
	$("#selectform").html(formstr);
	$("#selectform").submit();
	
}




/**
 * 显示登录的模态框
 */
function login_modal(){
	$("#userlogin_modal").modal();
}

/**提交登录模态框的数据 */
function action_login_form(){
	var formdata = $("#userlogin_modal_form").serialize();
	$.ajax({
		type: "POST",
		url: "loginUser",
		data: formdata,
		success: function (response) {
			if(response==''){
				alert("账号或密码错误");
				login();
			}else{
				userInfo=response;
				$("#userlogin_modal").modal('hide');
				logined();
			}
			
		},
		error:function(){
			alert("服务器异常");
		}
	});
}

//已经登录
function logined(){
	$("#nav_user_li").html('<li><a class="btn"  >'+userInfo.user_name+'&emsp;<span class="glyphicon glyphicon-user"></span></a></li>');

}
//未登录
function login(){
	$("#nav_user_li").html('<li><a class="btn" onclick="login_modal()"  >登录&emsp;<span class="glyphicon glyphicon-user"></span></a></li>');

}


