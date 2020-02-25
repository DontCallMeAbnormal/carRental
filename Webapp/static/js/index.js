var indexVehicle;//首页的车程信息

var info_vehicle_id;//缓存详情页面的数据


$(document).ready(function(){
	getindexVehicle();
})


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
			
			str+=html01;
			str+='<img src="'+vehcile_base_photo+'" alt="null">'+
					'<div class="caption">'+
					'<h4>'+vehcile_base_brand+'  '+vehicle_base_model+
						'<p><small>'+vehcile_base_produced+'|'+vehcile_mileage+'万公里| '+vehcile_base_type+'</small></p></h4>'+
					
					'<div class="brand_footer">'+
					'<h4 class="price_lefttext"><span class="price_color">'+vehicle_price+'</span>元/天</h4>'+
					'<button onclick="placeorder('+i+')" class="btn btn-success">下单</button>'+
					'<button onclick="details('+i+')" class="btn btn-info">详情</button></div></div>';
			
			
			str+=html02;
						
		}
		productbox.html(str);
		
		
	}
	
}





//点击详情后
function details(i){
	info_vehicle_id=indexVehicle[i].vehicle_id;//将该车的数据传往后台
	window.location='details/'+info_vehicle_id;
}









